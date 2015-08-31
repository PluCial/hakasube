package com.plucial.inc.blog.base.service;

import java.util.List;

import com.plucial.inc.blog.base.dao.UserModelDao;
import com.plucial.inc.blog.base.model.UserModel;


public class UserService {
    
    private static UserModelDao dao = new UserModelDao();
    
    /**
     * Email からユーザーモデルを取得
     * @param twitterUserId
     * @return
     */
    public static UserModel getUserModelByEmail(String email) {
        return dao.getUserModelByEmail(email);
    }
    
    public static List<UserModel> getUserList() {
        return dao.getUserList();
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static UserModel put(UserModel model) {
        // 永久化
        dao.put(model);

        return model;
    }
    
    /**
     * PUT
     * @param email
     * @param userId
     * @param displayName
     * @param userImage
     * @param tagline
     * @param braggingRights
     * @param accessToken
     * @param refreshToken
     * @return
     */
    public static UserModel put(
            String email,
            String accessToken,
            String refreshToken) {

        UserModel userModel = new UserModel();

        // email
        if(email != null && !email.isEmpty()) {
            userModel.setEmail(email);
        }

        // アクセストークン
        if(accessToken != null && !accessToken.isEmpty()) {
            userModel.setAccessToken(accessToken);
        }

        // リフレッシュトークン
        if(refreshToken != null && !refreshToken.isEmpty()) {
            userModel.setRefreshToken(refreshToken);
        }

        return put(userModel);
    }

}
