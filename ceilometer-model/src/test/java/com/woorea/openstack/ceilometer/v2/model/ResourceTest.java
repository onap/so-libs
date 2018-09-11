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

package com.woorea.openstack.ceilometer.v2.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ResourceTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"timestamp\" : \"timestamp\"," + EOL
        + "  \"metadata\" : {" + EOL
        + "    \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "    \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "  }," + EOL
        + "  \"resource_id\" : \"resource\"," + EOL
        + "  \"project_id\" : \"project\"," + EOL
        + "  \"user_id\" : \"user\"" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Resource.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Resource resource = objectMapper.readValue(JSON_FULL, Resource.class);
        String json = objectMapper.writeValueAsString(resource);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Resource resource = objectMapper.readValue(JSON_FULL, Resource.class);
        resource.toString();
        
        Map<String,Object> metadata = resource.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        
        String resourceProperty = resource.getResource();
        Assert.assertNotNull(resourceProperty);
        
        String project = resource.getProject();
        Assert.assertNotNull(project);
        
        String user = resource.getUser();
        Assert.assertNotNull(user);
        
        String timestamp = resource.getTimestamp();
        Assert.assertNotNull(timestamp);
    }
}
