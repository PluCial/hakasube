package com.plucial.inc.blog.base.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;

public class ArticleController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        List<ArticleModel> articleList = ArticleService.getNewArticleList(30, null);
        
        requestScope("articleList", articleList == null ? new ArrayList<ArticleModel>() : articleList);
        
        return forward("article.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "記事管理";
    }
}
