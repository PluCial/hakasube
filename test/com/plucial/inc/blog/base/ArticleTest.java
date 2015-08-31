package com.plucial.inc.blog.base;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.SystemModel;
import com.plucial.inc.blog.base.service.CategoryService;
import com.plucial.inc.blog.base.service.SystemService;

public class ArticleTest extends AppEngineTestCase {
    
    // ---------------------------------------------------------------------------
    // GOOGLE PROJECT 定数(サービス アカウント OAuth)
    // ---------------------------------------------------------------------------
    /** プロジェクト名 */
    public static final String GOOGLE_APPLICATION_NAME = "PluCial.inc";
    /** クライアントID */
    public static final String GOOGLE_PROJECT_CLIENT_ID = "795638059099-i00r2t818m9rp58a42vb04fgrhc725lu.apps.googleusercontent.com";
    /** クライアントシークレット */
    public static final String GOOGLE_PROJECT_CLIENT_SECRET = "RtBtLisOx67DaTyAzN1FpGl1";
    /** リフレッシュトークン */
    public static final String GOOGLE_PROJECT_REFRESH_TOKEN = "1/NYbhaAjV78AKW2F7FFzVrUm2wl2Hyfp-bNNFv4p5SRkMEudVrK5jSpoR30zcRFq6";
    
    // ---------------------------------------------------------------------------
    // Twitter 定数
    // ---------------------------------------------------------------------------
    /** Twitter App API Key */
    public static final String TWITTER_APP_API_KEY = "JNdhz1oOMFSqfMoyfHvxOLoGv";
    /** Twitter App API secret */
    public static final String TWITTER_APP_API_SECRET = "VRrbfEvT4NTiVi6pSeBYxG89BsA0OzD6UFz5rAd8sRBfOcLmnc";
    
    // ---------------------------------------------------------------------------
    // カテゴリ 定数
    // ---------------------------------------------------------------------------
    public static final String CATEGORY_NAME1 = "カテゴリ1";
    public static final String CATEGORY_NAME2 = "カテゴリ2";
    public static final String CATEGORY_NAME3 = "カテゴリ3";
    
    // ---------------------------------------------------------------------------
    // カテゴリ 変数
    // ---------------------------------------------------------------------------
    private CategoryModel category1Model;
    private CategoryModel category2Model;
    private CategoryModel category3Model;
    
    // ---------------------------------------------------------------------------
    // 記事 定数
    // ---------------------------------------------------------------------------
    public static final String ARTICLE_ID1 = "1nrI2YUEi-YZ8-yKSnRiAmmvaEV2RTTQJJd_6QHvVN2A";
    public static final String ARTICLE_ID2 = "15X8bvVF6na503Pl9Hnr0nR-qt_VI4JOOmc5hpd63Z_8";
    
    // ---------------------------------------------------------------------------
    // カテゴリ 変数
    // ---------------------------------------------------------------------------
//    private ArticleModel article1Model;
//    private ArticleModel article2Model;
    
    /**
     * テスト前処理
     * <pre>
     * SystemServiceから必要なパラメーターを登録
     * </pre>
     */
    @Before
    public void BeforeTest() {
        SystemService.put("GOOGLE_APPLICATION_NAME", GOOGLE_APPLICATION_NAME);
        SystemService.put("GOOGLE_PROJECT_CLIENT_ID", GOOGLE_PROJECT_CLIENT_ID);
        SystemService.put("GOOGLE_PROJECT_CLIENT_SECRET", GOOGLE_PROJECT_CLIENT_SECRET);
        SystemService.put("TWITTER_APP_API_KEY", TWITTER_APP_API_KEY);
        SystemService.put("TWITTER_APP_API_SECRET", TWITTER_APP_API_SECRET);
        
        SystemService.put("GOOGLE_PROJECT_REFRESH_TOKEN", GOOGLE_PROJECT_REFRESH_TOKEN);
    }

