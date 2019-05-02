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

package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.Events;

/**
 * v1/{tenant_id}/stacks/{stack_name}/{stack_id}/events
 */
public class StackEvents {
	private final OpenStackClient client;

	public StackEvents(OpenStackClient client) {
		this.client = client;
	}

	public ListEvents listEvents(String name, String id) {
		return new ListEvents(name, id);
	}

	/**
	 * v1/​{tenant_id}​/stacks/​{stack_name}​/resources
	 */
	public class ListEvents extends OpenStackRequest<Events> {
		public ListEvents(String name, String id) {
			super(client, HttpMethod.GET, "/stacks/" + name + "/" + id + "/events", null, Events.class);
		}
	}
}
