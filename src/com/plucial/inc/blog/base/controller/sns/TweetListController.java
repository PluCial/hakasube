package com.plucial.inc.blog.base.controller.sns;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.controller.BaseController;
import com.plucial.inc.blog.base.model.SNSDateModel;
import com.plucial.inc.blog.base.model.SNSTwitModel;
import com.plucial.inc.blog.base.service.SNSDateService;
import com.plucial.inc.blog.base.service.SNSTwitService;
import com.plucial.inc.blog.base.service.SystemService;

public class TweetListController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        String date = asString("date");
        
        SNSDateModel snsDateModel = SNSDateService.get(date);
        if(snsDateModel == null) return null;
        
        List<SNSTwitModel> snsTwitList = SNSTwitService.getListByDateModel(snsDateModel);
        
        // リクエストスコープの設定
        requestScope("snsDateModel", snsDateModel);
        requestScope("snsTwitList", snsTwitList == null ? new ArrayList<SNSTwitModel>() : snsTwitList);
        
        try {
            String twitterSearchKeyWord = SystemService.getByKey("TWITTER_SEARCH_KEYWORD").getValue();
            requestScope("pageTitle", twitterSearchKeyWord + "情報(" + snsDateModel.getKey().getName() + ")");
        }catch(Exception e) {}
        
        return forward("tweet_list.jsp");
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
