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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class RouterTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"router\" : {" + EOL
        + "    \"status\" : \"status\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"admin_state_up\" : \"admin_state_up\"," + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"routes\" : [ {" + EOL
        + "      \"destination\" : \"destination\"," + EOL
        + "      \"nexthop\" : \"nexthop\"" + EOL
        + "    }, {" + EOL
        + "      \"destination\" : \"destination\"," + EOL
        + "      \"nexthop\" : \"nexthop\"" + EOL
        + "    } ]," + EOL
        + "    \"external_gateway_info\" : {" + EOL
        + "      \"network_id\" : \"networkid\"" + EOL
        + "    }," + EOL
        + "    \"tenant_id\" : \"tenantid\"" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(SerializationFeature.WRAP_ROOT_VALUE)
        .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Router.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Router router = objectMapper.readValue(JSON_FULL, Router.class);
        String json = objectMapper.writeValueAsString(router);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Router router = objectMapper.readValue(JSON_FULL, Router.class);
        router.toString();
        
        List<HostRoute> routes = router.getRoutes();
        Assert.assertNotNull(routes);
        Assert.assertEquals(2, routes.size());
        router.setRoutes(routes);
        
        String admin_state_up = router.getAdmin_state_up();
        Assert.assertNotNull(admin_state_up);
        router.setAdmin_state_up(admin_state_up);
        
        String name = router.getName();
        Assert.assertNotNull(name);
        router.setName(name);
        
        String tenantId = router.getTenantId();
        Assert.assertNotNull(tenantId);
        router.setTenantId(tenantId);
        
        GatewayInfo externalGatewayInfo = router.getExternalGatewayInfo();
        Assert.assertNotNull(externalGatewayInfo);
        router.setExternalGatewayInfo(externalGatewayInfo);
        
        String id = router.getId();
        Assert.assertNotNull(id);
        router.setId(id);
        
        String status = router.getStatus();
        Assert.assertNotNull(status);
        router.setStatus(status);
    }
}
