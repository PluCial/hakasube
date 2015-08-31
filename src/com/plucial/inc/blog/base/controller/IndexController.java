package com.plucial.inc.blog.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.service.ArticleService;

public class IndexController extends BaseController {

    /**
     * ベース言語処理
     */
    @Override
    protected Navigation execute() throws Exception {
        
        // 新着
        List<ArticleModel> articletList = ArticleService.getNewArticleList(18, null);
        
        // リクエストスコープの設定
        requestScope("articletList", articletList == null ? new ArrayList<ArticleModel>() : articletList);
        
        
        return forward("index.jsp");
    }

    @Override
    protected String getPageTitle() {
        return null;
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_HOME;
    }
}
