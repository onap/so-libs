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