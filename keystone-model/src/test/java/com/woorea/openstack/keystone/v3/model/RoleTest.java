/*-
 * ============LICENSE_START=======================================================
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

public class RoleTest {

    Role role = new Role();

    @Test
    public void getId() throws Exception {
        role.getId();
    }

    @Test
    public void getName() throws Exception {
        role.getName();
    }

    @Test
    public void setName() throws Exception {
        role.setName("test");
    }

    @Test
    public void getDescription() throws Exception {
        role.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        role.setDescription("test");
    }

    @Test
    public void getEnabled() throws Exception {
        role.getEnabled();
    }

    @Test
    public void setEnabled() throws Exception {
        role.setEnabled("test");
    }

}