package com.woorea.openstack.nova.model;

import org.junit.Test;

public class VolumesTest {

    Volumes volumes = new Volumes();

    @Test
    public void getList() throws Exception {
        volumes.getList();
    }

    @Test(expected = NullPointerException.class)
    public void iterator() throws Exception {
        volumes.iterator();
    }

}