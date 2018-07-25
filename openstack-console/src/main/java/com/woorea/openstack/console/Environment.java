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

package com.woorea.openstack.console;
import java.util.Map;
import java.util.TreeMap;


public class Environment {

    protected final Environment parent;
    
    protected Map<String, Command> commands = new TreeMap<String, Command>();
    
    public Environment(Environment parent) {
        register(Commands.EXIT);
        register(Commands.SET);
        this.parent = parent;
    }
    
    public Environment() {
        this(null);
    }

    public void register(Command command) {
        commands.put(command.name, command);
    }

    public String getPrompt() {
        return "> ";
    }

}
