package com.plucial.inc.blog.base.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.Constants;
import com.plucial.inc.blog.base.controller.BaseController;

public class AboutController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        return forward("about.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "このサイトについて";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_ABOUT;
    }
}
