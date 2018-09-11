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

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class PolicyTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"policy\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"projectId\" : \"projectid\"," + EOL
        + "    \"type\" : \"type\"," + EOL
        + "    \"userId\" : \"userid\"," + EOL
        + "    \"blob\" : {" + EOL
        + "      \"blob-k1\" : \"blob-v1\"," + EOL
        + "      \"blob-k2\" : \"blob-v2\"" + EOL
        + "    }" + EOL
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
        System.out.println("CLASS: " + Policy.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Policy policy = objectMapper.readValue(JSON_FULL, Policy.class);
        String json = objectMapper.writeValueAsString(policy);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Policy policy = objectMapper.readValue(JSON_FULL, Policy.class);
        policy.toString();
        
        Map<String,String> blob = policy.getBlob();
        Assert.assertNotNull(blob);
        Assert.assertEquals(2, blob.size());
        policy.setBlob(blob);
        
        String id = policy.getId();
        Assert.assertNotNull(id);
        policy.setId(id);
        
        String type = policy.getType();
        Assert.assertNotNull(type);
        policy.setType(type);
        
        String userId = policy.getUserId();
        Assert.assertNotNull(userId);
        policy.setUserId(userId);
        
        String projectId = policy.getProjectId();
        Assert.assertNotNull(projectId);
        policy.setProjectId(projectId);
    }
}
