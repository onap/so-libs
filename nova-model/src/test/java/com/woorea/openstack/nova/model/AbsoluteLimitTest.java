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
import com.woorea.openstack.nova.model.Limits.AbsoluteLimit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class AbsoluteLimitTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"maxServerMeta\" : 30," + EOL + "  \"serverMetaUsed\" : 37,"
            + EOL + "  \"maxPersonality\" : 54," + EOL + "  \"personalityUsed\" : 61," + EOL
            + "  \"maxImageMeta\" : 82," + EOL + "  \"imageMetaUsed\" : 89," + EOL + "  \"maxPersonalitySize\" : 97,"
            + EOL + "  \"personalitySizeUsed\" : 4," + EOL + "  \"maxTotalCores\" : 32," + EOL
            + "  \"totalCoresUsed\" : 39," + EOL + "  \"maxTotalInstances\" : 60," + EOL
            + "  \"totalInstancesUsed\" : 67," + EOL + "  \"maxTotalRAMSize\" : 55," + EOL + "  \"totalRAMUsed\" : 19,"
            + EOL + "  \"maxSecurityGroupRules\" : 44," + EOL + "  \"securityGroupRulesUsed\" : 51," + EOL
            + "  \"maxTotalKeypairs\" : 64," + EOL + "  \"totalKeyPairsUsed\" : 71," + EOL
            + "  \"maxTotalVolumes\" : 71," + EOL + "  \"totalVolumesUsed\" : 78," + EOL
            + "  \"maxSecurityGroups\" : 4," + EOL + "  \"totalSecurityGroupsUsed\" : 59," + EOL
            + "  \"maxTotalFloatingIps\" : 76," + EOL + "  \"totalFloatingIpsUsed\" : 83," + EOL
            + "  \"maxTotalVolumeGigabytes\" : 15," + EOL + "  \"totalVolumeGigabytesUsed\" : 22" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + AbsoluteLimit.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        AbsoluteLimit absolutelimit = objectMapper.readValue(JSON_FULL, AbsoluteLimit.class);
        String json = objectMapper.writeValueAsString(absolutelimit);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        AbsoluteLimit absolutelimit = objectMapper.readValue(JSON_FULL, AbsoluteLimit.class);
        absolutelimit.toString();

        Integer maxTotalRAMSize = absolutelimit.getMaxTotalRAMSize();
        Assertions.assertNotNull(maxTotalRAMSize);

        Integer maxTotalInstances = absolutelimit.getMaxTotalInstances();
        Assertions.assertNotNull(maxTotalInstances);

        Integer serverMetaUsed = absolutelimit.getServerMetaUsed();
        Assertions.assertNotNull(serverMetaUsed);

        Integer maxTotalKeypairs = absolutelimit.getMaxTotalKeypairs();
        Assertions.assertNotNull(maxTotalKeypairs);

        Integer maxTotalVolumeGigabytes = absolutelimit.getMaxTotalVolumeGigabytes();
        Assertions.assertNotNull(maxTotalVolumeGigabytes);

        Integer totalSecurityGroupsUsed = absolutelimit.getTotalSecurityGroupsUsed();
        Assertions.assertNotNull(totalSecurityGroupsUsed);

        Integer maxTotalVolumes = absolutelimit.getMaxTotalVolumes();
        Assertions.assertNotNull(maxTotalVolumes);

        Integer maxImageMeta = absolutelimit.getMaxImageMeta();
        Assertions.assertNotNull(maxImageMeta);

        Integer imageMetaUsed = absolutelimit.getImageMetaUsed();
        Assertions.assertNotNull(imageMetaUsed);

        Integer totalVolumeGigabytesUsed = absolutelimit.getTotalVolumeGigabytesUsed();
        Assertions.assertNotNull(totalVolumeGigabytesUsed);

        Integer maxSecurityGroupRules = absolutelimit.getMaxSecurityGroupRules();
        Assertions.assertNotNull(maxSecurityGroupRules);

        Integer totalCoresUsed = absolutelimit.getTotalCoresUsed();
        Assertions.assertNotNull(totalCoresUsed);

        Integer totalVolumesUsed = absolutelimit.getTotalVolumesUsed();
        Assertions.assertNotNull(totalVolumesUsed);

        Integer maxTotalFloatingIps = absolutelimit.getMaxTotalFloatingIps();
        Assertions.assertNotNull(maxTotalFloatingIps);

        Integer maxPersonality = absolutelimit.getMaxPersonality();
        Assertions.assertNotNull(maxPersonality);

        Integer personalityUsed = absolutelimit.getPersonalityUsed();
        Assertions.assertNotNull(personalityUsed);

        Integer maxSecurityGroups = absolutelimit.getMaxSecurityGroups();
        Assertions.assertNotNull(maxSecurityGroups);

        Integer securityGroupRulesUsed = absolutelimit.getSecurityGroupRulesUsed();
        Assertions.assertNotNull(securityGroupRulesUsed);

        Integer maxTotalCores = absolutelimit.getMaxTotalCores();
        Assertions.assertNotNull(maxTotalCores);

        Integer maxServerMeta = absolutelimit.getMaxServerMeta();
        Assertions.assertNotNull(maxServerMeta);

        Integer maxPersonalitySize = absolutelimit.getMaxPersonalitySize();
        Assertions.assertNotNull(maxPersonalitySize);

        Integer personalitySizeUsed = absolutelimit.getPersonalitySizeUsed();
        Assertions.assertNotNull(personalitySizeUsed);

        Integer totalKeyPairsUsed = absolutelimit.getTotalKeyPairsUsed();
        Assertions.assertNotNull(totalKeyPairsUsed);

        Integer totalFloatingIpsUsed = absolutelimit.getTotalFloatingIpsUsed();
        Assertions.assertNotNull(totalFloatingIpsUsed);

        Integer totalInstancesUsed = absolutelimit.getTotalInstancesUsed();
        Assertions.assertNotNull(totalInstancesUsed);

        Integer totalRAMUsed = absolutelimit.getTotalRAMUsed();
        Assertions.assertNotNull(totalRAMUsed);
    }
}
