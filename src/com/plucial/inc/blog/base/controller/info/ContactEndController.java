package com.plucial.inc.blog.base.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.controller.BaseController;

public class ContactEndController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        return forward("contactEnd.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "お問い合わせありがとうございました。";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_CONTACT;
    }
}
