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

import static org.junit.Assert.*;

public class QuotaSetTest {

    private QuotaSet set = new QuotaSet();

    @Test
    public void getId() {
        set.getId();
    }

    @Test
    public void setId() {
        set.setId("123");
    }

    @Test
    public void getMetadataItems() {
        set.getMetadataItems();
    }

    @Test
    public void setMetadataItems() {
        set.setMetadataItems(123);
    }

    @Test
    public void getInjectedFileContentBytes() {
        set.getInjectedFileContentBytes();
    }

    @Test
    public void setInjectedFileContentBytes() {
        set.setInjectedFileContentBytes(123);
    }

    @Test
    public void getInjectedFiles() {
        set.getInjectedFiles();
    }

    @Test
    public void setInjectedFiles() {
        set.setInjectedFiles(123);
    }

    @Test
    public void getGigabytes() {
        set.getGigabytes();
    }

    @Test
    public void setGigabytes() {
        set.setGigabytes(123);
    }

    @Test
    public void getRam() {
        set.getRam();
    }

    @Test
    public void setRam() {
        set.setRam(123);
    }

    @Test
    public void getFloatingIps() {
        set.getFloatingIps();
    }

    @Test
    public void setFloatingIps() {
        set.setFloatingIps(123);
    }

    @Test
    public void getInstances() {
        set.getInstances();
    }

    @Test
    public void setInstances() {
        set.setInstances(123);
    }

    @Test
    public void getVolumes() {
        set.getVolumes();
    }

    @Test
    public void setVolumes() {
        set.setVolumes(123);
    }

    @Test
    public void getCores() {
        set.getCores();
    }

    @Test
    public void setCores() {
        set.setCores(123);
    }

    @Test
    public void getSecurityGroups() {
        set.getSecurityGroups();
    }

    @Test
    public void setSecurityGroups() {
        set.setSecurityGroups(123);
    }

    @Test
    public void getSecurityGroupRules() {
        set.getSecurityGroupRules();
    }

    @Test
    public void setSecurityGroupRules() {
        set.setSecurityGroupRules(123);
    }

    @Test
    public void getKeyPairs() {
        set.getKeyPairs();
    }

    @Test
    public void setKeyPairs() {
        set.setKeyPairs(123);
    }

    @Test
    public void getInjectedFilePathBytes() {
        set.getInjectedFilePathBytes();
    }

    @Test
    public void setInjectedFilePathBytes() {
        set.setInjectedFilePathBytes(123);
    }
}