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

public class NetworkForCreateTest {

    private NetworkForCreate network = new NetworkForCreate();

    @Test
    public void getId() {
        network.getId();
    }

    @Test
    public void getFixedIp() {
        network.getFixedIp();
    }

    @Test
    public void setId() {
        network.setId("123");
    }

    @Test
    public void setFixedIp() {
        network.setFixedIp("123");
    }
}