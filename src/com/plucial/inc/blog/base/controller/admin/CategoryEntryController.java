package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.CategoryService;

public class CategoryEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        // 入力チェック
        if (!isPost() || !createValidate()) {
            return forward("/admin/category");
        }
        
        String name = asString("categoryName");
        
        CategoryService.put(name);
        
        
        return redirect("/admin/category");
    }
    
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        // カテゴリ
        v.add("categoryName", v.required());
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        return "カテゴリ管理";
    }
}
