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
import com.woorea.openstack.quantum.model.Network;
import com.woorea.openstack.quantum.model.Networks;

public class NetworksResource {

    private final OpenStackClient CLIENT;

    public NetworksResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(Network net) {
        return new Create(net);
    }

    public Update update(Network net) {
        return new Update(net);
    }

    public Delete delete(String netId){
        return new Delete(netId);
    }

    public Show show(String netId){
        return new Show(netId);
    }

    public class List extends OpenStackRequest<Networks> {

        public List() {
            super(CLIENT, HttpMethod.GET, "networks", null, Networks.class);
        }
    }

    public class Query extends OpenStackRequest<Networks> {

        public Query(Network network) {
            //super(network);
//            target = target.path("v2.0").path("networks");
//            target = queryParam(target);
//            return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
        }
    }


    public class Create extends OpenStackRequest<Network> {

        public Create(Network net) {
            super(CLIENT, HttpMethod.POST, "networks", Entity.json(net), Network.class);
        }
    }

    public class Update extends OpenStackRequest<Network> {

        public Update(Network net) {
            super(CLIENT, HttpMethod.PUT, buildPath("networks/", net.getId()), Entity.json(net), Network.class);
        }
    }

    public class Show extends OpenStackRequest<Network> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("networks/", id), null, Network.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id){
            super(CLIENT, HttpMethod.DELETE, buildPath("networks/", id), null, Void.class);
        }
    }
}
