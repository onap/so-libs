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
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Services;
import com.woorea.openstack.keystone.v3.model.User;
import com.woorea.openstack.keystone.v3.model.Users;

public class UsersResource extends GenericResource<User, Users> {

    public UsersResource(OpenStackClient client) {
        super(client, "/users", User.class, Users.class);
    }

    public OpenStackRequest<Services> groups(String userId) {
        return CLIENT.get(new StringBuilder(path).append("/").append(userId).append("/groups").toString(),
                Services.class);
    }

    public OpenStackRequest<Services> projects(String userId) {
        return CLIENT.get(new StringBuilder(path).append("/").append(userId).append("/projects").toString(),
                Services.class);
    }

    public OpenStackRequest<Services> roles(String userId) {
        return CLIENT.get(new StringBuilder(path).append("/").append(userId).append("/roles").toString(),
                Services.class);
    }

}
