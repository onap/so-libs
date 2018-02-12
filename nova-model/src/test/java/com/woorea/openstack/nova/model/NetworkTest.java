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

public class NetworkTest {

    private Network network = new Network();

    @Test
    public void getId() {
        network.getId();
    }

    @Test
    public void getVpnPublicAddress() {
        network.getVpnPublicAddress();
    }

    @Test
    public void getVpnPublicPort() {
        network.getVpnPublicPort();
    }

    @Test
    public void getDhcpStart() {
        network.getDhcpStart();
    }

    @Test
    public void getBridge() {
        network.getBridge();
    }

    @Test
    public void getBridgeInterface() {
        network.getBridgeInterface();
    }

    @Test
    public void getUpdatedAt() {
        network.getUpdatedAt();
    }

    @Test
    public void getDeleted() {
        network.getDeleted();
    }

    @Test
    public void getVlan() {
        network.getVlan();
    }

    @Test
    public void getBroadcast() {
        network.getBroadcast();
    }

    @Test
    public void getNetmask() {
        network.getNetmask();
    }

    @Test
    public void getInjected() {
        network.getInjected();
    }

    @Test
    public void getHost() {
        network.getHost();
    }

    @Test
    public void getMultiHost() {
        network.getMultiHost();
    }

    @Test
    public void getCreatedAt() {
        network.getCreatedAt();
    }

    @Test
    public void getDeletedAt() {
        network.getDeletedAt();
    }

    @Test
    public void getCidr() {
        network.getCidr();
    }

    @Test
    public void getCidrV6() {
        network.getCidrV6();
    }

    @Test
    public void getGateway() {
        network.getGateway();
    }

    @Test
    public void getGatewayV6() {
        network.getGatewayV6();
    }

    @Test
    public void getNetmaskV6() {
        network.getNetmaskV6();
    }

    @Test
    public void getProjectId() {
        network.getProjectId();
    }

    @Test
    public void getRxtxBase() {
        network.getRxtxBase();
    }

    @Test
    public void getDns1() {
        network.getDns1();
    }

    @Test
    public void getDns2() {
        network.getDns2();
    }

    @Test
    public void getLabel() {
        network.getLabel();
    }

    @Test
    public void getPriority() {
        network.getPriority();
    }
}