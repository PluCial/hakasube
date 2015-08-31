package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;

public class ArticleDeleteController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String articleId = asString("id");
        
        ArticleModel model = ArticleService.get(Long.valueOf(articleId));
        
        requestScope("articleModel", model);
        
        return forward("article_delete.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "記事の削除";
    }
}
