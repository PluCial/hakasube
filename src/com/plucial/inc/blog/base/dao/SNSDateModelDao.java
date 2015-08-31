package com.plucial.inc.blog.base.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.datastore.Sort;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Query.SortDirection;
import com.plucial.inc.blog.base.meta.SNSDateModelMeta;
import com.plucial.inc.blog.base.model.SNSDateModel;

public class SNSDateModelDao extends DaoBase<SNSDateModel>{
    
    SNSDateModelMeta meta = SNSDateModelMeta.get();
    
    public S3QueryResultList<SNSDateModel> getList(int num) {

        S3QueryResultList<SNSDateModel> list = Datastore.query(meta)
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .limit(num)
                .asQueryResultList();

        return list;
    }

    public S3QueryResultList<SNSDateModel> getList(int num, String cursor) {

        if (StringUtil.isEmpty(cursor)) return getList(num);

        S3QueryResultList<SNSDateModel> list = Datastore.query(meta)
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .encodedStartCursor(cursor)
                .limit(num)
                .asQueryResultList();

        return list;
    }
    
    /**
     * リスト(サイトマップ用)
     * @return
     */
    public List<SNSDateModel> getList() {

        List<SNSDateModel> list = Datastore.query(meta)
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .asList();

        return list;
    }

}
