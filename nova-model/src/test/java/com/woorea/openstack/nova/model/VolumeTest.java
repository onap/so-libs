/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
 * ================================================================================ 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */
package com.woorea.openstack.nova.model;

import org.junit.Test;

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