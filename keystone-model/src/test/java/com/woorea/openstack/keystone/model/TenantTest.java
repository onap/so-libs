/*-
 * ONAP-SO
 * ============LICENSE_START=======================================================
 * Copyright 2018 Huawei Intellectual Property. All rights reserved.
 * ===================================================================
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

package com.woorea.openstack.keystone.model;

import org.junit.Test;

public class TenantTest {

    Tenant tenant = new Tenant();

    @Test
    public void getId() throws Exception {
        tenant.getId();
    }

    @Test
    public void setId() throws Exception {
        tenant.setId("tenantid");
    }

    @Test
    public void getName() throws Exception {
        tenant.getName();
    }

    @Test
    public void setName() throws Exception {
        tenant.setName("test");
    }

    @Test
    public void getDescription() throws Exception {
        tenant.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        tenant.setDescription("desc");
    }

    @Test
    public void getEnabled() throws Exception {
        tenant.getEnabled();
    }

    @Test
    public void setEnabled() throws Exception {
        tenant.setEnabled(true);
    }
}