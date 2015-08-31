package com.plucial.inc.blog.base.controller;

import org.slim3.controller.router.RouterImpl;

/**
 * 公開部分ルーティング
 * addRoutingメソッドの順番変更は禁止！
 * @author takahara
 *
 */
public class AppRouter extends RouterImpl {

	public AppRouter() {

        // カテゴリページ
        addRouting(
                "/ac-{categoryId}",
                "/category?id={categoryId}");
        
        // 記事詳細ページ
        addRouting(
                "/article/{articleId}",
                "/article?id={articleId}");
        
        // SNS TweetList By Date
        addRouting(
                "/sns/tweets-{date}",
                "/sns/tweetList?date={date}");
	}

}
