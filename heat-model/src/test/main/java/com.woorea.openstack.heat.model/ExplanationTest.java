
package com.woorea.openstack.heat.model;

import org.junit.Test;


public class ExplanationTest {
    Explanation test = new Explanation();

    @Test
    public void getExplanationTest() throws Exception {
        test.getExplanation();
    }

    @Test
    public void getCodeTest() throws Exception {
        test.getCode();
    }

    @Test
    public void getTitleTest() throws Exception {
        test.getTitle();
    }

    @Test
    public void getErrorTest() throws Exception {
        test.getError();
    }
}