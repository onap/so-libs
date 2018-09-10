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

import com.woorea.openstack.nova.model.ServerAction.CreateBackup;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class CreateBackupTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"createBackup\" : {" + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"rotation\" : \"rotation\"," + EOL
        + "    \"metadata\" : {" + EOL
        + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "    }," + EOL
        + "    \"backup_type\" : \"type\"" + EOL
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
        System.out.println("CLASS: " + CreateBackup.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        CreateBackup createbackup = objectMapper.readValue(JSON_FULL, CreateBackup.class);
        String json = objectMapper.writeValueAsString(createbackup);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        CreateBackup createbackup = objectMapper.readValue(JSON_FULL, CreateBackup.class);
        createbackup.toString();
        
        Map<String,String> metadata = createbackup.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        createbackup.setMetadata(metadata);
        
        String rotation = createbackup.getRotation();
        Assert.assertNotNull(rotation);
        createbackup.setRotation(rotation);
        
        String name = createbackup.getName();
        Assert.assertNotNull(name);
        createbackup.setName(name);
        
        String type = createbackup.getType();
        Assert.assertNotNull(type);
        createbackup.setType(type);
    }
}
