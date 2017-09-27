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

package com.woorea.openstack.ceilometer.v2.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Meter {

	@JsonProperty("user_id")
	private String user;
	
	
	private String name;
	
	@JsonProperty("resource_id")
	private String resource;
	
	@JsonProperty("project_id")
	private String project;
	
	private String type;
	
	private String unit;

	public String getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public String getResource() {
		return resource;
	}

	public String getProject() {
		return project;
	}

	public String getType() {
		return type;
	}

	public String getUnit() {
		return unit;
	}

	@Override
	public String toString() {
		return "Meter [user=" + user + ", name=" + name + ", resource="
				+ resource + ", project=" + project + ", type=" + type
				+ ", unit=" + unit + "]";
	}

}
