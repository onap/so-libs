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
package com.woorea.openstack.ceilometer.v2.model;

import org.junit.Test;

public class MeterTest {

    Meter meter = new Meter();

    @Test
    public void getUserTest() throws Exception {
        meter.getUser();
    }

    @Test
    public void getNameTest() throws Exception {
        meter.getName();
    }

    @Test
    public void getResource() throws Exception {
        meter.getResource();
    }

    @Test
    public void getProjectTest() throws Exception {
        meter.getProject();
    }

    @Test
    public void getTypeTest() throws Exception {
        meter.getType();
    }

    @Test
    public void getUnitTest() throws Exception {
        meter.getUnit();
    }

}