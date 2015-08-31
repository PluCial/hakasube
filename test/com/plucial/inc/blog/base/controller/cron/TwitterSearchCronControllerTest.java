package com.plucial.inc.blog.base.controller.cron;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterSearchCronControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/cron/twitterSearchCron");
        TwitterSearchCronController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
