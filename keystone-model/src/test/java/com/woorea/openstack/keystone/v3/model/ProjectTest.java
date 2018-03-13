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

public class ProjectTest {

    Project project = new Project();

    @Test
    public void getId() throws Exception {
        project.getId();
    }

    @Test
    public void setId() throws Exception {
        project.setId("test");
    }

    @Test
    public void getDomainId() throws Exception {
        project.getDomainId();
    }

    @Test
    public void setDomainId() throws Exception {
        project.setDomainId("test");
    }

    @Test
    public void getName() throws Exception {
        project.getName();
    }

    @Test
    public void setName() throws Exception {
        project.setName("test");
    }

    @Test
    public void getEnabled() throws Exception {
        project.getEnabled();
    }

    @Test
    public void setEnabled() throws Exception {
        project.setEnabled(true);
    }

}