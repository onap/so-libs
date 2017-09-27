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

package com.woorea.openstack.console.nova;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.Command;
import com.woorea.openstack.console.Console;
import com.woorea.openstack.nova.Nova;


public abstract class NovaCommand extends Command {
	
	public NovaCommand(String name) {
		super(name);
	}

	@Override
	public void execute(Console console, CommandLine args) {
		NovaEnvironment environment = (NovaEnvironment) console.getEnvironment();
		execute(environment.CLIENT, args);
		
	}

	protected abstract void execute(Nova nova, CommandLine args);

}
