package com.plucial.inc.blog.base.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Sort;

import com.google.appengine.api.datastore.Query.SortDirection;
import com.plucial.inc.blog.base.meta.CategoryModelMeta;
import com.plucial.inc.blog.base.model.CategoryModel;

public class CategoryModelDao extends DaoBase<CategoryModel>{
    
    /** Meta */
    CategoryModelMeta meta = CategoryModelMeta.get();
    
    /**
     * カテゴリリストの取得
     * @return
     */
    public List<CategoryModel> getCategoryList() {
        
        return Datastore.query(meta)
                .sort(new Sort(meta.index, SortDirection.ASCENDING))
                .asList();
    }

}
