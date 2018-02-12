package com.woorea.openstack.nova.model;

import org.junit.Test;

import java.util.HashMap;

public class VolumeForCreateTest {

    VolumeForCreate volumeForCreate = new VolumeForCreate();

    @Test
    public void getSize() throws Exception {
        volumeForCreate.getSize();
    }

    @Test
    public void setSize() throws Exception {
        volumeForCreate.setSize(1);
    }

    @Test
    public void getAvailabilityZone() throws Exception {
        volumeForCreate.getAvailabilityZone();
    }

    @Test
    public void setAvailabilityZone() throws Exception {
        volumeForCreate.setAvailabilityZone("test");
    }

    @Test
    public void getName() throws Exception {
        volumeForCreate.getName();
    }

    @Test
    public void setName() throws Exception {
        volumeForCreate.setName("test");
    }

    @Test
    public void getDescription() throws Exception {
        volumeForCreate.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        volumeForCreate.setDescription("test");
    }

    @Test
    public void getSnapshotId() throws Exception {
        volumeForCreate.getSnapshotId();
    }

    @Test
    public void setSnapshotId() throws Exception {
        volumeForCreate.setSnapshotId(1);
    }

    @Test
    public void getMetadata() throws Exception {
        volumeForCreate.getMetadata();
    }

    @Test
    public void setMetadata() throws Exception {
        volumeForCreate.setMetadata(new HashMap<String, String>());
    }

}