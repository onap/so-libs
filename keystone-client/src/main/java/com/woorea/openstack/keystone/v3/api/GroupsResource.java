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

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.Group;
import com.woorea.openstack.keystone.v3.model.Groups;

public class GroupsResource extends GenericResource<Group, Groups> {

    public GroupsResource(OpenStackClient client) {
        super(client, "/groups", Group.class, Groups.class);
    }
    
    public DomainUserRolesResource userRoles(String domainId, String userId) {
        return new DomainUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(domainId).append("/users/").append(userId).append("/roles").toString());
    }

}
