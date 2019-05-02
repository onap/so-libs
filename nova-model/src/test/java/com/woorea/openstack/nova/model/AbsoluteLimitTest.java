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
import org.junit.Assert;
import org.junit.Test;
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
        Assert.assertNotNull(maxTotalRAMSize);

        Integer maxTotalInstances = absolutelimit.getMaxTotalInstances();
        Assert.assertNotNull(maxTotalInstances);

        Integer serverMetaUsed = absolutelimit.getServerMetaUsed();
        Assert.assertNotNull(serverMetaUsed);

        Integer maxTotalKeypairs = absolutelimit.getMaxTotalKeypairs();
        Assert.assertNotNull(maxTotalKeypairs);

        Integer maxTotalVolumeGigabytes = absolutelimit.getMaxTotalVolumeGigabytes();
        Assert.assertNotNull(maxTotalVolumeGigabytes);

        Integer totalSecurityGroupsUsed = absolutelimit.getTotalSecurityGroupsUsed();
        Assert.assertNotNull(totalSecurityGroupsUsed);

        Integer maxTotalVolumes = absolutelimit.getMaxTotalVolumes();
        Assert.assertNotNull(maxTotalVolumes);

        Integer maxImageMeta = absolutelimit.getMaxImageMeta();
        Assert.assertNotNull(maxImageMeta);

        Integer imageMetaUsed = absolutelimit.getImageMetaUsed();
        Assert.assertNotNull(imageMetaUsed);

        Integer totalVolumeGigabytesUsed = absolutelimit.getTotalVolumeGigabytesUsed();
        Assert.assertNotNull(totalVolumeGigabytesUsed);

        Integer maxSecurityGroupRules = absolutelimit.getMaxSecurityGroupRules();
        Assert.assertNotNull(maxSecurityGroupRules);

        Integer totalCoresUsed = absolutelimit.getTotalCoresUsed();
        Assert.assertNotNull(totalCoresUsed);

        Integer totalVolumesUsed = absolutelimit.getTotalVolumesUsed();
        Assert.assertNotNull(totalVolumesUsed);

        Integer maxTotalFloatingIps = absolutelimit.getMaxTotalFloatingIps();
        Assert.assertNotNull(maxTotalFloatingIps);

        Integer maxPersonality = absolutelimit.getMaxPersonality();
        Assert.assertNotNull(maxPersonality);

        Integer personalityUsed = absolutelimit.getPersonalityUsed();
        Assert.assertNotNull(personalityUsed);

        Integer maxSecurityGroups = absolutelimit.getMaxSecurityGroups();
        Assert.assertNotNull(maxSecurityGroups);

        Integer securityGroupRulesUsed = absolutelimit.getSecurityGroupRulesUsed();
        Assert.assertNotNull(securityGroupRulesUsed);

        Integer maxTotalCores = absolutelimit.getMaxTotalCores();
        Assert.assertNotNull(maxTotalCores);

        Integer maxServerMeta = absolutelimit.getMaxServerMeta();
        Assert.assertNotNull(maxServerMeta);

        Integer maxPersonalitySize = absolutelimit.getMaxPersonalitySize();
        Assert.assertNotNull(maxPersonalitySize);

        Integer personalitySizeUsed = absolutelimit.getPersonalitySizeUsed();
        Assert.assertNotNull(personalitySizeUsed);

        Integer totalKeyPairsUsed = absolutelimit.getTotalKeyPairsUsed();
        Assert.assertNotNull(totalKeyPairsUsed);

        Integer totalFloatingIpsUsed = absolutelimit.getTotalFloatingIpsUsed();
        Assert.assertNotNull(totalFloatingIpsUsed);

        Integer totalInstancesUsed = absolutelimit.getTotalInstancesUsed();
        Assert.assertNotNull(totalInstancesUsed);

        Integer totalRAMUsed = absolutelimit.getTotalRAMUsed();
        Assert.assertNotNull(totalRAMUsed);
    }
}
