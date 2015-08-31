package com.plucial.inc.blog.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.service.ArticleService;
import com.plucial.inc.blog.base.service.CategoryService;
import com.plucial.inc.blog.base.service.SystemService;

public abstract class BaseController extends Controller {

    @Override
    protected Navigation run() throws Exception {

        // リクエストスコープの設定
        requestScope("isSmartPhone", String.valueOf(isSmartPhone()));
        requestScope("pageTitle", getPageTitle());
        requestScope("mainMenuSelect", getMainMenuSelect());
        
        try {
            requestScope("projectApplecationName", SystemService.getByKey("PROJECT_APPLECATION_NAME").getValue());
            requestScope("pageDescription", SystemService.getByKey("PROJECT_DESCRIPTION").getValue());
            requestScope("analyticsId", SystemService.getByKey("ANALYTICS_ID").getValue());
            requestScope("socialTwitterUrl", SystemService.getByKey("SOCIAL_TWITTER_URL").getValue());
            requestScope("socialFacebookUrl", SystemService.getByKey("SOCIAL_FACEBOOK_URL").getValue());
            requestScope("socialGooglePlusUrl", SystemService.getByKey("SOCIAL_GOOGLE_PLUS_URL").getValue());
            requestScope("twitterSearchKeyword", SystemService.getByKey("TWITTER_SEARCH_KEYWORD").getValue());
        }catch(Exception e) {}
            
        
        // 記事カテゴリ
        List<CategoryModel> categoryList = CategoryService.getCategoryList();
        requestScope("categoryList", categoryList == null ? new ArrayList<CategoryModel>() : categoryList);
        
        // newArticleList
        List<ArticleModel> newArticleList = ArticleService.getNewArticleList(6, null);
        requestScope("newArticleList", newArticleList == null ? new ArrayList<ArticleModel>() : newArticleList);
        
        return execute();
    }

    /**
     * デバイスがスマートフォンであるか判定
     * @param request
     * @return
     */
    protected boolean isSmartPhone() {

        if(request.getHeader("User-Agent") != null) {
            String userAgent = request.getHeader("User-Agent").toLowerCase();

            if(userAgent != null && (userAgent.indexOf("iphone") > 0 || userAgent.indexOf("android") > 0)) {
                return true;
            }
        }

        return false;
    }

    /**
     * リクエスト処理
     * @return
     * @throws Exception
     */
    protected abstract Navigation execute() throws Exception;
    

    /**
     * ページタイトルの設定
     * @return
     * @throws Exception
     */
    protected abstract String getPageTitle();
    
    /**
     * ページURIを取得
     * @return
     * @throws Exception
     */
    protected abstract String getMainMenuSelect();

}
