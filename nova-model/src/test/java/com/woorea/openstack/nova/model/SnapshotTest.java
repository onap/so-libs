package com.woorea.openstack.nova.model;

import org.junit.Test;

public class SnapshotTest {

    Snapshot snapshot = new Snapshot();

    @Test
    public void getId() throws Exception {
        snapshot.getId();
    }

    @Test
    public void getStatus() throws Exception {
        snapshot.getStatus();
    }

    @Test
    public void getName() throws Exception {
        snapshot.getName();
    }

    @Test
    public void getDescription() throws Exception {
        snapshot.getDescription();
    }

    @Test
    public void getVolumeId() throws Exception {
        snapshot.getVolumeId();
    }

    @Test
    public void getSize() throws Exception {
        snapshot.getSize();
    }

    @Test
    public void getCreatedAt() throws Exception {
        snapshot.getCreatedAt();
    }

}