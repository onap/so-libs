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
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class FlavorForCreateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"flavor\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"name\" : \"name\"," + EOL + "    \"vcpus\" : \"vcpus\"," + EOL + "    \"ram\" : 38," + EOL
            + "    \"disk\" : \"disk\"," + EOL + "    \"swap\" : \"swap\"," + EOL
            + "    \"OS-FLV-EXT-DATA:ephemeral\" : 65," + EOL + "    \"rxtx_factor\" : 11.0" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + FlavorForCreate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        FlavorForCreate flavorforcreate = objectMapper.readValue(JSON_FULL, FlavorForCreate.class);
        String json = objectMapper.writeValueAsString(flavorforcreate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        FlavorForCreate flavorforcreate = objectMapper.readValue(JSON_FULL, FlavorForCreate.class);
        flavorforcreate.toString();

        String disk = flavorforcreate.getDisk();
        Assert.assertNotNull(disk);
        flavorforcreate.setDisk(disk);

        String swap = flavorforcreate.getSwap();
        Assert.assertNotNull(swap);
        flavorforcreate.setSwap(swap);

        String name = flavorforcreate.getName();
        Assert.assertNotNull(name);
        flavorforcreate.setName(name);

        Float rxtxFactor = flavorforcreate.getRxtxFactor();
        Assert.assertNotNull(rxtxFactor);
        flavorforcreate.setRxtxFactor(rxtxFactor);

        Integer ephemeral = flavorforcreate.getEphemeral();
        Assert.assertNotNull(ephemeral);
        flavorforcreate.setEphemeral(ephemeral);

        String id = flavorforcreate.getId();
        Assert.assertNotNull(id);
        flavorforcreate.setId(id);

        String vcpus = flavorforcreate.getVcpus();
        Assert.assertNotNull(vcpus);
        flavorforcreate.setVcpus(vcpus);

        Integer ram = flavorforcreate.getRam();
        Assert.assertNotNull(ram);
        flavorforcreate.setRam(ram);
    }
}
