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

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Metadata;
import com.woorea.openstack.keystone.model.Roles;
import com.woorea.openstack.keystone.model.Tenant;
import com.woorea.openstack.keystone.model.Tenants;
import com.woorea.openstack.keystone.model.Users;

public class TenantsResource {

    private static final String TENANTS = "/tenants/";
    private static final String USERS = "/users/";
    private static final String METADATA = "/metadata";
    private final OpenStackClient client;

    public TenantsResource(OpenStackClient client) {
        this.client = client;
    }

    public List list() {
        return new List();
    }

    public Create create(Tenant tenant) {
        return new Create(tenant);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public Update update(String id, Tenant tenant) {
        return new Update(id, tenant);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public ListUsers listUsers(String tenantId) {
        return new ListUsers(tenantId);
    }

    public AddUser addUser(String tenantId, String userId, String roleId) {
        return new AddUser(tenantId, userId, roleId);
    }

    public RemoveUser removeUser(String tenantId, String userId, String roleId) {
        return new RemoveUser(tenantId, userId, roleId);
    }

    public ListUserRoles listUserRoles(String tenantId, String userId) {
        return new ListUserRoles(tenantId, userId);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    public CreateOrUpdateMetadata createOrUpdateMetadata(String id, Metadata metadata) {
        return new CreateOrUpdateMetadata(id, metadata);
    }

    public ReplaceMetadata replaceMetadata(String id, Metadata metadata) {
        return new ReplaceMetadata(id, metadata);
    }

    public ShowMetadataItem showMetadataItem(String id, String key) {
        return new ShowMetadataItem(id, key);
    }

    public CreateOrUpdateMetadataItem createOrUpdateMetadataItem(String id, String key, Metadata metadata) {
        return new CreateOrUpdateMetadataItem(id, key, metadata);
    }

    public DeleteMetadataItem deleteMetadataItem(String id, String key) {
        return new DeleteMetadataItem(id, key);
    }

    public class List extends OpenStackRequest<Tenants> {

        public List() {
            super(client, HttpMethod.GET, "/tenants", null, Tenants.class);
        }
    }

    public class Create extends OpenStackRequest<Tenant> {

        private Tenant tenant;

        public Create(Tenant tenant) {
            super(client, HttpMethod.POST, "/tenants", Entity.json(tenant), Tenant.class);
            this.tenant = tenant;
        }
    }

    public class Show extends OpenStackRequest<Tenant> {

        public Show(String id) {
            super(client, HttpMethod.GET, getTenantsString(id).toString(), null, Tenant.class);
        }
    }

    public class Update extends OpenStackRequest<Tenant> {

        private Tenant tenant;

        public Update(String id, Tenant tenant) {
            super(client, HttpMethod.PUT, getTenantsString(id).toString(), Entity.json(tenant), Tenant.class);
            this.tenant = tenant;
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, getTenantsString(id).toString(), null, Void.class);
        }
    }

    public class ListUsers extends OpenStackRequest<Users> {

        public ListUsers(String tenantId) {
            super(client, HttpMethod.GET, getTenantsString(tenantId).append("/users").toString(), null, Users.class);
        }
    }

    public class AddUser extends OpenStackRequest<Void> {

        public AddUser(String tenantId, String userId, String roleId) {
            super(client, HttpMethod.PUT, getTenantsString(tenantId).append(USERS).append(userId)
                    .append("/roles/OS-KSADM/").append(roleId).toString(), null, Void.class);
        }
    }

    public class RemoveUser extends OpenStackRequest<Void> {

        public RemoveUser(String tenantId, String userId, String roleId) {
            super(client, HttpMethod.DELETE, getTenantsString(tenantId).append(USERS).append(userId)
                    .append("/roles/OS-KSADM/").append(roleId).toString(), null, Void.class);
        }
    }

    public class ListUserRoles extends OpenStackRequest<Roles> {

        public ListUserRoles(String tenantId, String userId) {
            super(client, HttpMethod.GET,
                    getTenantsString(tenantId).append(USERS).append(userId).append("/roles").toString(), null,
                    Roles.class);
        }
    }

    /**
     * The following APIs support Tenant-level metadata. This is a feature supported by the DCP/LCP (i.e. AIC cloud),
     * but not native Openstack. The full API as documented by AIC is implemented below.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String tenantId) {
            super(client, HttpMethod.GET, getTenantsString(tenantId).append(METADATA), null, Metadata.class);
        }
    }

    public class CreateOrUpdateMetadata extends OpenStackRequest<Metadata> {

        public CreateOrUpdateMetadata(String tenantId, Metadata metadata) {
            super(client, HttpMethod.POST, getTenantsString(tenantId).append(METADATA), Entity.json(metadata),
                    Metadata.class);
        }
    }

    public class ReplaceMetadata extends OpenStackRequest<Metadata> {

        public ReplaceMetadata(String tenantId, Metadata metadata) {
            super(client, HttpMethod.PUT, getTenantsString(tenantId).append(METADATA), Entity.json(metadata),
                    Metadata.class);
        }
    }

    public class ShowMetadataItem extends OpenStackRequest<Metadata> {

        public ShowMetadataItem(String tenantId, String key) {
            super(client, HttpMethod.GET, getTenantsString(tenantId).append(METADATA).append(key), null,
                    Metadata.class);
        }
    }

    public class CreateOrUpdateMetadataItem extends OpenStackRequest<Metadata> {

        public CreateOrUpdateMetadataItem(String tenantId, String key, Metadata metadata) {
            super(client, HttpMethod.POST, getTenantsString(tenantId).append(METADATA).append(key),
                    Entity.json(metadata), Metadata.class);
        }
    }

    public class DeleteMetadataItem extends OpenStackRequest<Void> {

        public DeleteMetadataItem(String tenantId, String key) {
            super(client, HttpMethod.DELETE, getTenantsString(tenantId).append("/metadata/").append(key), null,
                    Void.class);
        }
    }

    private StringBuilder getTenantsString(String tenantId) {
        return new StringBuilder(TENANTS).append(tenantId);
    }
}
