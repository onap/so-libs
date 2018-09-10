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

package com.woorea.openstack.ceilometer.v2.model;

import com.woorea.openstack.ceilometer.v2.model.Sample;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SampleTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"source\" : \"source\"," + EOL
        + "  \"timestamp\" : \"timestamp\"," + EOL
        + "  \"counter_type\" : \"countertype\"," + EOL
        + "  \"counter_name\" : \"countername\"," + EOL
        + "  \"counter_unit\" : \"counterunit\"," + EOL
        + "  \"counter_volume\" : \"countervolume\"," + EOL
        + "  \"project_id\" : \"project\"," + EOL
        + "  \"user_id\" : \"user\"," + EOL
        + "  \"resource_id\" : \"resource\"," + EOL
        + "  \"message_id\" : \"message\"," + EOL
        + "  \"resource_metadata\" : {" + EOL
        + "    \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "    \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Sample.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Sample sample = objectMapper.readValue(JSON_FULL, Sample.class);
        String json = objectMapper.writeValueAsString(sample);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Sample sample = objectMapper.readValue(JSON_FULL, Sample.class);
        sample.toString();
        
        String counterName = sample.getCounterName();
        Assert.assertNotNull(counterName);
        
        Map<String,Object> metadata = sample.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        
        String resource = sample.getResource();
        Assert.assertNotNull(resource);
        
        String counterVolume = sample.getCounterVolume();
        Assert.assertNotNull(counterVolume);
        
        String project = sample.getProject();
        Assert.assertNotNull(project);
        
        String counterUnit = sample.getCounterUnit();
        Assert.assertNotNull(counterUnit);
        
        String source = sample.getSource();
        Assert.assertNotNull(source);
        
        String counterType = sample.getCounterType();
        Assert.assertNotNull(counterType);
        
        String message = sample.getMessage();
        Assert.assertNotNull(message);
        
        String user = sample.getUser();
        Assert.assertNotNull(user);
        
        String timestamp = sample.getTimestamp();
        Assert.assertNotNull(timestamp);
    }
}
