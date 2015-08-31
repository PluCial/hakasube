package com.plucial.inc.blog.base.controller.cron;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions.Builder;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

public class TwitterSearchCronController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        Queue queue = QueueFactory.getQueue("twitter-search-queue");
        queue.add(Builder.withUrl("/cron/twitterSearchQueue").method(Method.GET));
        
        return null;
    }
}
