package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Tokeninfo;
import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;
import com.plucial.inc.blog.base.service.UserService;

public class Oauth2callbackController extends Controller {
    
    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JacksonFactory JSON_FACTORY = new JacksonFactory();

    @Override
    public Navigation run() throws Exception {
        
        String error = asString("error");

        // 承認をキャンセルした場合などの承認エラーが発生した場合
        if(error != null && error.length() > 0) {
            return redirect("/account/login");
        }

        try {

            // ユーザーログイン
            login();

        }catch(Exception e) {
            e.printStackTrace();
            throw new UnauthorizedException("No Login:login");
        }
        
        return redirect("/admin/article");
    }
    
    /**
     * ユーザー登録
     * @return
     * @throws Exception
     */
    private void login() throws Exception {

        String code = asString("code");
        
        String googleApplicationName = SystemService.getByKey("GOOGLE_APPLICATION_NAME").getValue();
        String googleProjectClientId = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID").getValue();
        String googleProjectClientSecret = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_SECRET").getValue();
        String adminAccountEmail = SystemService.getByKey("PROJECT_ADMIN_ACCOUNT_EMAIL").getValue();

        // ---------------------------------------------------------
        // トークン情報の取得
        // ---------------------------------------------------------

        // 承認コードをアクセス・更新トークンにアップグレードします。
        GoogleTokenResponse tokenResponse =
                new GoogleAuthorizationCodeTokenRequest(
                    TRANSPORT,
                    JSON_FACTORY,
                    googleProjectClientId,
                    googleProjectClientSecret,
                    code,
                    request.getRequestURL().toString()).execute();

        // トークン情報の取得（アクセストークン、リフレッシュトークン・・・）
        GoogleCredential credential = new GoogleCredential.Builder()
        .setJsonFactory(JSON_FACTORY)
        .setTransport(TRANSPORT)
        .setClientSecrets(googleProjectClientId, googleProjectClientSecret).build()
        .setFromTokenResponse(tokenResponse);


        // ---------------------------------------------------------
        // トークン情報の有効チェック
        // ---------------------------------------------------------
        // トークンの有効チェック
        Oauth2 oauth2 = new Oauth2.Builder(
            TRANSPORT, JSON_FACTORY, credential)
        .setApplicationName(googleApplicationName)
        .build();

        Tokeninfo tokenInfo = oauth2.tokeninfo()
            .setAccessToken(credential.getAccessToken()).execute();
        // トークン情報にエラーがあれば、中断すしま。
        if (tokenInfo.containsKey("error")) {
            throw new Exception();
        }

        // 受け取ったトークンが自分のアプリのものであることを確認します。
        if (!tokenInfo.getIssuedTo().equals(googleProjectClientId)) {
            throw new Exception();
        }

        
        // ユーザー情報の取得
        UserModel userModel = UserService.getUserModelByEmail(tokenInfo.getEmail());
        
        if(userModel == null) {

            // ユーザー制限チェック
            if(!tokenInfo.getEmail().equals(adminAccountEmail) && !tokenInfo.getEmail().equals(Constants.TEST_ACCOUNT_EMAIL)) {
                throw new Exception();
            }
            

            // ---------------------------------------------------------
            // ユーザー登録
            // ---------------------------------------------------------
            userModel = UserService.put(
                tokenInfo.getEmail(),
                credential.getAccessToken(),
                credential.getRefreshToken()
                );
            
        }else {
            // ログインユーザーのアクセストークンとリフレッシュトークンを更新
            userModel.setAccessToken(credential.getAccessToken());
            if(credential.getRefreshToken() != null) {
                userModel.setRefreshToken(credential.getRefreshToken());
            }
            UserService.put(userModel);
            
        }
        
        // ユーザー情報をセッションに入れる
        sessionScope("userModel", userModel);
    }
}
