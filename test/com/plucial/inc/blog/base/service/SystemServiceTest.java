package com.plucial.inc.blog.base.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SystemServiceTest extends AppEngineTestCase {

    private SystemService service = new SystemService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
