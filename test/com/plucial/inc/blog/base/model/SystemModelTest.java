package com.plucial.inc.blog.base.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SystemModelTest extends AppEngineTestCase {

    private SystemModel model = new SystemModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
