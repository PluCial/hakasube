package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;

public class SettingController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        try {
            // ドメイン
            String applicationDomain = SystemService.getByKey("APPLICATION_DOMAIN").getValue();
            requestScope("applicationDomain", applicationDomain);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            // Google
            String googleApplicationName = SystemService.getByKey("GOOGLE_APPLICATION_NAME").getValue();
            requestScope("googleApplicationName", googleApplicationName);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        try {
            String googleProjectClientId = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID").getValue();
            requestScope("googleProjectClientId", googleProjectClientId);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            String googleProjectClientSecret = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_SECRET").getValue();
            requestScope("googleProjectClientSecret", googleProjectClientSecret);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            // Project
            String applecationName = SystemService.getByKey("PROJECT_APPLECATION_NAME").getValue();
            requestScope("applecationName", applecationName);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            String adminAccountEmail = SystemService.getByKey("PROJECT_ADMIN_ACCOUNT_EMAIL").getValue();
            requestScope("adminAccountEmail", adminAccountEmail);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            String projectDescription = SystemService.getByKey("PROJECT_DESCRIPTION").getValue();
            requestScope("projectDescription", projectDescription);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        // Twitter
        try {
            String twitterAppApiKey = SystemService.getByKey("TWITTER_APP_API_KEY").getValue();
            requestScope("twitterAppApiKey", twitterAppApiKey);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            String twitterAppApiSecret = SystemService.getByKey("TWITTER_APP_API_SECRET").getValue();
            requestScope("twitterAppApiSecret", twitterAppApiSecret);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        try {
            String twitterSearchKeyword = SystemService.getByKey("TWITTER_SEARCH_KEYWORD").getValue();
            requestScope("twitterSearchKeyword", twitterSearchKeyword);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        try {
            String twitterAccessToken = SystemService.getByKey("TWITTER_ACCESS_TOKEN").getValue();
            requestScope("twitterAccessToken", twitterAccessToken);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        try {
            String twitterTokenSecret = SystemService.getByKey("TWITTER_TOKEN_SECRET").getValue();
            requestScope("twitterTokenSecret", twitterTokenSecret);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        // etc
        try {
            String analyticsId = SystemService.getByKey("ANALYTICS_ID").getValue();
            requestScope("analyticsId", analyticsId);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        // ソーシャル
        try {
            String socialTwitterUrl = SystemService.getByKey("SOCIAL_TWITTER_URL").getValue();
            requestScope("socialTwitterUrl", socialTwitterUrl);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        try {
            String socialFacebookUrl = SystemService.getByKey("SOCIAL_FACEBOOK_URL").getValue();
            requestScope("socialFacebookUrl", socialFacebookUrl);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        try {
            String socialGooglePlusUrl = SystemService.getByKey("SOCIAL_GOOGLE_PLUS_URL").getValue();
            requestScope("socialGooglePlusUrl", socialGooglePlusUrl);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }

        return forward("setting.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "システム設定";
    }
}
