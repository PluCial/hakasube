package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.UserModel;

public class CategoryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        return forward("category.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "カテゴリ管理";
    }
}
