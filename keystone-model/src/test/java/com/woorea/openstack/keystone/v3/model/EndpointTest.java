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

public class EndpointTest {

    Endpoint endpoint = new Endpoint();

    @Test
    public void getId() throws Exception {
        endpoint.getId();
    }

    @Test
    public void setId() throws Exception {
        endpoint.setId("test");
    }

    @Test
    public void getInterface() throws Exception {
        endpoint.getInterface();
    }

    @Test
    public void setInterface() throws Exception {
        endpoint.setInterface("test");
    }

    @Test
    public void getName() throws Exception {
        endpoint.getName();
    }

    @Test
    public void setName() throws Exception {
        endpoint.setName("test");
    }

    @Test
    public void getServiceId() throws Exception {
        endpoint.getServiceId();
    }

    @Test
    public void setServiceId() throws Exception {
        endpoint.setServiceId("test");
    }

}