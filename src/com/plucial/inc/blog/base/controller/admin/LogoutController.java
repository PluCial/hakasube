package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.UserModel;

public class LogoutController extends BaseController {

    @Override
    protected Navigation execute(UserModel userModel)
            throws Exception {
        // セッション削除
        removeSessionScope("userModel");

        return redirect("/admin/login");
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
