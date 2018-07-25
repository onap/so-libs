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

package com.woorea.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.console.Command;
import com.woorea.openstack.console.Console;
import com.woorea.openstack.console.Environment;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

public class KeystoneEnvironment extends Environment {
    
    public final Keystone CLIENT;
    
    public static final Command KEYSTONE = new Command("keystone") {
        
        @Override
        public void execute(Console console, CommandLine args) {
            
            Keystone client = new Keystone(console.getProperty("keystone.endpoint"));
            
            Access access = client.tokens()
                .authenticate(new UsernamePassword(
                    console.getProperty("keystone.username"), 
                    console.getProperty("keystone.password")
                ))
                .withTenantName(console.getProperty("keystone.tenant_name"))
                .execute();
                    
            client.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
            
            KeystoneEnvironment environment = new KeystoneEnvironment(console.getEnvironment(), client);
            
            environment.register(new KeystoneTenantList());
            environment.register(new KeystoneTenantCreate());
            environment.register(new KeystoneTenantDelete());
            environment.register(new KeystoneUserList());
            environment.register(new KeystoneUserCreate());
            environment.register(new KeystoneUserDelete());
            environment.register(new KeystoneRoleList());
            environment.register(new KeystoneRoleDelete());
            environment.register(new KeystoneServiceList());    
            console.setEnvironment(environment);
        }
        
    };
    
    public KeystoneEnvironment(Environment parent, Keystone client) {
        super(parent);
        CLIENT = client;
    }

    /* (non-Javadoc)
     * @see org.woorea.wsh.Environment#getPrompt()
     */
    @Override
    public String getPrompt() {
        return "keystone> ";
    }
    
}
