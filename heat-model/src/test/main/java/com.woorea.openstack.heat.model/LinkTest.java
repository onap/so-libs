package com.woorea.openstack.heat.model;

import org.junit.Test;
import org.junit.Test;

public class LinkTest {
    Link link = new Link();

    @Test
    public void getHrefTest() throws Exception {
        link.getHref();
    }

    @Test
    public void setHrefTest() throws Exception {
        link.setHref("href");
    }

    @Test
    public void getRelTest() throws Exception {
        link.getRel();
    }

    @Test
    public void setRelTest() throws Exception {
        link.setRel("rel");
    }

}
