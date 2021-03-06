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

package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Role;
import com.woorea.openstack.keystone.model.Roles;

public class DomainUserRolesResource extends GenericResource<Role, Roles> {

    public DomainUserRolesResource(OpenStackClient client, String path) {
        super(client, path, Role.class, Roles.class);
    }

    public OpenStackRequest<Void> add(String roleId) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.PUT,
                new StringBuilder(path).append("/").append(roleId).toString(), Entity.json(""), Void.class);
    }

    public OpenStackRequest<Void> remove(String roleId) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.DELETE,
                new StringBuilder(path).append("/").append(roleId).toString(), null, Void.class);
    }

}
