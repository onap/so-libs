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
package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.heat.model.CreateStackParam;
import com.woorea.openstack.heat.model.UpdateStackParam;
import org.junit.Test;

public class StackResourceTest {

    StackResource stackResource = new StackResource(new OpenStackClient("os"));
    @Test
    public void create() throws Exception {
        stackResource.create(new CreateStackParam());
    }

    @Test
    public void update() throws Exception {
        stackResource.update("test", new UpdateStackParam());
    }

    @Test
    public void list() throws Exception {
        stackResource.list();
    }

    @Test
    public void byName() throws Exception {
        stackResource.byName("test");
    }

    @Test
    public void deleteByName() throws Exception {
        stackResource.deleteByName("test");
    }

}