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

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AvailabilityZonesTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "\"availabilityZoneInfo\": [" + EOL + "{" + EOL
            + "\"hosts\": null," + EOL + "\"zoneName\": \"zoneName1\"," + EOL + "\"zoneState\": {" + EOL
            + "\"available\": true" + EOL + "}" + EOL + "}," + EOL + "{" + EOL + "\"hosts\": null," + EOL
            + "\"zoneName\": \"zoneName2\"," + EOL + "\"zoneState\": {" + EOL + "\"available\": true" + EOL + "}" + EOL
            + "}" + EOL + "]" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
            .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + AvailabilityZones.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        AvailabilityZones az = objectMapper.readValue(JSON_FULL, AvailabilityZones.class);
        String json = objectMapper.writeValueAsString(az);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        AvailabilityZones azs = objectMapper.readValue(JSON_FULL, AvailabilityZones.class);

        List<AvailabilityZone> list = azs.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("zoneName1", azs.getList().get(0).getName());

        int cnt = 0;
        for (@SuppressWarnings("unused")
        AvailabilityZone x : azs) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
