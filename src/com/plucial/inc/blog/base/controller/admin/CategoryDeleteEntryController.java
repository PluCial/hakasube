package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.CategoryService;

public class CategoryDeleteEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("id");
        CategoryService.delete(Long.valueOf(categoryId));
        
        return redirect("/admin/category");
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
