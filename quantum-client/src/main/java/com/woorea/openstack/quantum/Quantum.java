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

package com.woorea.openstack.quantum;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.quantum.api.NetworksResource;
import com.woorea.openstack.quantum.api.PortsResource;
import com.woorea.openstack.quantum.api.RoutersResource;
import com.woorea.openstack.quantum.api.SubnetsResource;


public class Quantum extends OpenStackClient {
	
	private final NetworksResource NETWORKS;
	
	private final PortsResource PORTS;
	
	private final SubnetsResource SUBNETS;
	private final RoutersResource ROUTERS;
	
	public Quantum(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		NETWORKS = new NetworksResource(this);
		PORTS = new PortsResource(this);
		SUBNETS = new SubnetsResource(this);
		ROUTERS=new RoutersResource(this);	
		
	}
	
	public Quantum(String endpoint) {
		this(endpoint, null);
	}
	
	public NetworksResource networks() {
		return NETWORKS;
	}
	
	public PortsResource ports() {
		return PORTS;
	}
	
	public SubnetsResource subnets() {
		return SUBNETS;
	}
	public RoutersResource routers()
	{
		return ROUTERS;
	}
	

}
