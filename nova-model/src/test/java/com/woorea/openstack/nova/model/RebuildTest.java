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

import com.woorea.openstack.nova.model.PersonalityFile;
import com.woorea.openstack.nova.model.ServerAction.Rebuild;
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

public class RebuildTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"rebuild\" : {" + EOL
        + "    \"imageRef\" : \"imageref\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"adminPass\" : \"adminpass\"," + EOL
        + "    \"accessIPv4\" : \"accessipv4\"," + EOL
        + "    \"accessIPv6\" : \"accessipv6\"," + EOL
        + "    \"metadata\" : {" + EOL
        + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "    }," + EOL
        + "    \"personality\" : [ {" + EOL
        + "      \"path\" : \"path\"," + EOL
        + "      \"contents\" : \"contents\"" + EOL
        + "    }, {" + EOL
        + "      \"path\" : \"path\"," + EOL
        + "      \"contents\" : \"contents\"" + EOL
        + "    } ]," + EOL
        + "    \"OS-DCF:diskConfig\" : \"diskconfig\"" + EOL
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
        System.out.println("CLASS: " + Rebuild.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Rebuild rebuild = objectMapper.readValue(JSON_FULL, Rebuild.class);
        String json = objectMapper.writeValueAsString(rebuild);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Rebuild rebuild = objectMapper.readValue(JSON_FULL, Rebuild.class);
        rebuild.toString();
        
        Map<String,String> metadata = rebuild.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        rebuild.setMetadata(metadata);
        
        List<PersonalityFile> personality = rebuild.getPersonality();
        Assert.assertNotNull(personality);
        Assert.assertEquals(2, personality.size());
        rebuild.setPersonality(personality);
        
        String name = rebuild.getName();
        Assert.assertNotNull(name);
        rebuild.setName(name);
        
        String adminPass = rebuild.getAdminPass();
        Assert.assertNotNull(adminPass);
        rebuild.setAdminPass(adminPass);
        
        String imageRef = rebuild.getImageRef();
        Assert.assertNotNull(imageRef);
        rebuild.setImageRef(imageRef);
        
        String accessIPv6 = rebuild.getAccessIPv6();
        Assert.assertNotNull(accessIPv6);
        rebuild.setAccessIPv6(accessIPv6);
        
        String diskConfig = rebuild.getDiskConfig();
        Assert.assertNotNull(diskConfig);
        rebuild.setDiskConfig(diskConfig);
        
        String accessIPv4 = rebuild.getAccessIPv4();
        Assert.assertNotNull(accessIPv4);
        rebuild.setAccessIPv4(accessIPv4);
    }
}
