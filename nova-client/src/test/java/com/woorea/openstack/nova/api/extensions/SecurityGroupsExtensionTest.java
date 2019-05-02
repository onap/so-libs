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
package com.woorea.openstack.nova.api.extensions;

import org.junit.Test;

public class SecurityGroupsExtensionTest {

    SecurityGroupsExtension securityGroupsExtension = new SecurityGroupsExtension(null);

    @Test
    public void listSecurityGroups() throws Exception {
        securityGroupsExtension.listSecurityGroups();
    }

    @Test
    public void createSecurityGroup() throws Exception {
        securityGroupsExtension.createSecurityGroup("test");
    }

    @Test
    public void createSecurityGroup1() throws Exception {
        securityGroupsExtension.createSecurityGroup("test", "desc");
    }

    @Test
    public void showSecurityGroup() throws Exception {
        securityGroupsExtension.showSecurityGroup("test");
    }

    @Test
    public void showSecurityGroup1() throws Exception {
        securityGroupsExtension.showSecurityGroup(1);
    }

    @Test
    public void deleteSecurityGroup() throws Exception {
        securityGroupsExtension.deleteSecurityGroup("test");
    }

    @Test
    public void deleteSecurityGroup1() throws Exception {
        securityGroupsExtension.deleteSecurityGroup(1);
    }

    @Test
    public void createSecurityGroupRule() throws Exception {
        securityGroupsExtension.createSecurityGroupRule("test", "test", 90, 80, "test");
    }

    @Test
    public void createSecurityGroupRule1() throws Exception {
        securityGroupsExtension.createSecurityGroupRule("test", "test", "test", 79, 80);
    }

    @Test
    public void createSecurityGroupRule2() throws Exception {
        securityGroupsExtension.createSecurityGroupRule(12, "test", 1, 1, "test");
    }

    @Test
    public void createSecurityGroupRule3() throws Exception {
        securityGroupsExtension.createSecurityGroupRule(1, "test", 1, 1, 1);
    }

    @Test
    public void deleteSecurityGroupRule() throws Exception {
        securityGroupsExtension.deleteSecurityGroupRule("test");
    }

    @Test
    public void deleteSecurityGroupRule1() throws Exception {
        securityGroupsExtension.deleteSecurityGroup(1);
    }

}
