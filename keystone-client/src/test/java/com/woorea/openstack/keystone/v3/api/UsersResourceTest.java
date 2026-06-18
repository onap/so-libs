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
package com.woorea.openstack.keystone.v3.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersResourceTest {

    UsersResource usersResource = new UsersResource(null);

    @Test
    public void groupsTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            usersResource.groups("id");
        });
    }

    @Test
    public void projectsTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            usersResource.projects("uid");
        });
    }

    @Test
    public void rolesTest() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            usersResource.roles("uid");
        });
    }

}
