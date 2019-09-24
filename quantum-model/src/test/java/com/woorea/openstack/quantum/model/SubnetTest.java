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
import com.woorea.openstack.quantum.model.Subnet.IpVersion;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SubnetTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"subnet\" : {" + EOL + "    \"name\" : \"name\"," + EOL
            + "    \"cidr\" : \"cidr\"," + EOL + "    \"enable_dhcp\" : true," + EOL
            + "    \"network_id\" : \"networkid\"," + EOL + "    \"tenant_id\" : \"tenantid\"," + EOL
            + "    \"dns_nameservers\" : [ \"dnsnames-v1\", \"dnsnames-v2\" ]," + EOL + "    \"allocation_pools\" : [ {"
            + EOL + "      \"start\" : \"start\"," + EOL + "      \"end\" : \"end\"" + EOL + "    }, {" + EOL
            + "      \"start\" : \"start\"," + EOL + "      \"end\" : \"end\"" + EOL + "    } ]," + EOL
            + "    \"host_routes\" : [ {" + EOL + "      \"destination\" : \"destination\"," + EOL
            + "      \"nexthop\" : \"nexthop\"" + EOL + "    }, {" + EOL + "      \"destination\" : \"destination\","
            + EOL + "      \"nexthop\" : \"nexthop\"" + EOL + "    } ]," + EOL + "    \"ip_version\" : 4," + EOL
            + "    \"gateway_ip\" : \"gw\"" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Subnet.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Subnet subnet = objectMapper.readValue(JSON_FULL, Subnet.class);
        String json = objectMapper.writeValueAsString(subnet);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Subnet subnet = objectMapper.readValue(JSON_FULL, Subnet.class);
        subnet.toString();

        String gw = subnet.getGw();
        Assert.assertNotNull(gw);
        subnet.setGw(gw);

        List<String> dnsNames = subnet.getDnsNames();
        Assert.assertNotNull(dnsNames);
        Assert.assertEquals(2, dnsNames.size());
        subnet.setDnsNames(dnsNames);

        List<Routes> hostRoutes = subnet.getHostRoutes();
        Assert.assertNotNull(hostRoutes);
        Assert.assertEquals(2, hostRoutes.size());
        subnet.setHostRoutes(hostRoutes);

        String name = subnet.getName();
        Assert.assertNotNull(name);
        subnet.setName(name);

        String tenantId = subnet.getTenantId();
        Assert.assertNotNull(tenantId);
        subnet.setTenantId(tenantId);

        String cidr = subnet.getCidr();
        Assert.assertNotNull(cidr);
        subnet.setCidr(cidr);

        String networkId = subnet.getNetworkId();
        Assert.assertNotNull(networkId);
        subnet.setNetworkId(networkId);

        Boolean enableDHCP = subnet.getEnableDHCP();
        Assert.assertNotNull(enableDHCP);
        subnet.setEnableDHCP(enableDHCP);

        IpVersion ipversion = subnet.getIpversion();
        Assert.assertNotNull(ipversion);
        subnet.setIpversion(ipversion);

        List<Pool> list = subnet.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        subnet.setList(list);
    }
}
