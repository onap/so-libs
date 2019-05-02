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


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.User;
import com.woorea.openstack.keystone.model.Users;

public class UsersResource {

    private static final String USERS = "/users/";
    private OpenStackClient client;

    public UsersResource(OpenStackClient client) {
        this.client = client;
    }

    public List list() {
        return new List();
    }

    public Create create(User user) {
        return new Create(user);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public Update update(String id, User user) {
        return new Update(id, user);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Users> {

        public List() {
            super(client, HttpMethod.GET, "/users", null, Users.class);
        }
    }

    public class Create extends OpenStackRequest<User> {

        private User user;

        public Create(User user) {
            super(client, HttpMethod.POST, "/users", Entity.json(user), User.class);
            this.user = user;
        }
    }

    public class Show extends OpenStackRequest<User> {

        public Show(String id) {
            super(client, HttpMethod.GET, getUserString(id), null, User.class);
        }
    }

    public class Update extends OpenStackRequest<User> {

        private User user;

        public Update(String id, User user) {
            super(client, HttpMethod.PUT, getUserString(id), Entity.json(user), User.class);
            this.user = user;
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, getUserString(id), null, Void.class);
        }
    }

    private String getUserString(String id) {
        return USERS + id;
    }
}
