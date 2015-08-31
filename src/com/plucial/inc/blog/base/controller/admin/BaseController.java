package com.plucial.inc.blog.base.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.CategoryService;
import com.plucial.inc.blog.base.service.SystemService;

public abstract class BaseController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        
        try {
            UserModel loginUserModel = getLoginUser();

            requestScope("isLogin", String.valueOf(loginUserModel != null));
            requestScope("loginUserModel", loginUserModel);
            
            requestScope("isSmartPhone", String.valueOf(isSmartPhone()));

            requestScope("pageTitle", getPageTitle());
            
            try {
                requestScope("projectApplecationName", SystemService.getByKey("PROJECT_APPLECATION_NAME").getValue());
            }catch(Exception e) {}
            
            // 記事カテゴリ
            List<CategoryModel> categoryList = CategoryService.getCategoryList();
            requestScope("categoryList", categoryList == null ? new ArrayList<CategoryModel>() : categoryList);
            
            // ログインしていない場合
            return execute(loginUserModel);

        }catch(Exception e) {
            e.printStackTrace();
            return redirect("/admin/login");
        }
    }
    
    /**
     * 登録ユーザーの場合、登録情報を取得する。
     * 登録ユーザーではない、もしくGoogleアカウントにログインしていない場合は、
     * エラーを生成
     * @return
     * @throws Exception
     */
    public UserModel getLoginUser() throws Exception {

        UserModel userModel = sessionScope("userModel");

        if(userModel == null) throw new Exception();

        return userModel;
    }

    /**
     * デバイスがスマートフォンであるか判定
     * @param request
     * @return
     */
    protected boolean isSmartPhone() {

        String userAgent = request.getHeader("User-Agent").toLowerCase();

        if(userAgent != null && (userAgent.indexOf("iphone") > 0 || userAgent.indexOf("android") > 0)) {
            return true;
        }

        return false;
    }

    /**
     * リクエスト処理
     * @return
     * @throws Exception
     */
    protected abstract Navigation execute(UserModel loginUserModel) throws Exception;

    /**
     * ページタイトルの設定
     * @return
     * @throws Exception
     */
    protected abstract String getPageTitle();

}
