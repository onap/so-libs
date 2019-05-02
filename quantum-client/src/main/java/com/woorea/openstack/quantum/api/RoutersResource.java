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
import com.woorea.openstack.quantum.model.Router;
import com.woorea.openstack.quantum.model.RouterForAddInterface;
import com.woorea.openstack.quantum.model.RouterForCreate;
import com.woorea.openstack.quantum.model.RouterInterface;
import com.woorea.openstack.quantum.model.Routers;

public class RoutersResource {

    private final OpenStackClient CLIENT;

    public RoutersResource(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(RouterForCreate router) {
        return new Create(router);
    }

    public Delete delete(String netId) {
        return new Delete(netId);
    }

    public Show show(String netId) {
        return new Show(netId);
    }

    public class List extends OpenStackRequest<Routers> {

        public List() {
            super(CLIENT, HttpMethod.GET, "routers", null, Routers.class);
        }
    }

    public class Query extends OpenStackRequest<Routers> {

        public Query(Router router) {}
    }
    public class Create extends OpenStackRequest<Router> {

        public Create(RouterForCreate router) {
            super(CLIENT, HttpMethod.POST, "routers", Entity.json(router), Router.class);
        }
    }



    public class Show extends OpenStackRequest<Router> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("routers/", id), null, Router.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, buildPath("routers/", id), null, Void.class);
        }
    }

    public Attach addInterface(RouterForAddInterface interfaceToAdd) {
        return new Attach(interfaceToAdd);
    }

    public class Attach extends OpenStackRequest<RouterInterface> {

        public Attach(RouterForAddInterface interfaceToAdd) {
            super(CLIENT, HttpMethod.PUT, buildPath("routers/", interfaceToAdd.getRouterId(), "/add_router_interface"),
                    Entity.json(interfaceToAdd), RouterInterface.class);
        }

    }

    public Detach deleteInterface(RouterForAddInterface interfaceRouter) {
        return new Detach(interfaceRouter);
    }

    public class Detach extends OpenStackRequest<RouterInterface> {

        public Detach(RouterForAddInterface interfaceToAdd) {
            super(CLIENT, HttpMethod.PUT,
                    buildPath("routers/", interfaceToAdd.getRouterId(), "/remove_router_interface"),
                    Entity.json(interfaceToAdd), RouterInterface.class);
        }

    }



}
