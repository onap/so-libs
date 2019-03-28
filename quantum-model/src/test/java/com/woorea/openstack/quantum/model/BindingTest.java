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

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class BindingTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"binding:host_id\" : \"hostid\"," + EOL
        + "  \"binding:vif_type\" : \"viftype\"," + EOL
        + "  \"binding:vnic_type\" : \"vnictype\"," + EOL
        + "  \"binding:vif_details\" : {" + EOL
        + "    \"vifdetails-k1\" : \"vifdetails-v1\"," + EOL
        + "    \"vifdetails-k2\" : \"vifdetails-v2\"" + EOL
        + "  }," + EOL
        + "  \"binding:profile\" : {" + EOL
        + "    \"profile-k1\" : \"profile-v1\"," + EOL
        + "    \"profile-k2\" : \"profile-v2\"" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Binding.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Binding binding = objectMapper.readValue(JSON_FULL, Binding.class);
        String json = objectMapper.writeValueAsString(binding);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Binding binding = objectMapper.readValue(JSON_FULL, Binding.class);
        binding.toString();
        
        String vnicType = binding.getVnicType();
        Assert.assertNotNull(vnicType);
        binding.setVnicType(vnicType);
        
        Map<String,Object> vifDetails = binding.getVifDetails();
        Assert.assertNotNull(vifDetails);
        Assert.assertEquals(2, vifDetails.size());
        binding.setVifDetails(vifDetails);
        
        Map<String,Object> profile = binding.getProfile();
        Assert.assertNotNull(profile);
        Assert.assertEquals(2, profile.size());
        binding.setProfile(profile);
        
        String hostId = binding.getHostId();
        Assert.assertNotNull(hostId);
        binding.setHostId(hostId);
        
        String vifType = binding.getVifType();
        Assert.assertNotNull(vifType);
        binding.setVifType(vifType);
    }
}
