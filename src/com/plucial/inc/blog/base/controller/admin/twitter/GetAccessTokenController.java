package com.plucial.inc.blog.base.controller.admin.twitter;

import org.slim3.controller.Navigation;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.plucial.inc.blog.base.controller.admin.BaseController;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;

/**
 * Twitter ログインコントローラー
 * @author takahara
 *
 */
public class GetAccessTokenController extends BaseController {

    @Override
    protected Navigation execute(
            UserModel loginUserModel)
            throws Exception {
        // Titterオブジェクトの生成
        Twitter twitter = sessionScope("twitter");
        RequestToken twitterRequestToken = sessionScope("twitterRequestToken");
        String verifier = asString("oauth_verifier");

        AccessToken accessToken = null;
        
        // RequestTokenからAccessTokenを取得
        accessToken = twitter.getOAuthAccessToken(twitterRequestToken, verifier);
        
        // トークン情報の登録
        SystemService.put("TWITTER_ACCESS_TOKEN", accessToken.getToken());
        SystemService.put("TWITTER_TOKEN_SECRET", accessToken.getTokenSecret());

        return redirect("/admin/setting");
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
