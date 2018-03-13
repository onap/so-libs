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

public class ServiceTest {

    Service service = new Service();

    @Test
    public void getId() throws Exception {
        service.getId();
    }

    @Test
    public void setId() throws Exception {
        service.setId("test");
    }

    @Test
    public void getType() throws Exception {
        service.getType();
    }

    @Test
    public void setType() throws Exception {
        service.setType("test");
    }

    @Test
    public void getName() throws Exception {
        service.getName();
    }

    @Test
    public void setName() throws Exception {
        service.setName("test");
    }

    @Test
    public void getDescription() throws Exception {
        service.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        service.setDescription("test");
    }

}