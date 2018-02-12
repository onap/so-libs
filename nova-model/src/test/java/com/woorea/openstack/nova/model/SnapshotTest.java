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

public class SnapshotTest {

    Snapshot snapshot = new Snapshot();

    @Test
    public void getId() throws Exception {
        snapshot.getId();
    }

    @Test
    public void getStatus() throws Exception {
        snapshot.getStatus();
    }

    @Test
    public void getName() throws Exception {
        snapshot.getName();
    }

    @Test
    public void getDescription() throws Exception {
        snapshot.getDescription();
    }

    @Test
    public void getVolumeId() throws Exception {
        snapshot.getVolumeId();
    }

    @Test
    public void getSize() throws Exception {
        snapshot.getSize();
    }

    @Test
    public void getCreatedAt() throws Exception {
        snapshot.getCreatedAt();
    }

}