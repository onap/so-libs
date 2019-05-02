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
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class VolumeTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"volume\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"status\" : \"status\"," + EOL + "    \"availabilityZone\" : \"availabilityzone\"," + EOL
            + "    \"volumeType\" : \"volumetype\"," + EOL + "    \"snapshotId\" : \"snapshotid\"," + EOL
            + "    \"attachments\" : [ {" + EOL + "      \"attachments-v1-k1\" : \"attachments-v1-v1\"," + EOL
            + "      \"attachments-v1-k2\" : \"attachments-v1-v2\"" + EOL + "    }, {" + EOL
            + "      \"attachments-v2-k1\" : \"attachments-v2-v1\"," + EOL
            + "      \"attachments-v2-k2\" : \"attachments-v2-v2\"" + EOL + "    } ]," + EOL + "    \"metadata\" : {"
            + EOL + "      \"metadata-k1\" : \"metadata-v1\"," + EOL + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
            + "    }," + EOL + "    \"createdAt\" : \"createdat\"," + EOL + "    \"size\" : 61," + EOL
            + "    \"displayName\" : \"name\"," + EOL + "    \"displayDescription\" : \"description\"" + EOL + "  }"
            + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Volume.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Volume volume = objectMapper.readValue(JSON_FULL, Volume.class);
        String json = objectMapper.writeValueAsString(volume);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Volume volume = objectMapper.readValue(JSON_FULL, Volume.class);
        volume.toString();

        String volumeType = volume.getVolumeType();
        Assert.assertNotNull(volumeType);

        String createdAt = volume.getCreatedAt();
        Assert.assertNotNull(createdAt);

        Map<String, String> metadata = volume.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());

        List<Map<String, Object>> attachments = volume.getAttachments();
        Assert.assertNotNull(attachments);
        Assert.assertEquals(2, attachments.size());

        String snapshotId = volume.getSnapshotId();
        Assert.assertNotNull(snapshotId);

        Integer size = volume.getSize();
        Assert.assertNotNull(size);

        String name = volume.getName();
        Assert.assertNotNull(name);

        String description = volume.getDescription();
        Assert.assertNotNull(description);

        String id = volume.getId();
        Assert.assertNotNull(id);

        String availabilityZone = volume.getAvailabilityZone();
        Assert.assertNotNull(availabilityZone);

        String status = volume.getStatus();
        Assert.assertNotNull(status);
    }
}
