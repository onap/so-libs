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
package com.woorea.openstack.keystone.v3;

import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeystoneTest {

    Keystone keystone = new Keystone("http://127.0.0.1", new OpenStackClientConnector() {
        @Override
        public <T> OpenStackResponse request(OpenStackRequest<T> request) {
            return null;
        }
    });

    @Test
    public void tokensTest() throws Exception {
        keystone.tokens();
    }

    @Test
    public void domainsTest() throws Exception {
        keystone.domains();
    }

    @Test
    public void projectsTest() throws Exception {
        keystone.projects();
    }

    @Test
    public void usersTest() throws Exception {
        keystone.users();
    }

    @Test
    public void rolesTest() throws Exception {
        keystone.roles();
    }

    @Test
    public void servicesTest() throws Exception {
        keystone.services();
    }

    @Test
    public void endpointsTest() throws Exception {
        keystone.endpoints();
    }

}