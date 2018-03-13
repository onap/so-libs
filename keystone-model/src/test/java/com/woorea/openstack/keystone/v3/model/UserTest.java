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
package com.woorea.openstack.keystone.v3.model;

import org.junit.Test;

public class UserTest {

    User user = new User();

    @Test
    public void getId() throws Exception {
        user.getId();
    }

    @Test
    public void setId() throws Exception {
        user.setId("Test");
    }

    @Test
    public void getDomainId() throws Exception {
        user.getDomainId();
    }

    @Test
    public void setDomainId() throws Exception {
        user.setDomainId("test");
    }

    @Test
    public void getDefaultProjectId() throws Exception {
        user.getDefaultProjectId();
    }

    @Test
    public void setDefaultProjectId() throws Exception {
        user.setDefaultProjectId("tets");
    }

    @Test
    public void getName() throws Exception {
        user.getName();
    }

    @Test
    public void setName() throws Exception {
        user.setName("test");
    }

    @Test
    public void getPassword() throws Exception {
        user.getPassword();
    }

    @Test
    public void setPassword() throws Exception {
        user.setPassword("test");
    }

    @Test
    public void getEmail() throws Exception {
        user.getEmail();
    }

    @Test
    public void setEmail() throws Exception {
        user.setEmail("test");
    }

    @Test
    public void getDescription() throws Exception {
        user.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        user.setDescription("test");
    }

    @Test
    public void getEnabled() throws Exception {
        user.getEnabled();
    }

    @Test
    public void setEnabled() throws Exception {
        user.setEnabled(true);
    }

}