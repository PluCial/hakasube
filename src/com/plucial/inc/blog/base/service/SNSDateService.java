package com.plucial.inc.blog.base.service;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.plucial.inc.blog.base.DateUtils;
import com.plucial.inc.blog.base.dao.SNSDateModelDao;
import com.plucial.inc.blog.base.meta.SNSDateModelMeta;
import com.plucial.inc.blog.base.model.SNSDateModel;

public class SNSDateService {
    
    private static SNSDateModelDao dao = new SNSDateModelDao();
    
    private static final String TWIT_DATE_LIST_MEMCACHE_KEY = "twit_date_list";
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static SNSDateModel put(SNSDateModel model) {
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());
        // リストのキャッシュをクリア
        Memcache.delete(TWIT_DATE_LIST_MEMCACHE_KEY);
        
        return model;
    }
    
    /**
     * PUT
     * @return
     */
    public static SNSDateModel put(int count, String userName, String catchcopy) {
        
        SNSDateModel model = new SNSDateModel();
        model.setKey(createKey(DateUtils.dateToString(new Date(), "yyyyMMdd")));
        model.setCount(count);
        model.setUserName(userName);
        model.setCatchcopy(new Text(catchcopy));
        model.setCreateDate(new Date());
        
        return put(model);
    }
    
    
    /**
     * Modelの取得
     * @param category
     * @return
     */
    public static SNSDateModel get(String date) {
        
        Key key = createKey(date);
        SNSDateModel model = Memcache.get(key.toString());
        if(model != null) return model;
        
        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * リストの取得
     * @return
     */
    public static S3QueryResultList<SNSDateModel> getList(int num, String cursor) {
        return dao.getList(num, cursor);
    }
    
    /**
     * リスト(サイトマップ用)
     * @return
     */
    public static List<SNSDateModel> getList() {
        return dao.getList();
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(String dateString) {
        return Datastore.createKey(SNSDateModelMeta.get(), dateString);
    }

}
