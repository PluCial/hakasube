package com.plucial.inc.blog.base.controller.info;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.inc.blog.base.service.SystemService;

public class ContactMsgSendController extends Controller {
    
    /** メール文字コード */
    private static final String MAIL_CHARSET = "ISO-2022-JP";

    @Override
    public Navigation run() throws Exception {
        
        // 入力チェック
        if (!isPost() || !validate()) {
            return forward("/info/contact");
        }
        
        // 入力項目の取得
        String name = asString("name");
        String email = asString("email");
        String subject = asString("subject");
        String message = asString("message");
        
        // 設定情報の取得
        String googleApplicationName = SystemService.getByKey("GOOGLE_APPLICATION_NAME").getValue();
        String adminAccountEmail = SystemService.getByKey("PROJECT_ADMIN_ACCOUNT_EMAIL").getValue();
        String applecationName = SystemService.getByKey("PROJECT_APPLECATION_NAME").getValue();
        
        // メール送信機能
        try{
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage msg = new MimeMessage(session);

            //発信元情報：メールアドレス、名前
            msg.setFrom(new InternetAddress(adminAccountEmail, googleApplicationName, MAIL_CHARSET));

            //送信先情報
            msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(adminAccountEmail, googleApplicationName, MAIL_CHARSET));

            msg.setSubject("【" + applecationName + "】問い合わせ:" + subject, MAIL_CHARSET);
            msg.setText(message + "\n\n" + name + "\n" + email);

            Transport.send(msg);

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return redirect("/info/contactEnd");
    }
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean validate() {
        Validators v = new Validators(request);

        v.add("name", v.required());
        
        v.add("email", v.required(), v.maxlength(256), v.minlength(6)
            , v.regexp("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*"));
        
        v.add("subject", v.required());
        
        v.add("message", v.required());
        
        return v.validate();
    }
}
