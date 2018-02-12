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