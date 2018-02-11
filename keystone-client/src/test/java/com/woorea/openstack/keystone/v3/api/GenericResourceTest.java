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
package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.keystone.v3.model.User;
import com.woorea.openstack.keystone.v3.model.Users;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericResourceTest {

    GenericResource<String, String> genericResource = new GenericResource<>(null, "char", String.class, String.class);

    @Test
    public void listTest() throws Exception {
        genericResource.list();
    }

    @Test
    public void createTest() throws Exception {
        genericResource.create("test");
    }

    @Test
    public void showTest() throws Exception {
        genericResource.show("id");
    }

    @Test
    public void updateTest() throws Exception {
        genericResource.update("123", "test");
    }

    @Test
    public void deleteTest() throws Exception {
        genericResource.delete("123");
    }

}