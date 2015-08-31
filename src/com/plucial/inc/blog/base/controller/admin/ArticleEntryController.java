package com.plucial.inc.blog.base.controller.admin;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.controller.validator.Validators;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import com.plucial.inc.blog.base.model.ArticleModel;
import com.plucial.inc.blog.base.model.CategoryModel;
import com.plucial.inc.blog.base.model.UserModel;
import com.plucial.inc.blog.base.service.ArticleService;
import com.plucial.inc.blog.base.service.CategoryService;

public class ArticleEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel userModel) throws Exception {

            // 入力チェック
            if (!isPost() || !createValidate(userModel)) {
                return forward("/admin/articleAdd");
            }

            String category = asString("category");
            String driveFileId = asString("driveFileId");
            String referenceUrl = asString("referenceUrl");
            
            ArticleModel articleModel = ArticleService.getArticleByDriveFileId(driveFileId);
            CategoryModel categoryModel = CategoryService.get(Long.valueOf(category));
            
            // 新規
            if(articleModel == null) {
                articleModel = ArticleService.put(userModel, categoryModel, driveFileId, referenceUrl);
            
            // 更新
            }else {
                articleModel.getCategoryModelRef().setModel(categoryModel);
                ArticleService.put(articleModel);
                
            }
            
//            if(articleModel != null) return redirect("/admin/articleAdd");
//            
//            // 記事の登録
//            articleModel = ArticleService.put(userModel, categoryModel, driveFileId);
            
            // アイキャッチの追加
            addEyeCatchToGCS(articleModel);
            
            return redirect("/admin/articleAdd");
    }

    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate(UserModel userModel) {
        Validators v = new Validators(request);
        
        // カテゴリ
        v.add("category", v.required());
        
        // GoogleドキュメントID
        v.add("driveFileId", v.required());
        
//        // 参照サイトURL
//        v.add("referenceUrl", 
//            v.required(), 
//            v.regexp("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+", "正しいURLではありません。"));
        
        // アイキャッチ画像
//        v.add("eyeCatch", v.required());
        
        return v.validate();
    }
    
    /**
     * GCS ファイルアップロード
     * @param articleModel
     * @throws IOException
     */
    private void addEyeCatchToGCS(ArticleModel articleModel) throws IOException {

        FileItem fileItem = requestScope("eyeCatch");
        
        // アップロードファイルない場合
        if(fileItem == null || fileItem.getData() == null || !fileItem.getContentType().startsWith("image")) {
            return;
        }

        GcsService gcsService =
                GcsServiceFactory.createGcsService(RetryParams.getDefaultInstance());

        GcsOutputChannel outputChannel = gcsService.createOrReplace(
            new GcsFilename(
                AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName(), 
                String.valueOf("eye-catch/" + articleModel.getKey().getId())
                    ), 
            new GcsFileOptions.Builder()
            .mimeType(fileItem.getContentType())
            .acl("public-read")
            .build()
                );

        outputChannel.write(ByteBuffer.wrap(fileItem.getData()));

        outputChannel.close();
    }
    
    @Override
    protected String getPageTitle() {
        return "null";
    }
}
