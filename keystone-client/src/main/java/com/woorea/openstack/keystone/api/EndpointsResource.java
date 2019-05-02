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

package com.woorea.openstack.keystone.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Endpoint;
import com.woorea.openstack.keystone.model.Endpoints;

public class EndpointsResource {

    private OpenStackClient client;

    public EndpointsResource(OpenStackClient client) {
        this.client = client;
    }

    public List list() {
        return new List();
    }

    public Create create(Endpoint endpoint) {
        return new Create(endpoint);
    }

    public Show show(String id) {
        return new Show(id);
    }


    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Endpoints> {

        public List() {
            super(client, HttpMethod.GET, "/endpoints", null, Endpoints.class);
        }

    }

    public class Create extends OpenStackRequest<Endpoint> {

        private Endpoint endpoint;

        public Create(Endpoint endpoint) {
            super(client, HttpMethod.POST, "/endpoints", Entity.json(endpoint), Endpoint.class);
            this.endpoint = endpoint;
        }

    }

    public class Show extends OpenStackRequest<Endpoint> {

        public Show(String id) {
            super(client, HttpMethod.GET, new StringBuilder("/endpoints/").append(id).toString(), null, Endpoint.class);
        }

    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, new StringBuilder("/endpoints/").append(id).toString(), null, Void.class);
        }

    }

}
