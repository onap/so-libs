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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.woorea.openstack.quantum.model.Port.Binding;
import com.woorea.openstack.quantum.model.Port.Ip;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class PortTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"port\" : {" + EOL + "    \"name\" : \"name\"," + EOL
            + "    \"binding:host_id\" : \"hostid\"," + EOL + "    \"binding:vif_type\" : \"viftype\"," + EOL
            + "    \"binding:vnic_type\" : \"vnictype\"," + EOL + "    \"binding:vif_details\" : {" + EOL
            + "      \"vifdetails-k1\" : \"vifdetails-v1\"," + EOL + "      \"vifdetails-k2\" : \"vifdetails-v2\"" + EOL
            + "    }," + EOL + "    \"binding:profile\" : {" + EOL + "      \"profile-k1\" : \"profile-v1\"," + EOL
            + "      \"profile-k2\" : \"profile-v2\"" + EOL + "    }," + EOL + "    \"admin_state_up\" : false," + EOL
            + "    \"device_id\" : \"deviceid\"," + EOL + "    \"device_owner\" : \"deviceowner\"," + EOL
            + "    \"fixed_ips\" : [ {" + EOL + "      \"ip_address\" : \"address\"," + EOL
            + "      \"subnet_id\" : \"subnetid\"" + EOL + "    }, {" + EOL + "      \"ip_address\" : \"address\","
            + EOL + "      \"subnet_id\" : \"subnetid\"" + EOL + "    } ]," + EOL
            + "    \"mac_address\" : \"macaddress\"," + EOL + "    \"network_id\" : \"networkid\"," + EOL
            + "    \"tenant_id\" : \"tenantid\"," + EOL
            + "    \"security_groups\" : [ \"securitygroups-v1\", \"securitygroups-v2\" ]" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Port.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Port port = objectMapper.readValue(JSON_FULL, Port.class);
        String json = objectMapper.writeValueAsString(port);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Port port = objectMapper.readValue(JSON_FULL, Port.class);
        port.toString();

        String deviceOwner = port.getDeviceOwner();
        Assert.assertNotNull(deviceOwner);
        port.setDeviceOwner(deviceOwner);

        Boolean adminStateUp = port.getAdminStateUp();
        Assert.assertNotNull(adminStateUp);
        port.setAdminStateUp(adminStateUp);

        String name = port.getName();
        Assert.assertNotNull(name);
        port.setName(name);

        String tenantId = port.getTenantId();
        Assert.assertNotNull(tenantId);
        port.setTenantId(tenantId);

        Binding binding = port.getBinding();
        Assert.assertNotNull(binding);
        port.setBinding(binding);

        String macAddress = port.getMacAddress();
        Assert.assertNotNull(macAddress);
        port.setMacAddress(macAddress);

        String networkId = port.getNetworkId();
        Assert.assertNotNull(networkId);
        port.setNetworkId(networkId);

        List<Ip> list = port.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        port.setList(list);

        List<String> securityGroups = port.getSecurityGroups();
        Assert.assertNotNull(securityGroups);
        Assert.assertEquals(2, securityGroups.size());
        port.setSecurityGroups(securityGroups);

        String deviceId = port.getDeviceId();
        Assert.assertNotNull(deviceId);
        port.setDeviceId(deviceId);
    }
}
