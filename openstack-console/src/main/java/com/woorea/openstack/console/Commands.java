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

import org.apache.commons.cli.CommandLine;

public class Commands {

	public static final Command EXIT = new Command("exit") {

		@Override
		public void execute(Console console, CommandLine args) {
			console.exit();
		}
		
	};
	
	public static final Command SET = new Command("set") {

		@Override
		public void execute(Console console, CommandLine args) {
			if(args.getArgs().length == 2) {
				console.setProperty(args.getArgs()[0], args.getArgs()[1]);
			} else {
				console.properties();
			}
		}
		
	};

}
