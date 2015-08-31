package com.plucial.inc.blog.base.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.memcache.Memcache;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.plucial.inc.blog.base.Utils;
import com.plucial.inc.blog.base.dao.ArticleModelDao;
import com.plucial.inc.blog.base.meta.ArticleModelMeta;
import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;


public class ArticleService {
    
    private static ArticleModelDao dao = new ArticleModelDao();
    
    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JacksonFactory JSON_FACTORY = new JacksonFactory();
    
    /**
     * PUT
     * @param driveFileId
     * @return
     * @throws Exception
     */
    public static ArticleModel put(UserModel userModel, CategoryModel categoryModel, String driveFileId, String referenceUrl) throws Exception {
        
        // 記事を取得
        ArticleModel articleModel = getArticleByDriveFileId(driveFileId);
        
        if(articleModel == null) {
            articleModel = new ArticleModel();
            articleModel.setCreateDate(new Date());
        }
        
        // システム情報を取得
        String appName = SystemService.getByKey("GOOGLE_APPLICATION_NAME").getValue();
        String clientId = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID").getValue();
        String clientSecret = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_SECRET").getValue();
        String refreshToken = userModel.getRefreshToken();
        
        // トークン情報の作成
        GoogleCredential credential = new GoogleCredential.Builder()
        .setJsonFactory(JSON_FACTORY)
        .setTransport(TRANSPORT)
        .setClientSecrets(clientId, clientSecret).build()
        .setRefreshToken(refreshToken);
        
        // リフレッシュトークンを元にアクセストークンを更新
        credential.refreshToken();
        
        // ドライブサービスの生成
        Drive service = new Drive.Builder(new NetHttpTransport(), new JacksonFactory(), credential)
        .setApplicationName(appName)
        .build();
        
        // 対象のドライブファイルを取得
        File driveFile = service.files().get(driveFileId).execute();
        
        // ドキュメントのHTMLを取得
        HttpResponse resp =
                service.getRequestFactory().buildGetRequest(new GenericUrl(driveFile.getExportLinks().get("text/html")))
                    .execute();
        InputStream stream = (InputStream) resp.getContent();
        
        // HTML パーサーの生成
        Document document = Jsoup.parse(stream, "utf-8", driveFile.getExportLinks().get("text/html"));
        
        // HTML の整形
        Utils.deleteWidthAndHeightStyle(document, "span");
        Utils.deleteWidthAndHeightStyle(document, "img");
        
        // 記事情報の更新
        String title =  driveFile.getTitle();
        String content = document.body().html();
        String style = Utils.changeCss(document);
        
        // 基本情報
        articleModel.setDriveFileId(driveFileId);
        articleModel.setTitle(title);
        articleModel.setReferenceUrl(new Text(referenceUrl));
        articleModel.setContent(new Text(content));
        articleModel.setDocumentStyleSheet(new Text(style));
        articleModel.setPublicFlg(true);
        articleModel.setUpdateDate(new Date());
        // 関連
        articleModel.getUserModelRef().setModel(userModel);
        articleModel.getCategoryModelRef().setModel(categoryModel);
        
        
        // 追加＆更新
        return put(articleModel);
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static ArticleModel put(ArticleModel model) {
        // 永久化
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());

        return model;
    }
    
    /**
     * IDから記事を取得
     * @param id
     * @return
     */
    public static ArticleModel get(long id) {
        Key key = createKey(id);
        ArticleModel model = Memcache.get(key.toString());
        if(model != null) return model;

        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * driveFileIdから記事を取得
     * @param driveFileId
     * @return
     */
    public static ArticleModel getArticleByDriveFileId(String driveFileId) {

        return dao.getArticleByDriveFileId(driveFileId);
    }
    
    /**
     * 新しい記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public static S3QueryResultList<ArticleModel> getNewArticleList(int num, String cursor) {
        
        S3QueryResultList<ArticleModel> list = dao.getNewArticleList(num, cursor);
        
        System.out.println("List Ok");
        
        // カテゴリModel を設定
        for(ArticleModel articleModel: list) {
            try {
                if(articleModel.getCategoryModelRef() != null && articleModel.getCategoryModelRef().getKey() != null) {
                    CategoryModel categoryModel = CategoryService.get(articleModel.getCategoryModelRef().getKey().getId());
                    articleModel.setArticleCategoryModel(categoryModel);
                }
            }catch(Exception e) {}
        }
        
        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public static S3QueryResultList<ArticleModel> getArticleListByCategory(int num, CategoryModel categoryModel, String cursor) {
        S3QueryResultList<ArticleModel> list =  dao.getArticleListByCategory(categoryModel, num, cursor);
        
        // カテゴリModel を設定
        for(ArticleModel articleModel: list) {
            CategoryModel articleCategoryModel = CategoryService.get(articleModel.getCategoryModelRef().getKey().getId());
            articleModel.setArticleCategoryModel(articleCategoryModel);
        }
        
        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(サイトマップ用)
     * @param categoryModel
     * @return
     */
    public static List<ArticleModel> getArticleListByCategory(CategoryModel categoryModel) {
        return dao.getArticleListByCategory(categoryModel);
    }
    
    /**
     * 記事の削除
     * @param category
     * @return
     */
    public static void delete(ArticleModel model) {
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());
        
        dao.delete(model.getKey());
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(long id) {
        return Datastore.createKey(ArticleModelMeta.get(), id);
    }

}
