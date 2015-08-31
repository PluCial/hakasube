package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;

public class ArticleUpdateController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String articleId = asString("id");
        ArticleModel model = ArticleService.get(Long.valueOf(articleId));
        
        ArticleService.put(
            model.getUserModelRef().getModel(), 
            model.getCategoryModelRef().getModel(), 
            model.getDriveFileId(),
            model.getReferenceUrlString());
        
        return redirect("/admin/article");
    }

    @Override
    protected String getPageTitle() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }
}
