package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.inc.blog.base.controller.BaseController;
import com.plucial.inc.blog.base.service.SystemService;

public class SettingFirstEntryController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        // 入力チェック
        if (!isPost() || !createValidate()) {
            return forward("/admin/settingFirst");
        }
        
        // パラメーターの取得
        String googleApplicationName = asString("googleApplicationName");
        String googleProjectClientId = asString("googleProjectClientId");
        String googleProjectClientSecret = asString("googleProjectClientSecret");
        String applecationName = asString("applecationName");
        String adminAccountEmail = asString("adminAccountEmail");
        
        // 登録
        SystemService.put("GOOGLE_APPLICATION_NAME", googleApplicationName);
        SystemService.put("GOOGLE_PROJECT_CLIENT_ID", googleProjectClientId);
        SystemService.put("GOOGLE_PROJECT_CLIENT_SECRET", googleProjectClientSecret);
        SystemService.put("PROJECT_APPLECATION_NAME", applecationName);
        SystemService.put("PROJECT_ADMIN_ACCOUNT_EMAIL", adminAccountEmail);
        
        
        return redirect("/admin/login");
    }
    
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        v.add("googleApplicationName", v.required());
        v.add("googleProjectClientId", v.required());
        v.add("googleProjectClientSecret", v.required());
        v.add("applecationName", v.required());
        v.add("adminAccountEmail", v.required());
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        return null;
    }


    @Override
    protected String getMainMenuSelect() {
        return null;
    }
}
