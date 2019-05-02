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
import com.woorea.openstack.nova.model.ServerForCreate.SecurityGroup;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ServerForCreateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"server\" : {" + EOL + "    \"name\" : \"name\"," + EOL
            + "    \"adminPass\" : \"adminpass\"," + EOL + "    \"imageRef\" : \"imageref\"," + EOL
            + "    \"flavorRef\" : \"flavorref\"," + EOL + "    \"accessIPv4\" : \"accessipv4\"," + EOL
            + "    \"accessIPv6\" : \"accessipv6\"," + EOL + "    \"min\" : 42," + EOL + "    \"max\" : 44," + EOL
            + "    \"diskConfig\" : \"diskconfig\"," + EOL + "    \"personality\" : [ {" + EOL
            + "      \"path\" : \"path\"," + EOL + "      \"contents\" : \"contents\"" + EOL + "    }, {" + EOL
            + "      \"path\" : \"path\"," + EOL + "      \"contents\" : \"contents\"" + EOL + "    } ]," + EOL
            + "    \"metadata\" : {" + EOL + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
            + "      \"metadata-k2\" : \"metadata-v2\"" + EOL + "    }," + EOL + "    \"networks\" : [ {" + EOL
            + "      \"uuid\" : \"id\"," + EOL + "      \"fixed_ip\" : \"fixedip\"" + EOL + "    }, {" + EOL
            + "      \"uuid\" : \"id\"," + EOL + "      \"fixed_ip\" : \"fixedip\"" + EOL + "    } ]," + EOL
            + "    \"key_name\" : \"keyname\"," + EOL + "    \"security_groups\" : [ {" + EOL
            + "      \"name\" : \"name\"" + EOL + "    }, {" + EOL + "      \"name\" : \"name\"" + EOL + "    } ],"
            + EOL + "    \"user_data\" : \"userdata\"," + EOL + "    \"availability_zone\" : \"availabilityzone\","
            + EOL + "    \"config_drive\" : true" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + ServerForCreate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        ServerForCreate serverforcreate = objectMapper.readValue(JSON_FULL, ServerForCreate.class);
        String json = objectMapper.writeValueAsString(serverforcreate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        ServerForCreate serverforcreate = objectMapper.readValue(JSON_FULL, ServerForCreate.class);
        serverforcreate.toString();

        Map<String, String> metadata = serverforcreate.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        serverforcreate.setMetadata(metadata);

        Integer max = serverforcreate.getMax();
        Assert.assertNotNull(max);
        serverforcreate.setMax(max);

        List<NetworkForCreate> networks = serverforcreate.getNetworks();
        Assert.assertNotNull(networks);
        Assert.assertEquals(2, networks.size());
        serverforcreate.setNetworks(networks);

        String userData = serverforcreate.getUserData();
        Assert.assertNotNull(userData);
        serverforcreate.setUserData(userData);

        Integer min = serverforcreate.getMin();
        Assert.assertNotNull(min);
        serverforcreate.setMin(min);

        List<PersonalityFile> personality = serverforcreate.getPersonality();
        Assert.assertNotNull(personality);
        Assert.assertEquals(2, personality.size());
        serverforcreate.setPersonality(personality);

        String name = serverforcreate.getName();
        Assert.assertNotNull(name);
        serverforcreate.setName(name);

        String flavorRef = serverforcreate.getFlavorRef();
        Assert.assertNotNull(flavorRef);
        serverforcreate.setFlavorRef(flavorRef);

        String keyName = serverforcreate.getKeyName();
        Assert.assertNotNull(keyName);
        serverforcreate.setKeyName(keyName);

        String adminPass = serverforcreate.getAdminPass();
        Assert.assertNotNull(adminPass);
        serverforcreate.setAdminPass(adminPass);

        String imageRef = serverforcreate.getImageRef();
        Assert.assertNotNull(imageRef);
        serverforcreate.setImageRef(imageRef);

        String accessIPv6 = serverforcreate.getAccessIPv6();
        Assert.assertNotNull(accessIPv6);
        serverforcreate.setAccessIPv6(accessIPv6);

        String diskConfig = serverforcreate.getDiskConfig();
        Assert.assertNotNull(diskConfig);
        serverforcreate.setDiskConfig(diskConfig);

        List<SecurityGroup> securityGroups = serverforcreate.getSecurityGroups();
        Assert.assertNotNull(securityGroups);
        Assert.assertEquals(2, securityGroups.size());

        String availabilityZone = serverforcreate.getAvailabilityZone();
        Assert.assertNotNull(availabilityZone);
        serverforcreate.setAvailabilityZone(availabilityZone);

        String accessIPv4 = serverforcreate.getAccessIPv4();
        Assert.assertNotNull(accessIPv4);
        serverforcreate.setAccessIPv4(accessIPv4);
    }
}
