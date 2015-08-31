package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;
import com.plucial.inc.blog.base.service.CategoryService;

public class ChangeCategoryEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        // 入力チェック
        if (!isPost() || !createValidate()) {
            return forward("/admin/articleAdd");
        }
        
        String articleId = asString("id");
        ArticleModel model = ArticleService.get(Long.valueOf(articleId));
        
        String category = asString("category");
        CategoryModel categoryModel = CategoryService.get(Long.valueOf(category));
        
        model.getCategoryModelRef().setModel(categoryModel);
        
        ArticleService.put(model);
        
        return redirect("/admin/article");
    }
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        // カテゴリ
        v.add("category", v.required());
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
