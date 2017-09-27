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

package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Users;
import com.woorea.openstack.keystone.v3.model.Project;
import com.woorea.openstack.keystone.v3.model.Projects;

public class ProjectsResource extends GenericResource<Project, Projects> {

	public ProjectsResource(OpenStackClient client) {
		super(client, "/projects", Project.class, Projects.class);
	}
	
	public OpenStackRequest<Users> users(String projectId) {
		return CLIENT.get(new StringBuilder(path).append("/").append(projectId).append("/users/").toString(), Users.class);
	}
	
	public ProjectUserRolesResource userRoles(String projectId, String userId) {
		return new ProjectUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(projectId).append("/users/").append(userId).append("/roles").toString());
	}
	
	public ProjectUserRolesResource groupRoles(String projectId, String groupId) {
		return new ProjectUserRolesResource(CLIENT, new StringBuilder(path).append("/").append(projectId).append("/groups/").append(groupId).append("/roles").toString());
	}

}
