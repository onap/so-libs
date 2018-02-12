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

import static org.junit.Assert.*;

public class HostAggregateTest {

    private HostAggregate host = new HostAggregate();

    @Test
    public void getId() {
        host.getId();
    }

    @Test
    public void getName() {
        host.getName();
    }

    @Test
    public void getAvailabilityZone() {
        host.getAvailabilityZone();
    }

    @Test
    public void getCreatedAt() {
        host.getCreatedAt();
    }

    @Test
    public void getUpdatedAt() {
        host.getUpdatedAt();
    }

    @Test
    public void getDeletedAt() {
        host.getDeletedAt();
    }

    @Test
    public void getDeleted() {
        host.getDeleted();
    }

    @Test
    public void getHosts() {
        host.getHosts();
    }

    @Test
    public void getMetadata() {
        host.getMetadata();
    }
}