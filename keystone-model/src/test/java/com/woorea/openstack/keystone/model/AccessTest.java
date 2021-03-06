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

package com.woorea.openstack.keystone.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.woorea.openstack.keystone.model.Access.Service;
import com.woorea.openstack.keystone.model.Access.User;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class AccessTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"access\" : {" + EOL + "    \"token\" : {" + EOL
            + "      \"id\" : \"id\"," + EOL + "      \"issued_at\" : 1488024000000," + EOL
            + "      \"expires\" : 1488628800000," + EOL + "      \"tenant\" : {" + EOL + "        \"id\" : \"id\","
            + EOL + "        \"name\" : \"name\"," + EOL + "        \"description\" : \"description\"," + EOL
            + "        \"enabled\" : false" + EOL + "      }" + EOL + "    }," + EOL + "    \"serviceCatalog\" : [ {"
            + EOL + "      \"type\" : \"type\"," + EOL + "      \"name\" : \"name\"," + EOL
            + "      \"endpoints\" : [ {" + EOL + "        \"region\" : \"region\"," + EOL
            + "        \"publicURL\" : \"publicurl\"," + EOL + "        \"internalURL\" : \"internalurl\"," + EOL
            + "        \"adminURL\" : \"adminurl\"" + EOL + "      }, {" + EOL + "        \"region\" : \"region\","
            + EOL + "        \"publicURL\" : \"publicurl\"," + EOL + "        \"internalURL\" : \"internalurl\"," + EOL
            + "        \"adminURL\" : \"adminurl\"" + EOL + "      } ]," + EOL + "      \"endpoints_links\" : [ {" + EOL
            + "        \"rel\" : \"rel\"," + EOL + "        \"href\" : \"href\"," + EOL + "        \"type\" : \"type\""
            + EOL + "      }, {" + EOL + "        \"rel\" : \"rel\"," + EOL + "        \"href\" : \"href\"," + EOL
            + "        \"type\" : \"type\"" + EOL + "      } ]" + EOL + "    }, {" + EOL + "      \"type\" : \"type\","
            + EOL + "      \"name\" : \"name\"," + EOL + "      \"endpoints\" : [ {" + EOL
            + "        \"region\" : \"region\"," + EOL + "        \"publicURL\" : \"publicurl\"," + EOL
            + "        \"internalURL\" : \"internalurl\"," + EOL + "        \"adminURL\" : \"adminurl\"" + EOL
            + "      }, {" + EOL + "        \"region\" : \"region\"," + EOL + "        \"publicURL\" : \"publicurl\","
            + EOL + "        \"internalURL\" : \"internalurl\"," + EOL + "        \"adminURL\" : \"adminurl\"" + EOL
            + "      } ]," + EOL + "      \"endpoints_links\" : [ {" + EOL + "        \"rel\" : \"rel\"," + EOL
            + "        \"href\" : \"href\"," + EOL + "        \"type\" : \"type\"" + EOL + "      }, {" + EOL
            + "        \"rel\" : \"rel\"," + EOL + "        \"href\" : \"href\"," + EOL + "        \"type\" : \"type\""
            + EOL + "      } ]" + EOL + "    } ]," + EOL + "    \"user\" : {" + EOL + "      \"id\" : \"id\"," + EOL
            + "      \"name\" : \"name\"," + EOL + "      \"username\" : \"username\"," + EOL + "      \"roles\" : [ {"
            + EOL + "        \"id\" : \"id\"," + EOL + "        \"name\" : \"name\"" + EOL + "      }, {" + EOL
            + "        \"id\" : \"id\"," + EOL + "        \"name\" : \"name\"" + EOL + "      } ]," + EOL
            + "      \"roles_links\" : [ {" + EOL + "        \"rel\" : \"rel\"," + EOL + "        \"href\" : \"href\","
            + EOL + "        \"type\" : \"type\"" + EOL + "      }, {" + EOL + "        \"rel\" : \"rel\"," + EOL
            + "        \"href\" : \"href\"," + EOL + "        \"type\" : \"type\"" + EOL + "      } ]" + EOL + "    },"
            + EOL + "    \"metadata\" : {" + EOL + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
            + "      \"metadata-k2\" : \"metadata-v2\"" + EOL + "    }" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Access.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Access access = objectMapper.readValue(JSON_FULL, Access.class);
        String json = objectMapper.writeValueAsString(access);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Access access = objectMapper.readValue(JSON_FULL, Access.class);
        access.toString();

        List<Service> serviceCatalog = access.getServiceCatalog();
        Assert.assertNotNull(serviceCatalog);
        Assert.assertEquals(2, serviceCatalog.size());

        Map<String, Object> metadata = access.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());

        User user = access.getUser();
        Assert.assertNotNull(user);

        Token token = access.getToken();
        Assert.assertNotNull(token);
    }
}
