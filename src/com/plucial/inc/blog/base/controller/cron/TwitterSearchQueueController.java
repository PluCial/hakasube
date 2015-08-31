package com.plucial.inc.blog.base.controller.cron;

import java.util.List;
import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.plucial.inc.blog.base.model.SNSDateModel;
import com.plucial.inc.blog.base.service.SNSDateService;
import com.plucial.inc.blog.base.service.SNSTwitService;
import com.plucial.inc.blog.base.service.SystemService;

public class TwitterSearchQueueController extends Controller {
    
    // Logger
    private static final Logger logger = Logger.getLogger(TwitterSearchQueueController.class.getName());

    @Override
    public Navigation run() throws Exception {
        
        // タスクは成功するまで実行されるため、失敗時は例外をキャッチして再実行をさせない
        try{
            search();
            
        }catch(Exception e) {
            logger.severe(e.toString());
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    /**
     * 検索処理
     * @throws Exception
     */
    private void search() throws Exception {
        // 必要パラメーターの取得
        String twitterSearchKeyword = SystemService.getByKey("TWITTER_SEARCH_KEYWORD").getValue();
        String twitterAppApiKey = SystemService.getByKey("TWITTER_APP_API_KEY").getValue();
        String twitterAppApiSecret = SystemService.getByKey("TWITTER_APP_API_SECRET").getValue();
        String twitterAccessToken = SystemService.getByKey("TWITTER_ACCESS_TOKEN").getValue();
        String twitterTokenSecret = SystemService.getByKey("TWITTER_TOKEN_SECRET").getValue();
        
        
        // 承認情報の生成
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(twitterAppApiKey)
            .setOAuthConsumerSecret(twitterAppApiSecret)
            .setOAuthAccessToken(twitterAccessToken)
            .setOAuthAccessTokenSecret(twitterTokenSecret);
        
        // Twitter オブジェクトの初期化
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        
        // 検索の設定
        Query query = new Query();
        query.setQuery(twitterSearchKeyword);
        query.setCount(100);
        
        // 検索実行
        QueryResult result = twitter.search(query);
        
        // 存在しない場合処理を終了
        if(result.getCount() <= 0) return;
        
        List<Status> tweetList = result.getTweets();
        
        // 日付モデルの作成
        SNSDateModel dateModel = SNSDateService.put(
            result.getCount(), 
            tweetList.get(0).getUser().getScreenName(), 
            tweetList.get(0).getText());
        
        // tweetリストの登録
        for (Status tweet : result.getTweets()) {
            
            SNSTwitService.put(
                dateModel, 
                String.valueOf(tweet.getId()), 
                String.valueOf(tweet.getUser().getId()), 
                tweet.getUser().getScreenName(), 
                tweet.getText());
        }
    }
}
