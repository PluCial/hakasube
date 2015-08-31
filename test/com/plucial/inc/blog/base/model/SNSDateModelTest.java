package com.plucial.inc.blog.base.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SNSDateModelTest extends AppEngineTestCase {

    private SNSDateModel model = new SNSDateModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
