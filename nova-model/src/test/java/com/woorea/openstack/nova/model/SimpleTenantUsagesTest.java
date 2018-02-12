package com.woorea.openstack.nova.model;

import org.junit.Test;

public class SimpleTenantUsagesTest {

    SimpleTenantUsages simpleTenantUsages = new SimpleTenantUsages();

    @Test
    public void getList() throws Exception {
        simpleTenantUsages.getList();
    }

    @Test(expected = NullPointerException.class)
    public void iterator() throws Exception {
        simpleTenantUsages.iterator();
    }

}