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

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.woorea.openstack.nova.model.Server.Addresses.Address;

public class AddressTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"version\" : 4," + EOL + "  \"addr\" : \"addr\"," + EOL
            + "  \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL + "  \"OS-EXT-IPS:type\" : \"type\"" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Address.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Address address = objectMapper.readValue(JSON_FULL, Address.class);
        String json = objectMapper.writeValueAsString(address);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Address address = objectMapper.readValue(JSON_FULL, Address.class);
        address.toString();

        String type = address.getType();
        Assert.assertNotNull(type);
        address.setType(type);

        String addr = address.getAddr();
        Assert.assertNotNull(addr);
        address.setAddr(addr);

        int version = address.getVersion();
        Assert.assertNotNull(version);
        address.setVersion(version);

        String macAddr = address.getMacAddr();
        Assert.assertNotNull(macAddr);
        address.setMacAddr(macAddr);
    }
}