    /**
     * メインテスト
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        
        // システムパラメーター
        testSystemService();
        
        // カテゴリテスト
        testPutCategory();
        testGetCategoryList();
        testUpdateCategory();
        testDeleteCategory();
        
        // 記事
//        testPutArticle();
//        testGetArticleList();
//        testGetArticleListByCategory();
//        testUpdateArticle();
//        testDeleteArticle();
    }
    
    /**
     * システムの値が正しく設定しているかを確認
     * @throws Exception
     */
    public void testSystemService() throws Exception {
        SystemModel model1 = SystemService.getByKey("GOOGLE_APPLICATION_NAME");
        assertEquals(model1.getValue(), GOOGLE_APPLICATION_NAME);
        
        SystemModel model2 = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_ID");
        assertEquals(model2.getValue(), GOOGLE_PROJECT_CLIENT_ID);
        
        SystemModel model3 = SystemService.getByKey("GOOGLE_PROJECT_CLIENT_SECRET");
        assertEquals(model3.getValue(), GOOGLE_PROJECT_CLIENT_SECRET);
        
        SystemModel model4 = SystemService.getByKey("TWITTER_APP_API_KEY");
        assertEquals(model4.getValue(), TWITTER_APP_API_KEY);
        
        SystemModel model5 = SystemService.getByKey("TWITTER_APP_API_SECRET");
        assertEquals(model5.getValue(), TWITTER_APP_API_SECRET);
    }
    
    /**
     * カテゴリの登録を確認
     * @throws Exception
     */
    public void testPutCategory() throws Exception {
        category1Model = CategoryService.put(CATEGORY_NAME1);
        category2Model = CategoryService.put(CATEGORY_NAME2);
        category3Model = CategoryService.put(CATEGORY_NAME3);
    }
    
    /**
     * カテゴリ一覧の取得を確認
     * @throws Exception
     */
    public void testGetCategoryList() throws Exception {
        List<CategoryModel> list = CategoryService.getCategoryList();
        assertEquals(list.size(), 3);
        
        assertEquals(CategoryService.get(category1Model.getKey().getId()).getName(), CATEGORY_NAME1);
        assertEquals(CategoryService.get(category2Model.getKey().getId()).getName(), CATEGORY_NAME2);
        assertEquals(CategoryService.get(category3Model.getKey().getId()).getName(), CATEGORY_NAME3);
    }
    
    /**
     * カテゴリの更新を確認
     * @throws Exception
     */
    public void testUpdateCategory() throws Exception {
        category3Model.setName("category4");
        CategoryService.put(category3Model);
        
        assertEquals(CategoryService.get(category3Model.getKey().getId()).getName(), "category4");
    }
    
    /**
     * カテゴリの削除を確認
     * @throws Exception
     */
    public void testDeleteCategory() throws Exception {
        
        CategoryService.delete(category3Model.getKey().getId());
        
        List<CategoryModel> list = CategoryService.getCategoryList();
        assertEquals(list.size(), 2);
    }
    
    /**
     * 記事の登録を確認
     * @throws Exception
     */
    public void testPutArticle() throws Exception {
//        article1Model = ArticleService.put(category1Model, ARTICLE_ID1);
//        article2Model = null;
    }
    
    /**
     * 新着記事一覧の取得を確認
     * @throws Exception
     */
    public void testGetArticleList() throws Exception {
        throw new Exception();
    }
    
    /**
     * カテゴリの記事一覧の取得を確認
     * @throws Exception
     */
    public void testGetArticleListByCategory() throws Exception {
        throw new Exception();
    }
    
    /**
     * 記事の更新を確認
     * @throws Exception
     */
    public void testUpdateArticle() throws Exception {
        throw new Exception();
    }
    
    /**
     * 記事の削除を確認
     * @throws Exception
     */
    public void testDeleteArticle() throws Exception {
        throw new Exception();
    }
    
    
    
    /**
     * テスト後処理
     * <pre>
     * SystemModelの削除
     * CategoryModelの削除
     * ArticleModelの削除
     * </pre>
     */
    @After
    public void AfterTest() {
        
    }
}
