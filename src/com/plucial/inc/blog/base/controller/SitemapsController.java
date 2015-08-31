package com.plucial.inc.blog.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.SNSDateModel;
import com.plucial.inc.blog.base.service.CategoryService;
import com.plucial.inc.blog.base.service.SNSDateService;
import com.plucial.inc.blog.base.service.SystemService;

public class SitemapsController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<CategoryModel> caetgoryList = CategoryService.getCategoryList();
        List<SNSDateModel> snsDateList = SNSDateService.getList();
        
        // リクエストスコープの設定
        requestScope("caetgoryList", caetgoryList == null ? new ArrayList<CategoryModel>() : caetgoryList);
        requestScope("snsDateList", snsDateList == null ? new ArrayList<SNSDateModel>() : snsDateList);
        
        try {
            // ドメイン
            String applicationDomain = SystemService.getByKey("APPLICATION_DOMAIN").getValue();
            requestScope("applicationDomain", applicationDomain);
        }catch(Exception e) {
            // 存在しない場合はエラーになるが無視
        }
        
        return forward("sitemaps.jsp");
    }
}
