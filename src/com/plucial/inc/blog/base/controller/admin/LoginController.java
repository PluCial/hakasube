package com.plucial.inc.blog.base.controller.admin;

import java.net.URLEncoder;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.controller.BaseController;
import com.plucial.inc.blog.base.model.SystemModel;
import com.plucial.inc.blog.base.service.SystemService;

public class LoginController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        // クライアントIDを取得
        SystemModel clientIdModel = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID");
        if(clientIdModel == null) return redirect("/admin/settingFirst");
        
        // はじめての場合は設定画面を表示
        String googleProjectClientId = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID").getValue();
        if(googleProjectClientId == null) {
            return redirect("/admin/settingFirst");
        }
        
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/oauth2callback");

        String oauthUrl = "https://accounts.google.com/o/oauth2/auth?scope="
                + URLEncoder.encode(Constants.GOOGLE_DRIVE_API_SCOPE, "utf-8")
                + "&redirect_uri="
                + URLEncoder.encode(callbackURL.toString(), "utf-8")
                + "&response_type=code"
                + "&client_id="
                + googleProjectClientId
                + "&approval_prompt=force"
                + "&access_type=offline";

        requestScope("oauthUrl", oauthUrl);
        
        
        return forward("login.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "管理ログイン";
    }

    @Override
    protected String getMainMenuSelect() {
        return null;
    }
}
