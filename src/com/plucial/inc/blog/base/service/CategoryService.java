package com.plucial.inc.blog.base.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.plucial.inc.blog.base.Utils;
import com.plucial.inc.blog.base.dao.CategoryModelDao;
import com.plucial.inc.blog.base.meta.CategoryModelMeta;
import com.plucial.inc.blog.base.model.CategoryModel;


public class CategoryService {
    
    private static CategoryModelDao dao = new CategoryModelDao();
    
    private static final String CATEGORY_LIST_MEMCACHE_KEY = "category_list";
    
    /**
     * カテゴリの取得
     * @param category
     * @return
     */
    public static CategoryModel get(Long categoryId) {
        
        Key key = createKey(categoryId);
        CategoryModel model = Memcache.get(key.toString());
        if(model != null) return model;
        
        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * カテゴリリストの取得
     * @return
     */
    public static List<CategoryModel> getCategoryList() {
        
        List<CategoryModel> list = Memcache.get(CATEGORY_LIST_MEMCACHE_KEY);
        if(Utils.isNotEmpty(list)) return list;

        list = dao.getCategoryList();
        if(Utils.isNotEmpty(list)) Memcache.put(CATEGORY_LIST_MEMCACHE_KEY, list);
        
        return list;
    }
    
    /**
     * カテゴリのPUT
     * @param model
     * @return
     */
    public static CategoryModel put(CategoryModel model) {
        
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());
        // リストのキャッシュをクリア
        Memcache.delete(CATEGORY_LIST_MEMCACHE_KEY);
        
        return model;
    }
    
    /**
     * カテゴリの追加
     * @param category
     * @param name
     * @return
     */
    public static CategoryModel put(String name) {
        CategoryModel model = new CategoryModel();

        model.setName(name);
        
        return put(model);
    }
    
    /**
     * カテゴリの削除
     * @param category
     * @return
     */
    public static void delete(Long categoryId) {
        dao.delete(createKey(categoryId));
        // リストのキャッシュをクリア
        Memcache.delete(CATEGORY_LIST_MEMCACHE_KEY);
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(Long id) {
        return Datastore.createKey(CategoryModelMeta.get(), id);
    }

}
