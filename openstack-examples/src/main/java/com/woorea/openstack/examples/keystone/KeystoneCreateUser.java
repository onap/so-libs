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

package com.woorea.openstack.examples.keystone;


import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.User;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

public class KeystoneCreateUser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
        //access with unscoped token
        Access access = keystone.tokens()
            .authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
            .withTenantName("admin")
            .execute();

        User user = new User();
        user.setEmail("luis@woorea.es");
        user.setUsername("luis.gervaso");
        user.setPassword("password.0");
        user.setName("Luis");
        user.setEnabled(Boolean.TRUE);

        keystone = new Keystone("http://keystone.x.org/v2.0");
        keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
        //keystone.enableLogging(Logger.getLogger("keystone"), 10000);
        user = keystone.users().create(user).execute();
        System.out.println(user);
        keystone.users().delete(user.getId()).execute();
    }
}
