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

import java.math.BigDecimal;
import java.util.Collections;

public class SimpleTenantUsageTest {

    SimpleTenantUsage simpleTenantUsage = new SimpleTenantUsage();

    @Test
    public void getTotalMemoryMbUsage() throws Exception {
        simpleTenantUsage.getTotalMemoryMbUsage();
    }

    @Test
    public void setTotalMemoryMbUsage() throws Exception {
        simpleTenantUsage.setTotalMemoryMbUsage(new BigDecimal(1));
    }

    @Test
    public void getTotalVcpusUsage() throws Exception {
        simpleTenantUsage.getTotalVcpusUsage();
    }

    @Test
    public void setTotalVcpusUsage() throws Exception {
        simpleTenantUsage.setTotalVcpusUsage(new BigDecimal(1));
    }

    @Test
    public void getTotalLocalGbUsage() throws Exception {
        simpleTenantUsage.getTotalLocalGbUsage();
    }

    @Test
    public void setTotalLocalGbUsage() throws Exception {
        simpleTenantUsage.setTotalLocalGbUsage(BigDecimal.ONE);
    }

    @Test
    public void getStart() throws Exception {
        simpleTenantUsage.getStart();
    }

    @Test
    public void setStart() throws Exception {
        simpleTenantUsage.setStart("test");
    }

    @Test
    public void getStop() throws Exception {
        simpleTenantUsage.getStop();
    }

    @Test
    public void setStop() throws Exception {
        simpleTenantUsage.setStop("test");
    }

    @Test
    public void getTenantId() throws Exception {
        simpleTenantUsage.getTenantId();
    }

    @Test
    public void setTenantId() throws Exception {
        simpleTenantUsage.setTenantId("test");
    }

    @Test
    public void getTotalHours() throws Exception {
        simpleTenantUsage.getTotalHours();
    }

    @Test
    public void setTotalHours() throws Exception {
        simpleTenantUsage.setTotalHours("test");
    }

    @Test
    public void getServerUsages() throws Exception {
        simpleTenantUsage.getServerUsages();
    }

    @Test
    public void setServerUsages() throws Exception {
        simpleTenantUsage.setServerUsages(Collections.<SimpleTenantUsage.ServerUsage>emptyList());
    }

}