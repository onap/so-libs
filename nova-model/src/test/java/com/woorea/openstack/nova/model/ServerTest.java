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

public class ServerTest {

    Server server = new Server();

    @Test
    public void getId() throws Exception {
        server.getId();
    }

    @Test
    public void getName() throws Exception {
        server.getName();
    }

    @Test
    public void getAddresses() throws Exception {
        server.getAddresses();
    }

    @Test
    public void getLinks() throws Exception {
        server.getLinks();
    }

    @Test
    public void getImage() throws Exception {
        server.getImage();
    }

    @Test
    public void setImage() throws Exception {
        server.setImage(new Image());
    }

    @Test
    public void getFlavor() throws Exception {
        server.getFlavor();
    }

    @Test
    public void setFlavor() throws Exception {
        server.setFlavor(new Flavor());
    }

    @Test
    public void getAccessIPv4() throws Exception {
        server.getAccessIPv4();
    }

    @Test
    public void getAccessIPv6() throws Exception {
        server.getAccessIPv6();
    }

    @Test
    public void getConfigDrive() throws Exception {
        server.getConfigDrive();
    }

    @Test
    public void getStatus() throws Exception {
        server.getStatus();
    }

    @Test
    public void getProgress() throws Exception {
        server.getProgress();
    }

    @Test
    public void getFault() throws Exception {
        server.getFault();
    }

    @Test
    public void getTenantId() throws Exception {
        server.getTenantId();
    }

    @Test
    public void getUserId() throws Exception {
        server.getUserId();
    }

    @Test
    public void getKeyName() throws Exception {
        server.getKeyName();
    }

    @Test
    public void getHostId() throws Exception {
        server.getHostId();
    }

    @Test
    public void getUpdated() throws Exception {
        server.getUpdated();
    }

    @Test
    public void getCreated() throws Exception {
        server.getCreated();
    }

    @Test
    public void getMetadata() throws Exception {
        server.getMetadata();
    }

    @Test
    public void getSecurityGroups() throws Exception {
        server.getSecurityGroups();
    }

    @Test
    public void getTaskState() throws Exception {
        server.getTaskState();
    }

    @Test
    public void getPowerState() throws Exception {
        server.getPowerState();
    }

    @Test
    public void getVmState() throws Exception {
        server.getVmState();
    }

    @Test
    public void getHost() throws Exception {
        server.getHost();
    }

    @Test
    public void getInstanceName() throws Exception {
        server.getInstanceName();
    }

    @Test
    public void getHypervisorHostname() throws Exception {
        server.getHypervisorHostname();
    }

    @Test
    public void getDiskConfig() throws Exception {
        server.getDiskConfig();
    }

    @Test
    public void getAvailabilityZone() throws Exception {
        server.getAvailabilityZone();
    }

    @Test
    public void getLaunchedAt() throws Exception {
        server.getLaunchedAt();
    }

    @Test
    public void getTerminatedAt() throws Exception {
        server.getTerminatedAt();
    }

    @Test
    public void getOsExtendedVolumesAttached() throws Exception {
        server.getOsExtendedVolumesAttached();
    }

    @Test
    public void getUuid() throws Exception {
        server.getUuid();
    }

    @Test
    public void getAdminPass() throws Exception {
        server.getAdminPass();
    }

}