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

import com.woorea.openstack.console.utils.ConsoleUtils;
import com.woorea.openstack.keystone.Keystone;

public class KeystoneUserDelete extends KeystoneCommand {
    
    public KeystoneUserDelete() {
        super("user-delete");
    }

    @Override
    public void execute(Keystone keystone, CommandLine cmd) {
        
        String[] args = cmd.getArgs();
        if(args.length == 1) {
            keystone.users().delete(args[0]).execute();
            System.out.println(new ConsoleUtils().green("OK"));
        }
        
    }
    
}
