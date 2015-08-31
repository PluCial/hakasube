package com.plucial.inc.blog.base.controller;

import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.service.ArticleService;

public class ArticleController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        // 記事ID
        String id = asString("id");
        
        // 対象記事の取得
        ArticleModel articleModel = ArticleService.get(Long.valueOf(id));
        if(articleModel == null) redirect("/");
        
        // 親のカテゴリを取得
        CategoryModel categoryModel = articleModel.getCategoryModelRef().getModel();
        List<ArticleModel> categoryArticleList = ArticleService.getArticleListByCategory(categoryModel);
        
        // リクエストスコープ
        requestScope("pageTitle", articleModel.getTitle());
        requestScope("articleModel", articleModel);
        requestScope("categoryModel", categoryModel);
        requestScope("categoryArticleList", categoryArticleList); // BaseControllerを上書き

        return forward("article.jsp");
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_BLOG;
    }
}
