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

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;


public class QuantumTest{
	
    /**
     * JSON with read only attributes.
     */
    private static final String NETWORK_JSON = "{"
            + "  \"network\" : {"
            + "    \"id\" : \"" + ID + "\","
            + "    \"status\" : \"" + STATUS + "\","
            + "    \"subnets\" : [ \"" + SUBNET + "\" ]"
            + "  }"
            + "}";

    private ObjectMapper objectMapper;

    private String serializedNetwork;

	

}
