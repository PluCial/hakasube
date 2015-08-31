package com.plucial.inc.blog.base.service;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.plucial.inc.blog.base.Utils;
import com.plucial.inc.blog.base.dao.SNSTwitModelDao;
import com.plucial.inc.blog.base.meta.SNSTwitModelMeta;
import com.plucial.inc.blog.base.model.SNSDateModel;
import com.plucial.inc.blog.base.model.SNSTwitModel;


public class SNSTwitService {
    
    private static SNSTwitModelDao dao = new SNSTwitModelDao();
    
    private static final String TWIT_LIST_BY_DATE_MEMCACHE_KEY = "twit_list_by_date";
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static SNSTwitModel put(SNSTwitModel model) {
        // 永久化
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());

        return model;
    }
    
    /**
     * PUT
     * @param dateModel
     * @param twitId
     * @param userId
     * @param userName
     * @param content
     * @return
     */
    public static SNSTwitModel put(SNSDateModel dateModel, String twitId, String userId, String userName, String content) {
        
        SNSTwitModel model = new SNSTwitModel();
        model.setKey(createKey(twitId));
        model.setUserId(userId);
        model.setUserName(userName);
        model.setContent(new Text(content));
        model.setCreateDate(new Date());
        model.getDateModelRef().setModel(dateModel);
        
        put(model);
        
        // リストのキャッシュをクリア
        Memcache.delete(TWIT_LIST_BY_DATE_MEMCACHE_KEY + "_" + dateModel.getKey().getName());
        
        return model;
    }
    
    /**
     * 日付ModelからTwitリストを取得
     * @param dateModel
     * @return
     */
    public static List<SNSTwitModel> getListByDateModel(SNSDateModel dateModel) {
        
        List<SNSTwitModel> list = Memcache.get(TWIT_LIST_BY_DATE_MEMCACHE_KEY + "_" + dateModel.getKey().getName());
        if(Utils.isNotEmpty(list)) return list;

        list = dateModel.getTwitModelListRef().getModelList();
        if(Utils.isNotEmpty(list)) Memcache.put(TWIT_LIST_BY_DATE_MEMCACHE_KEY + "_" + dateModel.getKey().getName(), list);
        
        return list;
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(String id) {
        return Datastore.createKey(SNSTwitModelMeta.get(), id);
    }

}
