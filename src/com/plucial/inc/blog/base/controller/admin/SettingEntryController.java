package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;

public class SettingEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        // 入力チェック
        if (!isPost() || !createValidate()) {
            return forward("/admin/setting");
        }
        
        // パラメーターの取得
        String applicationDomain = asString("applicationDomain");
        String googleApplicationName = asString("googleApplicationName");
        String googleProjectClientId = asString("googleProjectClientId");
        String googleProjectClientSecret = asString("googleProjectClientSecret");
        String applecationName = asString("applecationName");
        String adminAccountEmail = asString("adminAccountEmail");
        
        String projectDescription = asString("projectDescription");
        String twitterAppApiKey = asString("twitterAppApiKey");
        String twitterAppApiSecret = asString("twitterAppApiSecret");
        String twitterSearchKeyword = asString("twitterSearchKeyword");
        String analyticsId = asString("analyticsId");
        
        String socialTwitterUrl = asString("socialTwitterUrl");
        String socialFacebookUrl = asString("socialFacebookUrl");
        String socialGooglePlusUrl = asString("socialGooglePlusUrl");
        
        // 登録
        SystemService.put("APPLICATION_DOMAIN", applicationDomain);
        
        SystemService.put("GOOGLE_APPLICATION_NAME", googleApplicationName);
        SystemService.put("GOOGLE_PROJECT_CLIENT_ID", googleProjectClientId);
        SystemService.put("GOOGLE_PROJECT_CLIENT_SECRET", googleProjectClientSecret);
        SystemService.put("PROJECT_APPLECATION_NAME", applecationName);
        SystemService.put("PROJECT_ADMIN_ACCOUNT_EMAIL", adminAccountEmail);
        
        SystemService.put("PROJECT_DESCRIPTION", projectDescription);
        SystemService.put("TWITTER_APP_API_KEY", twitterAppApiKey);
        SystemService.put("TWITTER_APP_API_SECRET", twitterAppApiSecret);
        SystemService.put("TWITTER_SEARCH_KEYWORD", twitterSearchKeyword);
        SystemService.put("ANALYTICS_ID", analyticsId);
        
        SystemService.put("SOCIAL_TWITTER_URL", socialTwitterUrl);
        SystemService.put("SOCIAL_FACEBOOK_URL", socialFacebookUrl);
        SystemService.put("SOCIAL_GOOGLE_PLUS_URL", socialGooglePlusUrl);
        
        
        return redirect("/admin/setting");
    }
    
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        v.add("applicationDomain", v.required());
        
        v.add("googleApplicationName", v.required());
        v.add("googleProjectClientId", v.required());
        v.add("googleProjectClientSecret", v.required());
        v.add("applecationName", v.required());
        v.add("adminAccountEmail", v.required());
        
        v.add("projectDescription");
        v.add("twitterAppApiKey");
        v.add("twitterAppApiSecret");
        v.add("twitterSearchKeyword");
        v.add("analyticsId");
        
        v.add("socialTwitterUrl");
        v.add("socialFacebookUrl");
        v.add("socialGooglePlusUrl");
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        return null;
    }
}
