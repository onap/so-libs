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
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SnapshotForCreateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"snapshot\" : {" + EOL + "    \"force\" : false," + EOL
            + "    \"volume_id\" : \"volumeid\"," + EOL + "    \"display_name\" : \"name\"," + EOL
            + "    \"display_description\" : \"description\"" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + SnapshotForCreate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        SnapshotForCreate snapshotforcreate = objectMapper.readValue(JSON_FULL, SnapshotForCreate.class);
        String json = objectMapper.writeValueAsString(snapshotforcreate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        SnapshotForCreate snapshotforcreate = objectMapper.readValue(JSON_FULL, SnapshotForCreate.class);
        snapshotforcreate.toString();

        String name = snapshotforcreate.getName();
        Assert.assertNotNull(name);
        snapshotforcreate.setName(name);

        String volumeId = snapshotforcreate.getVolumeId();
        Assert.assertNotNull(volumeId);
        snapshotforcreate.setVolumeId(volumeId);

        String description = snapshotforcreate.getDescription();
        Assert.assertNotNull(description);
        snapshotforcreate.setDescription(description);

        Boolean force = snapshotforcreate.getForce();
        Assert.assertNotNull(force);
        snapshotforcreate.setForce(force);
    }
}
