package com.plucial.inc.blog.base.controller.admin.twitter;

import org.slim3.controller.Navigation;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import com.plucial.inc.blog.base.controller.admin.BaseController;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;

/**
 * Twitter OAuthコントローラー
 * @author takahara
 *
 */
public class OAuthController extends BaseController {

    private static TwitterFactory twitterFactory = new TwitterFactory();

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String twitterAppApiKey = SystemService.getByKey("TWITTER_APP_API_KEY").getValue();
        String twitterAppApiSecret = SystemService.getByKey("TWITTER_APP_API_SECRET").getValue();
        
        // Titterオブジェクトの生成
        Twitter twitter = twitterFactory.getInstance();
        twitter.setOAuthConsumer(twitterAppApiKey, twitterAppApiSecret);

        // リクエストトークンの生成
        RequestToken twitterRequestToken = twitter.getOAuthRequestToken();

        // RequestTokenをセッションに保存しておきます。
        sessionScope("twitter", twitter);
        sessionScope("twitterRequestToken", twitterRequestToken);

        // 認証画面にリダイレクトするためのURLを生成
        String oauthUrl = twitterRequestToken.getAuthorizationURL();

        return redirect(oauthUrl);
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
