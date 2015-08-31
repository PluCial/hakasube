package com.plucial.inc.blog.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.service.ArticleService;
import com.plucial.inc.blog.base.service.CategoryService;

public class CategoryController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        String categoryId = asString("id");
        
        // カテゴリの取得
        CategoryModel categoryModel = CategoryService.get(Long.valueOf(categoryId));
        
        if(categoryModel == null) redirect("/");
        
        // 記事リストの取得
        List<ArticleModel> articletList = ArticleService.getArticleListByCategory(20, categoryModel, null);
        
        // リクエストスコープの設定
        requestScope("categoryModel", categoryModel);
        requestScope("articletList", articletList == null ? new ArrayList<ArticleModel>() : articletList);
        requestScope("pageTitle", categoryModel.getName());
        
        return forward("category.jsp");
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
