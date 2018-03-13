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

public class SecurityGroupRuleForCreateTest {

    SecurityGroupRuleForCreate securityGroupRuleForCreate = new SecurityGroupRuleForCreate();

    @Test
    public void getParentGroupId() throws Exception {
        securityGroupRuleForCreate.getParentGroupId();
    }

    @Test
    public void setParentGroupId() throws Exception {
        securityGroupRuleForCreate.setParentGroupId("parent");
    }

    @Test
    public void setParentGroupId1() throws Exception {
        securityGroupRuleForCreate.setParentGroupId(1);
    }

    @Test
    public void getFromPort() throws Exception {
        securityGroupRuleForCreate.getFromPort();
    }

    @Test
    public void setFromPort() throws Exception {
        securityGroupRuleForCreate.setFromPort(80);
    }

    @Test
    public void getToPort() throws Exception {
        securityGroupRuleForCreate.getToPort();
    }

    @Test
    public void setToPort() throws Exception {
        securityGroupRuleForCreate.setToPort(80);
    }

    @Test
    public void getIpProtocol() throws Exception {
        securityGroupRuleForCreate.getIpProtocol();
    }

    @Test
    public void setIpProtocol() throws Exception {
        securityGroupRuleForCreate.setIpProtocol("test");
    }

    @Test
    public void getCidr() throws Exception {
        securityGroupRuleForCreate.getCidr();
    }

    @Test
    public void setCidr() throws Exception {
        securityGroupRuleForCreate.setCidr("test");
    }

    @Test
    public void getGroupId() throws Exception {
        securityGroupRuleForCreate.getGroupId();
    }

    @Test
    public void setGroupId() throws Exception {
        securityGroupRuleForCreate.setGroupId("test");
    }

    @Test
    public void setGroupId1() throws Exception {
        securityGroupRuleForCreate.setGroupId(1);
    }

}