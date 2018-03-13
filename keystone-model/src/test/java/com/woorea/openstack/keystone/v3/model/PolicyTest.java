/*-
 * ONAP-SO
 * ============LICENSE_START=======================================================
 * Copyright 2018 Huawei Intellectual Property. All rights reserved.
 * =================================================================
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

import java.util.HashMap;

public class PolicyTest {

    Policy policy = new Policy();

    @Test
    public void getId() throws Exception {
        policy.getId();
    }

    @Test
    public void setId() throws Exception {
        policy.setId("test");
    }

    @Test
    public void getProjectId() throws Exception {
        policy.getProjectId();
    }

    @Test
    public void setProjectId() throws Exception {
        policy.setProjectId("test");
    }

    @Test
    public void getType() throws Exception {
        policy.getType();
    }

    @Test
    public void setType() throws Exception {
        policy.setType("test");
    }

    @Test
    public void getUserId() throws Exception {
        policy.getUserId();
    }

    @Test
    public void setUserId() throws Exception {
        policy.setUserId("test");
    }

    @Test
    public void getBlob() throws Exception {
        policy.getBlob();
    }

    @Test
    public void setBlob() throws Exception {
        policy.setBlob(new HashMap<String, String>());
    }

}