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

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ExtensionTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"extension\" : {" + EOL
        + "    \"alias\" : \"alias\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"namespace\" : \"namespace\"," + EOL
        + "    \"updated\" : 1486468800000," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]" + EOL
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
        System.out.println("CLASS: " + Extension.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Extension extension = objectMapper.readValue(JSON_FULL, Extension.class);
        String json = objectMapper.writeValueAsString(extension);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Extension extension = objectMapper.readValue(JSON_FULL, Extension.class);
        extension.toString();
        
        String name = extension.getName();
        Assert.assertNotNull(name);
        
        String namespace = extension.getNamespace();
        Assert.assertNotNull(namespace);
        
        String alias = extension.getAlias();
        Assert.assertNotNull(alias);
        
        String description = extension.getDescription();
        Assert.assertNotNull(description);
        
        List<Link> links = extension.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        
        Calendar updated = extension.getUpdated();
        Assert.assertNotNull(updated);
    }
}
