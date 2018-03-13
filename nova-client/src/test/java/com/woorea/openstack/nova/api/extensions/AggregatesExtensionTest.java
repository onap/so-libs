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

public class AggregatesExtensionTest {

    AggregatesExtension aggregatesExtension = new AggregatesExtension(null);

    @Test
    public void list() throws Exception {
        aggregatesExtension.list();
    }

    @Test
    public void showAggregate() throws Exception {
        aggregatesExtension.showAggregate("test");
    }

    @Test
    public void updateAggregateMetadata() throws Exception {
        aggregatesExtension.updateAggregateMetadata("test", "test", "test");
    }

    @Test
    public void createAggregate() throws Exception {
        aggregatesExtension.createAggregate("test", "test");
    }

    @Test
    public void deleteAggregate() throws Exception {
        aggregatesExtension.deleteAggregate("test");
    }

    @Test
    public void addHost() throws Exception {
        aggregatesExtension.addHost("test", "test");
    }

    @Test
    public void removeHost() throws Exception {
        aggregatesExtension.removeHost("test", "test");
    }

    @Test
    public void setMetadata() throws Exception {
        aggregatesExtension.setMetadata("test", "test", "test");
    }

}