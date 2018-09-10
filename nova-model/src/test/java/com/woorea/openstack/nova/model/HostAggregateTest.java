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

import com.woorea.openstack.nova.model.HostAggregate;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class HostAggregateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"aggregate\" : {" + EOL
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
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(SerializationConfig.Feature.WRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + HostAggregate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        HostAggregate hostaggregate = objectMapper.readValue(JSON_FULL, HostAggregate.class);
        String json = objectMapper.writeValueAsString(hostaggregate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        HostAggregate hostaggregate = objectMapper.readValue(JSON_FULL, HostAggregate.class);
        hostaggregate.toString();
        
        String createdAt = hostaggregate.getCreatedAt();
        Assert.assertNotNull(createdAt);
        
        Map<String,String> metadata = hostaggregate.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        
        String deletedAt = hostaggregate.getDeletedAt();
        Assert.assertNotNull(deletedAt);
        
        Boolean deleted = hostaggregate.getDeleted();
        Assert.assertNotNull(deleted);
        
        List<String> hosts = hostaggregate.getHosts();
        Assert.assertNotNull(hosts);
        Assert.assertEquals(2, hosts.size());
        
        String name = hostaggregate.getName();
        Assert.assertNotNull(name);
        
        String id = hostaggregate.getId();
        Assert.assertNotNull(id);
        
        String availabilityZone = hostaggregate.getAvailabilityZone();
        Assert.assertNotNull(availabilityZone);
        
        String updatedAt = hostaggregate.getUpdatedAt();
        Assert.assertNotNull(updatedAt);
    }
}
