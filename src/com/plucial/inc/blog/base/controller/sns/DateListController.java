package com.plucial.inc.blog.base.controller.sns;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.controller.BaseController;
import com.plucial.inc.blog.base.model.SNSDateModel;
import com.plucial.inc.blog.base.service.SNSDateService;
import com.plucial.inc.blog.base.service.SystemService;

public class DateListController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        List<SNSDateModel> snsDateList = SNSDateService.getList(30, null);
        
        // リクエストスコープの設定
        requestScope("snsDateList", snsDateList == null ? new ArrayList<SNSDateModel>() : snsDateList);
        
        try {
            String twitterSearchKeyWord = SystemService.getByKey("TWITTER_SEARCH_KEYWORD").getValue();
            requestScope("pageTitle", twitterSearchKeyWord + "情報");
        }catch(Exception e) {}
        
        return forward("date_list.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "SNS情報";
    }

    @Override
    protected String getMainMenuSelect() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
