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

package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Metadata;

public class FlavorsResource {

    private final OpenStackClient client;

    public FlavorsResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(Flavor flavor) {
        return new Create(flavor);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }


    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Flavors> {

        public List(boolean detail) {
            super(client, HttpMethod.GET, detail ? "/flavors/detail" : "/flavors", null, Flavors.class);
        }
    }

    public class Create extends OpenStackRequest<Flavor> {

        private Flavor flavor;

        public Create(Flavor flavor) {
            super(client, HttpMethod.POST, "/flavors", Entity.json(flavor), Flavor.class);
            this.flavor = flavor;
        }
    }

    public class Show extends OpenStackRequest<Flavor> {

        public Show(String id) {
            super(client, HttpMethod.GET, getFlavorsString(id), null, Flavor.class);
        }
    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(client, HttpMethod.GET, "/flavors/" + id + "/metadata", null, Metadata.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, getFlavorsString(id), null, Void.class);
        }
    }

    private String getFlavorsString(String id) {
        return "/flavors/" + id;
    }
}

