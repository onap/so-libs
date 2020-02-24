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

package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Hypervisor;
import com.woorea.openstack.nova.model.Hypervisors;

public class HypervisorsExtension {

    private final OpenStackClient client;

    public HypervisorsExtension(OpenStackClient client) {
        this.client = client;
    }

    public List list() {
        return new List();
    }

    public ListDetail listDetail() {
        return new ListDetail();
    }

    public Show show(String id) {
        return new Show(id);
    }

    public class List extends OpenStackRequest<Hypervisors> {
        public List() {
            super(client, HttpMethod.GET, "/os-hypervisors", null, Hypervisors.class);
        }
    }

    public class ListDetail extends OpenStackRequest<Hypervisors> {
        public ListDetail() {
            super(client, HttpMethod.GET, "/os-hypervisors/detail", null, Hypervisors.class);
        }
    }

    public class Show extends OpenStackRequest<Hypervisor> {
        public Show(String id) {
            super(client, HttpMethod.GET, new StringBuffer("/hypervisors").append(id).toString(), null,
                    Hypervisor.class);
        }
    }
}
