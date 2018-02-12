package com.woorea.openstack.nova.model;

import org.junit.Test;

public class SnapshotsTest {

    Snapshots snapshots = new Snapshots();

    @Test
    public void getList() throws Exception {
        snapshots.getList();
    }

    @Test(expected = NullPointerException.class)
    public void iterator() throws Exception {
        snapshots.iterator();
    }

}