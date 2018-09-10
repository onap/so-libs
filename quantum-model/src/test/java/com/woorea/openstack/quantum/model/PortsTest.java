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

import com.woorea.openstack.quantum.model.Port;
import com.woorea.openstack.quantum.model.Ports;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class PortsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"ports\" : [ {" + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"binding:host_id\" : \"hostid\"," + EOL
        + "    \"binding:vif_type\" : \"viftype\"," + EOL
        + "    \"binding:vnic_type\" : \"vnictype\"," + EOL
        + "    \"binding:vif_details\" : {" + EOL
        + "      \"vifdetails-k1\" : \"vifdetails-v1\"," + EOL
        + "      \"vifdetails-k2\" : \"vifdetails-v2\"" + EOL
        + "    }," + EOL
        + "    \"binding:profile\" : {" + EOL
        + "      \"profile-k1\" : \"profile-v1\"," + EOL
        + "      \"profile-k2\" : \"profile-v2\"" + EOL
        + "    }," + EOL
        + "    \"admin_state_up\" : false," + EOL
        + "    \"device_id\" : \"deviceid\"," + EOL
        + "    \"device_owner\" : \"deviceowner\"," + EOL
        + "    \"fixed_ips\" : [ {" + EOL
        + "      \"ip_address\" : \"address\"," + EOL
        + "      \"subnet_id\" : \"subnetid\"" + EOL
        + "    }, {" + EOL
        + "      \"ip_address\" : \"address\"," + EOL
        + "      \"subnet_id\" : \"subnetid\"" + EOL
        + "    } ]," + EOL
        + "    \"mac_address\" : \"macaddress\"," + EOL
        + "    \"network_id\" : \"networkid\"," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"security_groups\" : [ \"securitygroups-v1\", \"securitygroups-v2\" ]" + EOL
        + "  }, {" + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"binding:host_id\" : \"hostid\"," + EOL
        + "    \"binding:vif_type\" : \"viftype\"," + EOL
        + "    \"binding:vnic_type\" : \"vnictype\"," + EOL
        + "    \"binding:vif_details\" : {" + EOL
        + "      \"vifdetails-k1\" : \"vifdetails-v1\"," + EOL
        + "      \"vifdetails-k2\" : \"vifdetails-v2\"" + EOL
        + "    }," + EOL
        + "    \"binding:profile\" : {" + EOL
        + "      \"profile-k1\" : \"profile-v1\"," + EOL
        + "      \"profile-k2\" : \"profile-v2\"" + EOL
        + "    }," + EOL
        + "    \"admin_state_up\" : false," + EOL
        + "    \"device_id\" : \"deviceid\"," + EOL
        + "    \"device_owner\" : \"deviceowner\"," + EOL
        + "    \"fixed_ips\" : [ {" + EOL
        + "      \"ip_address\" : \"address\"," + EOL
        + "      \"subnet_id\" : \"subnetid\"" + EOL
        + "    }, {" + EOL
        + "      \"ip_address\" : \"address\"," + EOL
        + "      \"subnet_id\" : \"subnetid\"" + EOL
        + "    } ]," + EOL
        + "    \"mac_address\" : \"macaddress\"," + EOL
        + "    \"network_id\" : \"networkid\"," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"security_groups\" : [ \"securitygroups-v1\", \"securitygroups-v2\" ]" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Ports.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Ports ports = objectMapper.readValue(JSON_FULL, Ports.class);
        String json = objectMapper.writeValueAsString(ports);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Ports ports = objectMapper.readValue(JSON_FULL, Ports.class);
        ports.toString();
        
        List<Port> list = ports.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        ports.setList(list);
        
        int cnt = 0;
        for (@SuppressWarnings("unused") Port x : ports) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
