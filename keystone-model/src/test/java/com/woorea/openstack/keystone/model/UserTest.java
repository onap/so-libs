/*-
 * ONAP-SO
 * ============LICENSE_START=======================================================
 * Copyright 2018 Huawei Intellectual Property. All rights reserved.
 * ===================================================================
 * 
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

public class UserTest {

    User user = new User();

    @Test
    public void getId() throws Exception {
        user.getId();
    }

    @Test
    public void setId() throws Exception {
        user.setId("test");
    }

    @Test
    public void getUsername() throws Exception {
        user.getUsername();
    }

    @Test
    public void setUsername() throws Exception {
        user.setUsername("test");
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
    public void getTenantId() throws Exception {
        user.getTenantId();
    }

    @Test
    public void setTenantId() throws Exception {
        user.setTenantId("test");
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
    public void getEmail() throws Exception {
        user.getEmail();
    }

    @Test
    public void setEmail() throws Exception {
        user.setEmail("test");
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