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
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class VolumeForCreateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL =
            "{" + EOL + "  \"volume\" : {" + EOL + "    \"size\" : 61," + EOL + "    \"metadata\" : {" + EOL
                    + "      \"metadata-k1\" : \"metadata-v1\"," + EOL + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
                    + "    }," + EOL + "    \"availability_zone\" : \"availabilityzone\"," + EOL
                    + "    \"display_name\" : \"name\"," + EOL + "    \"display_description\" : \"description\"," + EOL
                    + "    \"snapshot_id\" : 3" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + VolumeForCreate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        VolumeForCreate volumeforcreate = objectMapper.readValue(JSON_FULL, VolumeForCreate.class);
        String json = objectMapper.writeValueAsString(volumeforcreate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        VolumeForCreate volumeforcreate = objectMapper.readValue(JSON_FULL, VolumeForCreate.class);
        volumeforcreate.toString();

        Map<String, String> metadata = volumeforcreate.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        volumeforcreate.setMetadata(metadata);

        Integer snapshotId = volumeforcreate.getSnapshotId();
        Assert.assertNotNull(snapshotId);
        volumeforcreate.setSnapshotId(snapshotId);

        Integer size = volumeforcreate.getSize();
        Assert.assertNotNull(size);
        volumeforcreate.setSize(size);

        String name = volumeforcreate.getName();
        Assert.assertNotNull(name);
        volumeforcreate.setName(name);

        String description = volumeforcreate.getDescription();
        Assert.assertNotNull(description);
        volumeforcreate.setDescription(description);

        String availabilityZone = volumeforcreate.getAvailabilityZone();
        Assert.assertNotNull(availabilityZone);
        volumeforcreate.setAvailabilityZone(availabilityZone);
    }
}
