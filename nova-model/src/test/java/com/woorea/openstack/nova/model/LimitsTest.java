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
import com.woorea.openstack.nova.model.Limits.RateLimit;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class LimitsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"limits\" : {" + EOL + "    \"rate\" : [ {" + EOL
            + "      \"regex\" : \"regex\"," + EOL + "      \"uri\" : \"uri\"," + EOL + "      \"limit\" : [ {" + EOL
            + "        \"unit\" : \"unit\"," + EOL + "        \"verb\" : \"verb\"," + EOL
            + "        \"remaining\" : 72," + EOL + "        \"available\" : 47," + EOL + "        \"value\" : 59,"
            + EOL + "        \"next-available\" : 1489320000000" + EOL + "      }, {" + EOL
            + "        \"unit\" : \"unit\"," + EOL + "        \"verb\" : \"verb\"," + EOL
            + "        \"remaining\" : 72," + EOL + "        \"available\" : 47," + EOL + "        \"value\" : 59,"
            + EOL + "        \"next-available\" : 1489320000000" + EOL + "      } ]" + EOL + "    }, {" + EOL
            + "      \"regex\" : \"regex\"," + EOL + "      \"uri\" : \"uri\"," + EOL + "      \"limit\" : [ {" + EOL
            + "        \"unit\" : \"unit\"," + EOL + "        \"verb\" : \"verb\"," + EOL
            + "        \"remaining\" : 72," + EOL + "        \"available\" : 47," + EOL + "        \"value\" : 59,"
            + EOL + "        \"next-available\" : 1489320000000" + EOL + "      }, {" + EOL
            + "        \"unit\" : \"unit\"," + EOL + "        \"verb\" : \"verb\"," + EOL
            + "        \"remaining\" : 72," + EOL + "        \"available\" : 47," + EOL + "        \"value\" : 59,"
            + EOL + "        \"next-available\" : 1489320000000" + EOL + "      } ]" + EOL + "    } ]," + EOL
            + "    \"absolute\" : {" + EOL + "      \"maxServerMeta\" : 30," + EOL + "      \"serverMetaUsed\" : 37,"
            + EOL + "      \"maxPersonality\" : 54," + EOL + "      \"personalityUsed\" : 61," + EOL
            + "      \"maxImageMeta\" : 82," + EOL + "      \"imageMetaUsed\" : 89," + EOL
            + "      \"maxPersonalitySize\" : 97," + EOL + "      \"personalitySizeUsed\" : 4," + EOL
            + "      \"maxTotalCores\" : 32," + EOL + "      \"totalCoresUsed\" : 39," + EOL
            + "      \"maxTotalInstances\" : 60," + EOL + "      \"totalInstancesUsed\" : 67," + EOL
            + "      \"maxTotalRAMSize\" : 55," + EOL + "      \"totalRAMUsed\" : 19," + EOL
            + "      \"maxSecurityGroupRules\" : 44," + EOL + "      \"securityGroupRulesUsed\" : 51," + EOL
            + "      \"maxTotalKeypairs\" : 64," + EOL + "      \"totalKeyPairsUsed\" : 71," + EOL
            + "      \"maxTotalVolumes\" : 71," + EOL + "      \"totalVolumesUsed\" : 78," + EOL
            + "      \"maxSecurityGroups\" : 4," + EOL + "      \"totalSecurityGroupsUsed\" : 59," + EOL
            + "      \"maxTotalFloatingIps\" : 76," + EOL + "      \"totalFloatingIpsUsed\" : 83," + EOL
            + "      \"maxTotalVolumeGigabytes\" : 15," + EOL + "      \"totalVolumeGigabytesUsed\" : 22" + EOL
            + "    }" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Limits.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Limits limits = objectMapper.readValue(JSON_FULL, Limits.class);
        String json = objectMapper.writeValueAsString(limits);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Limits limits = objectMapper.readValue(JSON_FULL, Limits.class);
        limits.toString();

        List<RateLimit> rate = limits.getRate();
        Assert.assertNotNull(rate);
        Assert.assertEquals(2, rate.size());

        AbsoluteLimit absolute = limits.getAbsolute();
        Assert.assertNotNull(absolute);
    }
}
