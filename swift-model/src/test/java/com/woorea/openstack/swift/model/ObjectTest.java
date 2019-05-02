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

package com.woorea.openstack.swift.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ObjectTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"subdir\" : \"subdir\"," + EOL + "  \"name\" : \"name\","
            + EOL + "  \"hash\" : \"hash\"," + EOL + "  \"bytes\" : 82," + EOL + "  \"content_type\" : \"contenttype\","
            + EOL + "  \"last_modified\" : 1488715200000" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Object.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Object object = objectMapper.readValue(JSON_FULL, Object.class);
        String json = objectMapper.writeValueAsString(object);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        com.woorea.openstack.swift.model.Object object =
                objectMapper.readValue(JSON_FULL, com.woorea.openstack.swift.model.Object.class);
        object.toString();

        String subdir = object.getSubdir();
        Assert.assertNotNull(subdir);
        object.setSubdir(subdir);

        Calendar lastModified = object.getLastModified();
        Assert.assertNotNull(lastModified);
        object.setLastModified(lastModified);

        int bytes = object.getBytes();
        Assert.assertNotNull(bytes);
        object.setBytes(bytes);

        String name = object.getName();
        Assert.assertNotNull(name);
        object.setName(name);

        String hash = object.getHash();
        Assert.assertNotNull(hash);
        object.setHash(hash);

        String contentType = object.getContentType();
        Assert.assertNotNull(contentType);
        object.setContentType(contentType);
    }
}
