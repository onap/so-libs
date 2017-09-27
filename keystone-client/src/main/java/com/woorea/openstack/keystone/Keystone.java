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

package com.woorea.openstack.keystone;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.keystone.api.EndpointsResource;
import com.woorea.openstack.keystone.api.RolesResource;
import com.woorea.openstack.keystone.api.ServicesResource;
import com.woorea.openstack.keystone.api.TenantsResource;
import com.woorea.openstack.keystone.api.TokensResource;
import com.woorea.openstack.keystone.api.UsersResource;

public class Keystone extends OpenStackClient {

    private final TokensResource tokens;

    private final TenantsResource tenants;

    private final UsersResource users;

    private final RolesResource roles;

    private final ServicesResource services;

    private final EndpointsResource endpoints;

    public Keystone(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        tokens = new TokensResource(this);
        tenants = new TenantsResource(this);
        users = new UsersResource(this);
        roles = new RolesResource(this);
        services = new ServicesResource(this);
        endpoints = new EndpointsResource(this);
    }

    public Keystone(String endpoint) {
        this(endpoint, null);
    }

    public TokensResource tokens() {
        return tokens;
    }

    public TenantsResource tenants() {
        return tenants;
    }

    public UsersResource users() {
        return users;
    }

    public RolesResource roles() {
        return roles;
    }

    public ServicesResource services() {
        return services;
    }

    public EndpointsResource endpoints() {
        return endpoints;
    }
}
