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

package com.woorea.openstack.console.utils;

public class ConsoleUtils {
	
	public static final String RED = "\u001B[31m";
	
	public static final String GREEN = "\u001B[32m";
	
	public static final String YELLOW = "\u001B[33m";
	
	public static final String END = "\u001B[0m";
	
	private StringBuilder sb = new StringBuilder();
	
	public ConsoleUtils append(String text) {
		sb.append(text);
		return this;
	}
	
	public ConsoleUtils red(String text) {
		sb.append(ConsoleUtils.RED).append(text).append(END);
		return this;
	}
	
	public ConsoleUtils green(String text) {
		sb.append(ConsoleUtils.GREEN).append(text).append(END);
		return this;
	}
	
	public ConsoleUtils yellow(String text) {
		sb.append(ConsoleUtils.YELLOW).append(text).append(END);
		return this;
	}
	
	public static void log(String text) {
		System.out.println(new ConsoleUtils().yellow("| ").append(text));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
