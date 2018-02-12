/*-
 * ============LICENSE_START=======================================================
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