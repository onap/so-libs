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

package com.woorea.openstack.examples.compute;


import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import com.woorea.openstack.nova.Nova;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.Servers;

public class NovaListServers {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
        Access access = keystone.tokens().authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
                .withTenantName("demo")
                .execute();
        
        //use the token in the following requests
        keystone.token(access.getToken().getId());
            
        //NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
        Nova novaClient = new Nova(ExamplesConfiguration.NOVA_ENDPOINT.concat("/").concat(access.getToken().getTenant().getId()));
        novaClient.token(access.getToken().getId());
        //novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);
        
        Servers servers = novaClient.servers().list(true).execute();
        for(Server server : servers) {
            System.out.println(server);
        }
        
    }

}
