package com.plucial.inc.blog.base.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.controller.BaseController;

public class DevelopmentController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        return forward("development.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "システム開発";
    }

    @Override
    protected String getMainMenuSelect() {
        return null;
    }
}
