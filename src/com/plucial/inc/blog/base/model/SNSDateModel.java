package com.plucial.inc.blog.base.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.Sort;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Text;
import com.plucial.inc.blog.base.meta.SNSTwitModelMeta;

@Model(schemaVersion = 1)
public class SNSDateModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * キー(String: 20140101)
     */
    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    /** 件数 */
    private int count;
    
    /** 投稿ユーザー名 */
    @Attribute(unindexed = true)
    private String userName;
    
    /** キャッチコピー */
    @Attribute(unindexed = true)
    private Text catchcopy;
    
    /** 作成日時 */
    private Date createDate;
    
    /** 作成した ArticleModelとの関連 */
    @Attribute(persistent = false)
    private InverseModelListRef<SNSTwitModel, SNSDateModel> twitModelListRef =
            new InverseModelListRef<SNSTwitModel, SNSDateModel>(
                    SNSTwitModel.class,
                    SNSTwitModelMeta.get().dateModelRef.getName(),
                    this,
                    new Sort(SNSTwitModelMeta.get().createDate, SortDirection.ASCENDING));

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SNSDateModel other = (SNSDateModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    
    public InverseModelListRef<SNSTwitModel, SNSDateModel> getTwitModelListRef() {
        return twitModelListRef;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Text getCatchcopy() {
        return catchcopy;
    }

    public void setCatchcopy(Text catchcopy) {
        this.catchcopy = catchcopy;
    }
    
    public String getCatchcopyString() {
        if (catchcopy == null) {
            return null;
        }
        return catchcopy.getValue();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
