package com.plucial.inc.blog.base.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.plucial.inc.blog.base.meta.UserModelMeta;
import com.plucial.inc.blog.base.model.UserModel;

public class UserModelDao extends DaoBase<UserModel>{
    
    /** UserModel Meta */
    UserModelMeta meta = UserModelMeta.get();
    
    /**
     * Email からユーザーモデルを取得
     * @param twitterUserId
     * @return
     */
    public UserModel getUserModelByEmail(String email) {
        return Datastore.query(meta)
                .filter(meta.email.equal(email))
                .asSingle();
    }
    
    /**
     * Email からユーザーモデルを取得
     * @param twitterUserId
     * @return
     */
    public List<UserModel> getUserList() {
        return Datastore.query(meta)
                .asList();
    }

}
