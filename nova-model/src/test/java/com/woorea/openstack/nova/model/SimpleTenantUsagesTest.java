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

import com.woorea.openstack.nova.model.SimpleTenantUsage;
import com.woorea.openstack.nova.model.SimpleTenantUsages;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SimpleTenantUsagesTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"tenant_usages\" : [ {" + EOL
        + "    \"start\" : \"start\"," + EOL
        + "    \"stop\" : \"stop\"," + EOL
        + "    \"total_memory_mb_usage\" : 14," + EOL
        + "    \"total_vcpus_usage\" : 3," + EOL
        + "    \"total_local_gb_usage\" : 66," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"total_hours\" : \"totalhours\"," + EOL
        + "    \"server_usages\" : [ {" + EOL
        + "      \"uptime\" : 78," + EOL
        + "      \"state\" : \"state\"," + EOL
        + "      \"hours\" : 64.0," + EOL
        + "      \"vcpus\" : 79," + EOL
        + "      \"flavor\" : \"flavor\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"instance_id\" : \"instanceid\"," + EOL
        + "      \"started_at\" : \"startedat\"," + EOL
        + "      \"ended_at\" : \"endedat\"," + EOL
        + "      \"memory_mb\" : 90," + EOL
        + "      \"tenant_id\" : \"tenantid\"," + EOL
        + "      \"local_gb\" : 11" + EOL
        + "    }, {" + EOL
        + "      \"uptime\" : 78," + EOL
        + "      \"state\" : \"state\"," + EOL
        + "      \"hours\" : 64.0," + EOL
        + "      \"vcpus\" : 79," + EOL
        + "      \"flavor\" : \"flavor\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"instance_id\" : \"instanceid\"," + EOL
        + "      \"started_at\" : \"startedat\"," + EOL
        + "      \"ended_at\" : \"endedat\"," + EOL
        + "      \"memory_mb\" : 90," + EOL
        + "      \"tenant_id\" : \"tenantid\"," + EOL
        + "      \"local_gb\" : 11" + EOL
        + "    } ]" + EOL
        + "  }, {" + EOL
        + "    \"start\" : \"start\"," + EOL
        + "    \"stop\" : \"stop\"," + EOL
        + "    \"total_memory_mb_usage\" : 14," + EOL
        + "    \"total_vcpus_usage\" : 3," + EOL
        + "    \"total_local_gb_usage\" : 66," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"total_hours\" : \"totalhours\"," + EOL
        + "    \"server_usages\" : [ {" + EOL
        + "      \"uptime\" : 78," + EOL
        + "      \"state\" : \"state\"," + EOL
        + "      \"hours\" : 64.0," + EOL
        + "      \"vcpus\" : 79," + EOL
        + "      \"flavor\" : \"flavor\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"instance_id\" : \"instanceid\"," + EOL
        + "      \"started_at\" : \"startedat\"," + EOL
        + "      \"ended_at\" : \"endedat\"," + EOL
        + "      \"memory_mb\" : 90," + EOL
        + "      \"tenant_id\" : \"tenantid\"," + EOL
        + "      \"local_gb\" : 11" + EOL
        + "    }, {" + EOL
        + "      \"uptime\" : 78," + EOL
        + "      \"state\" : \"state\"," + EOL
        + "      \"hours\" : 64.0," + EOL
        + "      \"vcpus\" : 79," + EOL
        + "      \"flavor\" : \"flavor\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"instance_id\" : \"instanceid\"," + EOL
        + "      \"started_at\" : \"startedat\"," + EOL
        + "      \"ended_at\" : \"endedat\"," + EOL
        + "      \"memory_mb\" : 90," + EOL
        + "      \"tenant_id\" : \"tenantid\"," + EOL
        + "      \"local_gb\" : 11" + EOL
        + "    } ]" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + SimpleTenantUsages.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        SimpleTenantUsages simpletenantusages = objectMapper.readValue(JSON_FULL, SimpleTenantUsages.class);
        String json = objectMapper.writeValueAsString(simpletenantusages);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        SimpleTenantUsages simpletenantusages = objectMapper.readValue(JSON_FULL, SimpleTenantUsages.class);
        simpletenantusages.toString();
        
        List<SimpleTenantUsage> list = simpletenantusages.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        
        int cnt = 0;
        for (@SuppressWarnings("unused") SimpleTenantUsage x : simpletenantusages) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
