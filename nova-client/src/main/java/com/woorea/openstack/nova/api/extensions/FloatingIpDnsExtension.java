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


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIpDomain;
import com.woorea.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {

    private final OpenStackClient CLIENT;

    public FloatingIpDnsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public ListDomains listFloatingIpDomains() {
        return new ListDomains();
    }

    public CreateDomain create(FloatingIpDomain floatingIpDomain) {
        return new CreateDomain(floatingIpDomain);
    }

    public ShowDomain show(String id) {
        return new ShowDomain(id);
    }

    public UpdateDomain update(FloatingIpDomain floatingIpDomain) {
        return new UpdateDomain(floatingIpDomain);
    }

    public DeleteDomain delete(String id) {
        return new DeleteDomain(id);
    }

    public class ListDomains extends OpenStackRequest<FloatingIpDomains> {

        public ListDomains() {
            super(CLIENT, HttpMethod.GET, "/os-floating-ip-dns", null, FloatingIpDomains.class);
        }

    }

    public class CreateDomain extends OpenStackRequest<FloatingIpDomain> {



        public CreateDomain(FloatingIpDomain floatingIpDomain) {
            super(CLIENT, HttpMethod.POST, "/os-floating-ip-dns", Entity.json(floatingIpDomain), FloatingIpDomain.class);

        }

    }

    public class ShowDomain extends OpenStackRequest<FloatingIpDomain> {

        public ShowDomain(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), null, FloatingIpDomain.class);
        }

    }


    public static class UpdateDomain extends OpenStackRequest<FloatingIpDomain> {



        public UpdateDomain(FloatingIpDomain floatingIpDomain) {


        }

    }


    public class DeleteDomain extends OpenStackRequest<Void> {

        public DeleteDomain(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), null, Void.class);
        }

    }



}