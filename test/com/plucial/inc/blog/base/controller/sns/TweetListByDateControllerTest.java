package com.plucial.inc.blog.base.controller.sns;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TweetListByDateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/sns/tweetListByDate");
        TweetListController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/sns/tweetListByDate.jsp"));
    }
}
