package com.plucial.inc.blog.base.controller.admin;

import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.controller.BaseController;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.SystemService;
import com.plucial.inc.blog.base.service.UserService;

public class SettingFirstController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        // はじめてではない場合の入力チェック
        List<UserModel> userList = UserService.getUserList();
        if(userList != null && userList.size() > 0) {
            return null;
        }
        
        try {
            // Google
            String googleApplicationName = SystemService.getByKey("GOOGLE_APPLICATION_NAME").getValue();
            String googleProjectClientId = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID").getValue();
            String googleProjectClientSecret = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_SECRET").getValue();

            // Project
            String applecationName = SystemService.getByKey("PROJECT_APPLECATION_NAME").getValue();
            String adminAccountEmail = SystemService.getByKey("PROJECT_ADMIN_ACCOUNT_EMAIL").getValue();


            requestScope("googleApplicationName", googleApplicationName);
            requestScope("googleProjectClientId", googleProjectClientId);
            requestScope("googleProjectClientSecret", googleProjectClientSecret);

            requestScope("applecationName", applecationName);
            requestScope("adminAccountEmail", adminAccountEmail);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        return forward("setting_first.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "システム設定(初回)";
    }

    @Override
    protected String getMainMenuSelect() {
        return null;
    }
}
