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
import com.woorea.openstack.keystone.v3.model.Token.Domain;
import com.woorea.openstack.keystone.v3.model.Token.Project;
import com.woorea.openstack.keystone.v3.model.Token.Role;
import com.woorea.openstack.keystone.v3.model.Token.Service;
import com.woorea.openstack.keystone.v3.model.Token.User;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class TokenTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"token\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"methods\" : [ \"methods-v1\", \"methods-v2\" ]," + EOL + "    \"domain\" : {" + EOL
            + "      \"id\" : \"id\"," + EOL + "      \"name\" : \"name\"" + EOL + "    }," + EOL
            + "    \"project\" : {" + EOL + "      \"domain\" : {" + EOL + "        \"id\" : \"id\"," + EOL
            + "        \"name\" : \"name\"" + EOL + "      }," + EOL + "      \"id\" : \"id\"," + EOL
            + "      \"name\" : \"name\"" + EOL + "    }," + EOL + "    \"user\" : {" + EOL + "      \"id\" : \"id\","
            + EOL + "      \"name\" : \"name\"" + EOL + "    }," + EOL + "    \"roles\" : [ { }, { } ]," + EOL
            + "    \"catalog\" : [ {" + EOL + "      \"id\" : \"id\"," + EOL + "      \"type\" : \"type\"," + EOL
            + "      \"endpoints\" : [ {" + EOL + "        \"id\" : \"id\"," + EOL + "        \"url\" : \"url\"," + EOL
            + "        \"region\" : \"region\"," + EOL + "        \"enabled\" : false," + EOL
            + "        \"interface\" : \"interface\"," + EOL + "        \"legacy_endpoint_id\" : \"legacyendpointid\""
            + EOL + "      }, {" + EOL + "        \"id\" : \"id\"," + EOL + "        \"url\" : \"url\"," + EOL
            + "        \"region\" : \"region\"," + EOL + "        \"enabled\" : false," + EOL
            + "        \"interface\" : \"interface\"," + EOL + "        \"legacy_endpoint_id\" : \"legacyendpointid\""
            + EOL + "      } ]" + EOL + "    }, {" + EOL + "      \"id\" : \"id\"," + EOL + "      \"type\" : \"type\","
            + EOL + "      \"endpoints\" : [ {" + EOL + "        \"id\" : \"id\"," + EOL + "        \"url\" : \"url\","
            + EOL + "        \"region\" : \"region\"," + EOL + "        \"enabled\" : false," + EOL
            + "        \"interface\" : \"interface\"," + EOL + "        \"legacy_endpoint_id\" : \"legacyendpointid\""
            + EOL + "      }, {" + EOL + "        \"id\" : \"id\"," + EOL + "        \"url\" : \"url\"," + EOL
            + "        \"region\" : \"region\"," + EOL + "        \"enabled\" : false," + EOL
            + "        \"interface\" : \"interface\"," + EOL + "        \"legacy_endpoint_id\" : \"legacyendpointid\""
            + EOL + "      } ]" + EOL + "    } ]," + EOL + "    \"expires_at\" : 1489752000000," + EOL
            + "    \"issued_at\" : 1488456000000" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Token.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Token token = objectMapper.readValue(JSON_FULL, Token.class);
        String json = objectMapper.writeValueAsString(token);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Token token = objectMapper.readValue(JSON_FULL, Token.class);
        token.toString();

        List<String> methods = token.getMethods();
        Assert.assertNotNull(methods);
        Assert.assertEquals(2, methods.size());
        token.setMethods(methods);

        List<Service> catalog = token.getCatalog();
        Assert.assertNotNull(catalog);
        Assert.assertEquals(2, catalog.size());
        token.setCatalog(catalog);

        Domain domain = token.getDomain();
        Assert.assertNotNull(domain);
        token.setDomain(domain);

        List<Role> roles = token.getRoles();
        Assert.assertNotNull(roles);
        Assert.assertEquals(2, roles.size());
        token.setRoles(roles);

        Project project = token.getProject();
        Assert.assertNotNull(project);
        token.setProject(project);

        Calendar issuedAt = token.getIssuedAt();
        Assert.assertNotNull(issuedAt);
        token.setIssuedAt(issuedAt);

        String id = token.getId();
        Assert.assertNotNull(id);
        token.setId(id);

        User user = token.getUser();
        Assert.assertNotNull(user);
        token.setUser(user);

        Calendar expiresAt = token.getExpiresAt();
        Assert.assertNotNull(expiresAt);
        token.setExpiresAt(expiresAt);
    }
}
