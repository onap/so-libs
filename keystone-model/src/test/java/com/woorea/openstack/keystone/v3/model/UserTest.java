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

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class UserTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"user\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"password\" : \"password\"," + EOL
        + "    \"email\" : \"email\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"enabled\" : false," + EOL
        + "    \"domain_id\" : \"domainid\"," + EOL
        + "    \"default_project_id\" : \"defaultprojectid\"" + EOL
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
        System.out.println("CLASS: " + User.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        User user = objectMapper.readValue(JSON_FULL, User.class);
        String json = objectMapper.writeValueAsString(user);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        User user = objectMapper.readValue(JSON_FULL, User.class);
        user.toString();
        
        String password = user.getPassword();
        Assert.assertNotNull(password);
        user.setPassword(password);
        
        String name = user.getName();
        Assert.assertNotNull(name);
        user.setName(name);
        
        String description = user.getDescription();
        Assert.assertNotNull(description);
        user.setDescription(description);
        
        String id = user.getId();
        Assert.assertNotNull(id);
        user.setId(id);
        
        String email = user.getEmail();
        Assert.assertNotNull(email);
        user.setEmail(email);
        
        String domainId = user.getDomainId();
        Assert.assertNotNull(domainId);
        user.setDomainId(domainId);
        
        Boolean enabled = user.getEnabled();
        Assert.assertNotNull(enabled);
        user.setEnabled(enabled);
        
        String defaultProjectId = user.getDefaultProjectId();
        Assert.assertNotNull(defaultProjectId);
        user.setDefaultProjectId(defaultProjectId);
    }
}
