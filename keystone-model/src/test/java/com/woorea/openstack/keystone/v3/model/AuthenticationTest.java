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
import com.woorea.openstack.keystone.v3.model.Authentication.Identity;
import com.woorea.openstack.keystone.v3.model.Authentication.Scope;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class AuthenticationTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"auth\" : {" + EOL
        + "    \"identity\" : {" + EOL
        + "      \"methods\" : [ \"methods-v1\", \"methods-v2\" ]," + EOL
        + "      \"password\" : {" + EOL
        + "        \"user\" : {" + EOL
        + "          \"domain\" : {" + EOL
        + "            \"id\" : \"id\"," + EOL
        + "            \"name\" : \"name\"" + EOL
        + "          }," + EOL
        + "          \"id\" : \"id\"," + EOL
        + "          \"name\" : \"name\"," + EOL
        + "          \"password\" : \"password\"" + EOL
        + "        }" + EOL
        + "      }," + EOL
        + "      \"token\" : {" + EOL
        + "        \"id\" : \"id\"" + EOL
        + "      }" + EOL
        + "    }," + EOL
        + "    \"scope\" : {" + EOL
        + "      \"project\" : {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"domain\" : {" + EOL
        + "          \"id\" : \"id\"," + EOL
        + "          \"name\" : \"name\"" + EOL
        + "        }," + EOL
        + "        \"name\" : \"name\"" + EOL
        + "      }" + EOL
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
        System.out.println("CLASS: " + Authentication.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Authentication authentication = objectMapper.readValue(JSON_FULL, Authentication.class);
        String json = objectMapper.writeValueAsString(authentication);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Authentication authentication = objectMapper.readValue(JSON_FULL, Authentication.class);
        authentication.toString();
        
        Identity identity = authentication.getIdentity();
        Assert.assertNotNull(identity);
        authentication.setIdentity(identity);
        
        Scope scope = authentication.getScope();
        Assert.assertNotNull(scope);
        authentication.setScope(scope);
    }
}
