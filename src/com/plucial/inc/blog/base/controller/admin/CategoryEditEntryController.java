package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.CategoryService;

public class CategoryEditEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("categoryId");
        String categoryName = asString("categoryName");
        String categoryIndex = asString("categoryIndex");
        
        // 入力チェック
        if (isPost() && createValidate()) {
            
            CategoryModel categoryModel = CategoryService.get(Long.valueOf(categoryId));
            categoryModel.setName(categoryName);
            categoryModel.setIndex(Integer.valueOf(categoryIndex));
            CategoryService.put(categoryModel);
            
        }
        
        return redirect("/admin/category");
    }
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        // カテゴリID
        v.add("categoryId", v.required());
        // カテゴリ名
        v.add("categoryName", v.required());
        // 表示順
        v.add("categoryIndex", v.required(), v.integerType());
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
