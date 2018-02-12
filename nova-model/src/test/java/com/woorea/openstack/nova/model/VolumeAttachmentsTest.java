package com.woorea.openstack.nova.model;

import org.junit.Test;

public class VolumeAttachmentsTest {

    VolumeAttachments volumeAttachments = new VolumeAttachments();

    @Test
    public void getList() throws Exception {
        volumeAttachments.getList();
    }

    @Test(expected = NullPointerException.class)
    public void iterator() throws Exception {
        volumeAttachments.iterator();
    }

}