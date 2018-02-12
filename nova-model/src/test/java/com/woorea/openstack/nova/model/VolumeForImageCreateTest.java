package com.woorea.openstack.nova.model;

import org.junit.Test;

public class VolumeForImageCreateTest {

    VolumeForImageCreate volumeForImageCreate = new VolumeForImageCreate();

    @Test
    public void getTenantId() throws Exception {
        volumeForImageCreate.getTenantId();
    }

    @Test
    public void setTenantId() throws Exception {
        volumeForImageCreate.setTenantId("Test");
    }

    @Test
    public void getForce() throws Exception {
        volumeForImageCreate.getForce();
    }

    @Test
    public void setForce() throws Exception {
        volumeForImageCreate.setForce(true);
    }

    @Test
    public void getVolumeId() throws Exception {
        volumeForImageCreate.getVolumeId();
    }

    @Test
    public void setVolumeId() throws Exception {
        volumeForImageCreate.setVolumeId("testid");
    }

    @Test
    public void getContainer_format() throws Exception {
        volumeForImageCreate.getContainer_format();
    }

    @Test
    public void setContainer_format() throws Exception {
        volumeForImageCreate.setContainer_format("test");
    }

    @Test
    public void getDisk_format() throws Exception {
        volumeForImageCreate.getDisk_format();
    }

    @Test
    public void setDisk_format() throws Exception {
        volumeForImageCreate.setDisk_format("test");
    }

    @Test
    public void getImage_name() throws Exception {
        volumeForImageCreate.getImage_name();
    }

    @Test
    public void setImage_name() throws Exception {
        volumeForImageCreate.setImage_name("test");
    }

}