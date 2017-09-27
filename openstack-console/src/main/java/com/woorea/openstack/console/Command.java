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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;


public abstract class Command {
	
	protected String name;
	
	public Command(String name) {
		this.name = name;
	}

	public abstract void execute(Console console, CommandLine args);
	
	public Options getOptions() {
		return new Options();
	}

}
