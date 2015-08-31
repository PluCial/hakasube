package com.plucial.inc.blog.base.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SystemModelDaoTest extends AppEngineTestCase {

    private SystemModelDao dao = new SystemModelDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
