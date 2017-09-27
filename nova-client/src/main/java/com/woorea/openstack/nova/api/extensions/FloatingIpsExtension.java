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

package com.woorea.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIp;
import com.woorea.openstack.nova.model.FloatingIps;

public class FloatingIpsExtension {
	
	private final OpenStackClient CLIENT;
	
	public FloatingIpsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public class List extends OpenStackRequest<FloatingIps> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-floating-ips", null, FloatingIps.class);
		}

	}

	public class Allocate extends OpenStackRequest<FloatingIp> {
		
		public Allocate(Entity<?> entity) {
			super(CLIENT, HttpMethod.POST, "/os-floating-ips", entity, FloatingIp.class);
		}

	}
	
	public class Deallocate extends OpenStackRequest<Void> {
		
		public Deallocate(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuffer("/os-floating-ips/").append(id).toString(), null, Void.class);
		}
		
	}

	public List list() {
		return new List();
	}
	
	public Allocate allocate(String pool) {
		Entity<?> entity=null;
		if(pool!=null) {
			Map<String, String> body = new HashMap<String, String>();
			body.put("pool", pool);
			entity=Entity.json(body);
		}
		return new Allocate(entity);
	}
	
	public Deallocate deallocate(String id) {
		return new Deallocate(id);
	}
	
	
	
}

