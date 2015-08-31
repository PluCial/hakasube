package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;
import com.plucial.inc.blog.base.service.CategoryService;

public class ChangeCategoryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String articleId = asString("id");
        
        ArticleModel model = ArticleService.get(Long.valueOf(articleId));
        
        requestScope("articleModel", model);
        
        CategoryModel categoryModel = CategoryService.get(model.getCategoryModelRef().getKey().getId());
        requestScope("categoryModel", categoryModel);
        
        return forward("change_category.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "カテゴリの変更";
    }
}
