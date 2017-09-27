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

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.Resources;


/**
 * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
 */
public class ResourcesResource {
    private final OpenStackClient client;

    public ResourcesResource(OpenStackClient client) {
        this.client = client;
    }

    public ListResources listResources(String name) {
        return new ListResources(name);
    }

    /**
     * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
     */
    public class ListResources extends OpenStackRequest<Resources> {
        public ListResources(String name) {
            super(client, HttpMethod.GET, "/stacks/" + name + "/resources", null, Resources.class);
        }
    }
}
