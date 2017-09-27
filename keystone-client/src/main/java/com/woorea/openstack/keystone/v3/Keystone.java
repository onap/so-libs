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

package com.woorea.openstack.keystone.v3;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.keystone.v3.api.DomainsResource;
import com.woorea.openstack.keystone.v3.api.EndpointsResource;
import com.woorea.openstack.keystone.v3.api.ProjectsResource;
import com.woorea.openstack.keystone.v3.api.RolesResource;
import com.woorea.openstack.keystone.v3.api.ServicesResource;
import com.woorea.openstack.keystone.v3.api.TokensResource;
import com.woorea.openstack.keystone.v3.api.UsersResource;

public class Keystone extends OpenStackClient {

    private final TokensResource tokens;

    private final DomainsResource domains;

    private final ProjectsResource projects;

    private final UsersResource users;

    private final RolesResource roles;

    private final ServicesResource services;

    private final EndpointsResource endpoints;

    public Keystone(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        tokens = new TokensResource(this);
        domains = new DomainsResource(this);
        projects = new ProjectsResource(this);
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

    public DomainsResource domains() {
        return domains;
    }

    public ProjectsResource projects() {
        return projects;
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

