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

package com.woorea.openstack.quantum.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.quantum.model.Subnet;
import com.woorea.openstack.quantum.model.Subnets;

public class SubnetsResource {

    private final OpenStackClient CLIENT;

    public SubnetsResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(Subnet net) {
        return new Create(net);
    }

    public Update update(Subnet net) {
        return new Update(net);
    }

    public Delete delete(String netId){
        return new Delete(netId);
    }

    public Show show(String netId){
        return new Show(netId);
    }

    public class List extends OpenStackRequest<Subnets> {

        public List() {
            super(CLIENT, HttpMethod.GET, "subnets", null, Subnets.class);
        }
    }

    public class Query extends OpenStackRequest<Subnets> {

        public Query(Subnet subnet) {
        }
    }


    public class Create extends OpenStackRequest<Subnet> {

        public Create(Subnet subnet) {
            super(CLIENT, HttpMethod.POST, "subnets", Entity.json(subnet), Subnet.class);
        }
    }

    public class Update extends OpenStackRequest<Subnet> {

        public Update(Subnet subnet) {
            super(CLIENT, HttpMethod.PUT, buildPath("subnets/", subnet.getId()), Entity.json(subnet), Subnet.class);
        }
    }

    public class Show extends OpenStackRequest<Subnet> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("subnets/", id), null, Subnet.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id){
            super(CLIENT, HttpMethod.DELETE, buildPath("subnets/", id), null, Void.class);
        }
    }
}
