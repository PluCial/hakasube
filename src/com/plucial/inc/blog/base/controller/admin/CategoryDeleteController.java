package com.plucial.inc.blog.base.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.CategoryService;

public class CategoryDeleteController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("id");
        
        CategoryModel model = CategoryService.get(Long.valueOf(categoryId));
        
        requestScope("categoryModel", model);
        
        return forward("category_delete.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "カテゴリ削除";
    }
}
