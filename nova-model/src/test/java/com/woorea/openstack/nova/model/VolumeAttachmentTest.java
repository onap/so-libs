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