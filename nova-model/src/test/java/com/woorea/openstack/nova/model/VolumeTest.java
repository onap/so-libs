package com.woorea.openstack.nova.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class VolumeTest {

    Volume volume = new Volume();

    @Test
    public void getId() throws Exception {
        volume.getId();
    }

    @Test
    public void getStatus() throws Exception {
        volume.getStatus();
    }

    @Test
    public void getName() throws Exception {
        volume.getName();
    }

    @Test
    public void getDescription() throws Exception {
        volume.getDescription();
    }

    @Test
    public void getAvailabilityZone() throws Exception {
        volume.getAvailabilityZone();
    }

    @Test
    public void getVolumeType() throws Exception {
        volume.getVolumeType();
    }

    @Test
    public void getSnapshotId() throws Exception {
        volume.getSnapshotId();
    }

    @Test
    public void getAttachments() throws Exception {
        volume.getAttachments();
    }

    @Test
    public void getMetadata() throws Exception {
        volume.getMetadata();
    }

    @Test
    public void getCreatedAt() throws Exception {
        volume.getCreatedAt();
    }

    @Test
    public void getSize() throws Exception {
        volume.getSize();
    }

}