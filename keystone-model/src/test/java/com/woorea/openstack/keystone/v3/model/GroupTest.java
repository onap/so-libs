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

public class GroupTest {

    Group group = new Group();

    @Test
    public void getId() throws Exception {
        group.getId();
    }

    @Test
    public void setId() throws Exception {
        group.setId("test");
    }

    @Test
    public void getDomainId() throws Exception {
        group.getDomainId();
    }

    @Test
    public void setDomainId() throws Exception {
        group.setDomainId("test");
    }

    @Test
    public void getName() throws Exception {
        group.getName();
    }

    @Test
    public void setName() throws Exception {
        group.setName("test");
    }

    @Test
    public void getDescription() throws Exception {
        group.getDescription();
    }

    @Test
    public void setDescription() throws Exception {
        group.setDescription("test");
    }

}