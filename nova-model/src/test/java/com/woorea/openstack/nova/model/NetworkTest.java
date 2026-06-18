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

package com.woorea.openstack.nova.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class NetworkTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"network\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"bridge\" : \"bridge\"," + EOL + "    \"deleted\" : false," + EOL + "    \"vlan\" : \"vlan\"," + EOL
            + "    \"broadcast\" : \"broadcast\"," + EOL + "    \"netmask\" : \"netmask\"," + EOL
            + "    \"injected\" : true," + EOL + "    \"host\" : \"host\"," + EOL + "    \"cidr\" : \"cidr\"," + EOL
            + "    \"gateway\" : \"gateway\"," + EOL + "    \"dns1\" : \"dns1\"," + EOL + "    \"dns2\" : \"dns2\","
            + EOL + "    \"label\" : \"label\"," + EOL + "    \"priority\" : \"priority\"," + EOL
            + "    \"vpn_public_address\" : \"vpnpublicaddress\"," + EOL
            + "    \"vpn_private_address\" : \"vpnprivateaddress\"," + EOL
            + "    \"vpn_public_port\" : \"vpnpublicport\"," + EOL + "    \"dhcp_start\" : \"dhcpstart\"," + EOL
            + "    \"bridge_interface\" : \"bridgeinterface\"," + EOL + "    \"updated_at\" : \"updatedat\"," + EOL
            + "    \"multi_host\" : false," + EOL + "    \"created_at\" : \"createdat\"," + EOL
            + "    \"deleted_at\" : \"deletedat\"," + EOL + "    \"cidr_v6\" : \"cidrv6\"," + EOL
            + "    \"gateway_v6\" : \"gatewayv6\"," + EOL + "    \"netmask_v6\" : \"netmaskv6\"," + EOL
            + "    \"project_id\" : \"projectid\"," + EOL + "    \"rxtx_base\" : \"rxtxbase\"" + EOL + "  }" + EOL
            + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

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

        String broadcast = network.getBroadcast();
        Assertions.assertNotNull(broadcast);

        String gatewayV6 = network.getGatewayV6();
        Assertions.assertNotNull(gatewayV6);

        String dns2 = network.getDns2();
        Assertions.assertNotNull(dns2);

        String bridgeInterface = network.getBridgeInterface();
        Assertions.assertNotNull(bridgeInterface);

        String dns1 = network.getDns1();
        Assertions.assertNotNull(dns1);

        String cidrV6 = network.getCidrV6();
        Assertions.assertNotNull(cidrV6);

        String deletedAt = network.getDeletedAt();
        Assertions.assertNotNull(deletedAt);

        String vlan = network.getVlan();
        Assertions.assertNotNull(vlan);

        String netmask = network.getNetmask();
        Assertions.assertNotNull(netmask);

        String netmaskV6 = network.getNetmaskV6();
        Assertions.assertNotNull(netmaskV6);

        Boolean injected = network.getInjected();
        Assertions.assertNotNull(injected);

        String host = network.getHost();
        Assertions.assertNotNull(host);

        String cidr = network.getCidr();
        Assertions.assertNotNull(cidr);

        String id = network.getId();
        Assertions.assertNotNull(id);

        String projectId = network.getProjectId();
        Assertions.assertNotNull(projectId);

        String vpnPublicAddress = network.getVpnPublicAddress();
        Assertions.assertNotNull(vpnPublicAddress);

        String label = network.getLabel();
        Assertions.assertNotNull(label);

        String priority = network.getPriority();
        Assertions.assertNotNull(priority);

        String vpnPublicPort = network.getVpnPublicPort();
        Assertions.assertNotNull(vpnPublicPort);

        String createdAt = network.getCreatedAt();
        Assertions.assertNotNull(createdAt);

        Boolean deleted = network.getDeleted();
        Assertions.assertNotNull(deleted);

        String rxtxBase = network.getRxtxBase();
        Assertions.assertNotNull(rxtxBase);

        String dhcpStart = network.getDhcpStart();
        Assertions.assertNotNull(dhcpStart);

        Boolean multiHost = network.getMultiHost();
        Assertions.assertNotNull(multiHost);

        String bridge = network.getBridge();
        Assertions.assertNotNull(bridge);

        String gateway = network.getGateway();
        Assertions.assertNotNull(gateway);

        String updatedAt = network.getUpdatedAt();
        Assertions.assertNotNull(updatedAt);
    }
}
