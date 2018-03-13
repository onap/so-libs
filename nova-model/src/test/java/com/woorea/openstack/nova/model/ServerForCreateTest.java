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

import java.util.Collections;
import java.util.HashMap;

public class ServerForCreateTest {

    ServerForCreate serverForCreate = new ServerForCreate();

    @Test
    public void getName() throws Exception {
        serverForCreate.getName();
    }

    @Test
    public void setName() throws Exception {
        serverForCreate.setName("test");
    }

    @Test
    public void getAdminPass() throws Exception {
        serverForCreate.getAdminPass();
    }

    @Test
    public void setAdminPass() throws Exception {
        serverForCreate.setAdminPass("adminpass");
    }

    @Test
    public void getImageRef() throws Exception {
        serverForCreate.getImageRef();
    }

    @Test
    public void setImageRef() throws Exception {
        serverForCreate.setImageRef("image");
    }

    @Test
    public void getFlavorRef() throws Exception {
        serverForCreate.getFlavorRef();
    }

    @Test
    public void setFlavorRef() throws Exception {
        serverForCreate.setFlavorRef("test");
    }

    @Test
    public void getAccessIPv4() throws Exception {
        serverForCreate.getAccessIPv4();
    }

    @Test
    public void setAccessIPv4() throws Exception {
        serverForCreate.setAccessIPv4("test");
    }

    @Test
    public void getAccessIPv6() throws Exception {
        serverForCreate.getAccessIPv6();
    }

    @Test
    public void setAccessIPv6() throws Exception {
        serverForCreate.setAccessIPv6("ipv6");
    }

    @Test
    public void getMin() throws Exception {
        serverForCreate.getMin();
    }

    @Test
    public void setMin() throws Exception {
        serverForCreate.setMin(1);
    }

    @Test
    public void getMax() throws Exception {
        serverForCreate.setMax(2);
    }

    @Test
    public void setMax() throws Exception {
        serverForCreate.setMax(2);
    }

    @Test
    public void getDiskConfig() throws Exception {
        serverForCreate.getDiskConfig();
    }

    @Test
    public void setDiskConfig() throws Exception {
        serverForCreate.setDiskConfig("config");
    }

    @Test
    public void getKeyName() throws Exception {
        serverForCreate.getKeyName();
    }

    @Test
    public void setKeyName() throws Exception {
        serverForCreate.setKeyName("test");
    }

    @Test
    public void getPersonality() throws Exception {
        serverForCreate.getPersonality();
    }

    @Test
    public void setPersonality() throws Exception {
        serverForCreate.setPersonality(Collections.<PersonalityFile>emptyList());
    }

    @Test
    public void getMetadata() throws Exception {
        serverForCreate.getMetadata();
    }

    @Test
    public void setMetadata() throws Exception {
        serverForCreate.setMetadata(new HashMap<String, String>());
    }

    @Test
    public void getSecurityGroups() throws Exception {
        serverForCreate.getSecurityGroups();
    }

    @Test
    public void getUserData() throws Exception {
        serverForCreate.getUserData();
    }

    @Test
    public void setUserData() throws Exception {
        serverForCreate.setUserData("test");
    }

    @Test
    public void getAvailabilityZone() throws Exception {
        serverForCreate.getAvailabilityZone();
    }

    @Test
    public void setAvailabilityZone() throws Exception {
        serverForCreate.setAvailabilityZone("test");
    }

    @Test
    public void isConfigDrive() throws Exception {
        serverForCreate.isConfigDrive();
    }

    @Test
    public void setConfigDrive() throws Exception {
        serverForCreate.setConfigDrive(true);
    }

    @Test
    public void getNetworks() throws Exception {
        serverForCreate.getNetworks();
    }

    @Test
    public void setNetworks() throws Exception {
        serverForCreate.setNetworks(Collections.<NetworkForCreate>emptyList());
    }

    @Test
    public void addNetworks() throws Exception {
        serverForCreate.addNetworks("test", "localhost");
    }

}