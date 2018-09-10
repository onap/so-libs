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

import com.woorea.openstack.nova.model.SimpleTenantUsage.ServerUsage;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ServerUsageTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"uptime\" : 78," + EOL
        + "  \"state\" : \"state\"," + EOL
        + "  \"hours\" : 64.0," + EOL
        + "  \"vcpus\" : 79," + EOL
        + "  \"flavor\" : \"flavor\"," + EOL
        + "  \"name\" : \"name\"," + EOL
        + "  \"instance_id\" : \"instanceid\"," + EOL
        + "  \"started_at\" : \"startedat\"," + EOL
        + "  \"ended_at\" : \"endedat\"," + EOL
        + "  \"memory_mb\" : 90," + EOL
        + "  \"tenant_id\" : \"tenantid\"," + EOL
        + "  \"local_gb\" : 11" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + ServerUsage.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        ServerUsage serverusage = objectMapper.readValue(JSON_FULL, ServerUsage.class);
        String json = objectMapper.writeValueAsString(serverusage);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        ServerUsage serverusage = objectMapper.readValue(JSON_FULL, ServerUsage.class);
        serverusage.toString();
        
        String flavor = serverusage.getFlavor();
        Assert.assertNotNull(flavor);
        
        Integer memoryMb = serverusage.getMemoryMb();
        Assert.assertNotNull(memoryMb);
        
        Double hours = serverusage.getHours();
        Assert.assertNotNull(hours);
        
        String instanceId = serverusage.getInstanceId();
        Assert.assertNotNull(instanceId);
        
        Integer localDiskSize = serverusage.getLocalDiskSize();
        Assert.assertNotNull(localDiskSize);
        
        String endedAt = serverusage.getEndedAt();
        Assert.assertNotNull(endedAt);
        
        String name = serverusage.getName();
        Assert.assertNotNull(name);
        
        String tenantId = serverusage.getTenantId();
        Assert.assertNotNull(tenantId);
        
        String startedAt = serverusage.getStartedAt();
        Assert.assertNotNull(startedAt);
        
        String state = serverusage.getState();
        Assert.assertNotNull(state);
        
        Integer vcpus = serverusage.getVcpus();
        Assert.assertNotNull(vcpus);
        
        Integer uptime = serverusage.getUptime();
        Assert.assertNotNull(uptime);
    }
}
