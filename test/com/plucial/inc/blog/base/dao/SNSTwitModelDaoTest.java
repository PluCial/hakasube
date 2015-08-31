package com.plucial.inc.blog.base.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SNSTwitModelDaoTest extends AppEngineTestCase {

    private SNSTwitModelDao dao = new SNSTwitModelDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
