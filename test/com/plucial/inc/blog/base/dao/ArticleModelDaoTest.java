package com.plucial.inc.blog.base.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArticleModelDaoTest extends AppEngineTestCase {

    private ArticleModelDao dao = new ArticleModelDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
