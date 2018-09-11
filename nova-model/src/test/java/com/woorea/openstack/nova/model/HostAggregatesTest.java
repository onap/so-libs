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

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class HostAggregatesTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"aggregates\" : [ {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"deleted\" : false," + EOL
        + "    \"hosts\" : [ \"hosts-v1\", \"hosts-v2\" ]," + EOL
        + "    \"metadata\" : {" + EOL
        + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "    }," + EOL
        + "    \"availability_zone\" : \"availabilityzone\"," + EOL
        + "    \"created_at\" : \"createdat\"," + EOL
        + "    \"updated_at\" : \"updatedat\"," + EOL
        + "    \"deleted_at\" : \"deletedat\"" + EOL
        + "  }, {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"deleted\" : false," + EOL
        + "    \"hosts\" : [ \"hosts-v1\", \"hosts-v2\" ]," + EOL
        + "    \"metadata\" : {" + EOL
        + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "    }," + EOL
        + "    \"availability_zone\" : \"availabilityzone\"," + EOL
        + "    \"created_at\" : \"createdat\"," + EOL
        + "    \"updated_at\" : \"updatedat\"," + EOL
        + "    \"deleted_at\" : \"deletedat\"" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + HostAggregates.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        HostAggregates hostaggregates = objectMapper.readValue(JSON_FULL, HostAggregates.class);
        String json = objectMapper.writeValueAsString(hostaggregates);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        HostAggregates hostaggregates = objectMapper.readValue(JSON_FULL, HostAggregates.class);
        hostaggregates.toString();
        
        List<HostAggregate> list = hostaggregates.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        
        int cnt = 0;
        for (@SuppressWarnings("unused") HostAggregate x : hostaggregates) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
