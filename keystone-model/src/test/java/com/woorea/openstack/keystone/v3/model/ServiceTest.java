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

package com.woorea.openstack.keystone.v3.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.woorea.openstack.keystone.v3.model.Token.Service;
import com.woorea.openstack.keystone.v3.model.Token.Service.Endpoint;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ServiceTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL =
            "{" + EOL + "  \"id\" : \"id\"," + EOL + "  \"type\" : \"type\"," + EOL + "  \"endpoints\" : [ {" + EOL
                    + "    \"id\" : \"id\"," + EOL + "    \"url\" : \"url\"," + EOL + "    \"region\" : \"region\","
                    + EOL + "    \"enabled\" : false," + EOL + "    \"interface\" : \"interface\"," + EOL
                    + "    \"legacy_endpoint_id\" : \"legacyendpointid\"" + EOL + "  }, {" + EOL
                    + "    \"id\" : \"id\"," + EOL + "    \"url\" : \"url\"," + EOL + "    \"region\" : \"region\","
                    + EOL + "    \"enabled\" : false," + EOL + "    \"interface\" : \"interface\"," + EOL
                    + "    \"legacy_endpoint_id\" : \"legacyendpointid\"" + EOL + "  } ]" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Service.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Service service = objectMapper.readValue(JSON_FULL, Service.class);
        String json = objectMapper.writeValueAsString(service);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Service service = objectMapper.readValue(JSON_FULL, Service.class);
        service.toString();

        List<Endpoint> endpoints = service.getEndpoints();
        Assert.assertNotNull(endpoints);
        Assert.assertEquals(2, endpoints.size());
        service.setEndpoints(endpoints);

        String id = service.getId();
        Assert.assertNotNull(id);
        service.setId(id);

        String type = service.getType();
        Assert.assertNotNull(type);
        service.setType(type);
    }
}
