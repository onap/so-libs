/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
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

package com.woorea.openstack.quantum.model;

import com.woorea.openstack.quantum.model.Network;
import com.woorea.openstack.quantum.model.Segment;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class NetworkTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"network\" : {" + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"shared\" : \"shared\"," + EOL
        + "    \"segments\" : [ {" + EOL
        + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
        + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
        + "      \"provider:segmentation_id\" : 92" + EOL
        + "    }, {" + EOL
        + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
        + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
        + "      \"provider:segmentation_id\" : 92" + EOL
        + "    } ]," + EOL
        + "    \"admin_state_up\" : false," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
        + "    \"provider:network_type\" : \"providernetworktype\"," + EOL
        + "    \"provider:segmentation_id\" : 92," + EOL
        + "    \"router:external\" : \"routerexternal\"" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(SerializationConfig.Feature.WRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Network.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Network network = objectMapper.readValue(JSON_FULL, Network.class);
        String json = objectMapper.writeValueAsString(network);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Network network = objectMapper.readValue(JSON_FULL, Network.class);
        network.toString();
        
        String shared = network.getShared();
        Assert.assertNotNull(shared);
        network.setShared(shared);
        
        String providerNetworkType = network.getProviderNetworkType();
        Assert.assertNotNull(providerNetworkType);
        network.setProviderNetworkType(providerNetworkType);
        
        String routerExternal = network.getRouterExternal();
        Assert.assertNotNull(routerExternal);
        network.setRouterExternal(routerExternal);
        
        Integer providerSegmentationId = network.getProviderSegmentationId();
        Assert.assertNotNull(providerSegmentationId);
        network.setProviderSegmentationId(providerSegmentationId);
        
        List<Segment> segments = network.getSegments();
        Assert.assertNotNull(segments);
        Assert.assertEquals(2, segments.size());
        network.setSegments(segments);
        
        Boolean adminStateUp = network.getAdminStateUp();
        Assert.assertNotNull(adminStateUp);
        network.setAdminStateUp(adminStateUp);
        
        String tenantId = network.getTenantId();
        Assert.assertNotNull(tenantId);
        network.setTenantId(tenantId);
        
        String name = network.getName();
        Assert.assertNotNull(name);
        network.setName(name);
        
        String providerPhysicalNetwork = network.getProviderPhysicalNetwork();
        Assert.assertNotNull(providerPhysicalNetwork);
        network.setProviderPhysicalNetwork(providerPhysicalNetwork);
    }
}
