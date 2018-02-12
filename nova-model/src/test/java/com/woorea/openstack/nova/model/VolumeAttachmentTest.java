package com.woorea.openstack.nova.model;

import org.junit.Test;

public class VolumeAttachmentTest {

    VolumeAttachment volumeAttachment = new VolumeAttachment();

    @Test
    public void getId() throws Exception {
        volumeAttachment.getId();
    }

    @Test
    public void setId() throws Exception {
        volumeAttachment.setId("Test");
    }

    @Test
    public void getVolumeId() throws Exception {
        volumeAttachment.getVolumeId();
    }

    @Test
    public void setVolumeId() throws Exception {
        volumeAttachment.setVolumeId("test");
    }

    @Test
    public void getServerId() throws Exception {
        volumeAttachment.getServerId();
    }

    @Test
    public void setServerId() throws Exception {
        volumeAttachment.setServerId("test");
    }

    @Test
    public void getDevice() throws Exception {
        volumeAttachment.getDevice();
    }

    @Test
    public void setDevice() throws Exception {
        volumeAttachment.setDevice("test");
    }

}