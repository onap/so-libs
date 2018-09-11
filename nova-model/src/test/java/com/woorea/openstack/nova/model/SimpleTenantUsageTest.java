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
import com.woorea.openstack.nova.model.SimpleTenantUsage.ServerUsage;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SimpleTenantUsageTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"tenant_usage\" : {" + EOL
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
        System.out.println("CLASS: " + SimpleTenantUsage.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        SimpleTenantUsage simpletenantusage = objectMapper.readValue(JSON_FULL, SimpleTenantUsage.class);
        String json = objectMapper.writeValueAsString(simpletenantusage);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        SimpleTenantUsage simpletenantusage = objectMapper.readValue(JSON_FULL, SimpleTenantUsage.class);
        simpletenantusage.toString();
        
        BigDecimal totalMemoryMbUsage = simpletenantusage.getTotalMemoryMbUsage();
        Assert.assertNotNull(totalMemoryMbUsage);
        simpletenantusage.setTotalMemoryMbUsage(totalMemoryMbUsage);
        
        String stop = simpletenantusage.getStop();
        Assert.assertNotNull(stop);
        simpletenantusage.setStop(stop);
        
        BigDecimal totalVcpusUsage = simpletenantusage.getTotalVcpusUsage();
        Assert.assertNotNull(totalVcpusUsage);
        simpletenantusage.setTotalVcpusUsage(totalVcpusUsage);
        
        String tenantId = simpletenantusage.getTenantId();
        Assert.assertNotNull(tenantId);
        simpletenantusage.setTenantId(tenantId);
        
        String start = simpletenantusage.getStart();
        Assert.assertNotNull(start);
        simpletenantusage.setStart(start);
        
        List<ServerUsage> serverUsages = simpletenantusage.getServerUsages();
        Assert.assertNotNull(serverUsages);
        Assert.assertEquals(2, serverUsages.size());
        simpletenantusage.setServerUsages(serverUsages);
        
        BigDecimal totalLocalGbUsage = simpletenantusage.getTotalLocalGbUsage();
        Assert.assertNotNull(totalLocalGbUsage);
        simpletenantusage.setTotalLocalGbUsage(totalLocalGbUsage);
        
        String totalHours = simpletenantusage.getTotalHours();
        Assert.assertNotNull(totalHours);
        simpletenantusage.setTotalHours(totalHours);
    }
}
