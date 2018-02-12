package com.woorea.openstack.nova.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnapshotForCreateTest {

    SnapshotForCreate snapshotForCreate = new SnapshotForCreate();

    @Test
    public void getVolumeId() throws Exception {
        snapshotForCreate.getVolumeId();
    }

    @Test
    public void setVolumeId() throws Exception {
        snapshotForCreate.setVolumeId("Test");
    }

    @Test
    public void getForce() throws Exception {
        snapshotForCreate.getForce();
    }

    @Test
    public void setForce() throws Exception {
        snapshotForCreate.setForce(true);
    }

    @Test
    public void getName() throws Exception {
        snapshotForCreate.getName();
    }

    @Test
    public void setName() throws Exception {
        snapshotForCreate.setName("Test");
    }

    @Test
    public void getDescription() throws Exception {
        snapshotForCreate.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        snapshotForCreate.setDescription("test");
    }

}