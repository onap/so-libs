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
import com.woorea.openstack.keystone.v3.model.Authentication.Identity.Password;
import com.woorea.openstack.keystone.v3.model.Authentication.Identity.Token;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class IdentityTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL =
            "{" + EOL + "  \"methods\" : [ \"methods-v1\", \"methods-v2\" ]," + EOL + "  \"password\" : {" + EOL
                    + "    \"user\" : {" + EOL + "      \"domain\" : {" + EOL + "        \"id\" : \"id\"," + EOL
                    + "        \"name\" : \"name\"" + EOL + "      }," + EOL + "      \"id\" : \"id\"," + EOL
                    + "      \"name\" : \"name\"," + EOL + "      \"password\" : \"password\"" + EOL + "    }" + EOL
                    + "  }," + EOL + "  \"token\" : {" + EOL + "    \"id\" : \"id\"" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Identity.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Identity identity = objectMapper.readValue(JSON_FULL, Identity.class);
        String json = objectMapper.writeValueAsString(identity);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Identity identity = objectMapper.readValue(JSON_FULL, Identity.class);
        identity.toString();

        Password password = identity.getPassword();
        Assert.assertNotNull(password);
        identity.setPassword(password);

        List<String> methods = identity.getMethods();
        Assert.assertNotNull(methods);
        Assert.assertEquals(2, methods.size());
        identity.setMethods(methods);

        Token token = identity.getToken();
        Assert.assertNotNull(token);
        identity.setToken(token);
    }
}
