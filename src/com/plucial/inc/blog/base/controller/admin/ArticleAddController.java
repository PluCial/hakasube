package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.UserModel;

public class ArticleAddController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        return forward("article_add.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "記事の追加";
    }
}
