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
import com.woorea.openstack.nova.model.Image.Server;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ImageTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"image\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"status\" : \"status\"," + EOL + "    \"name\" : \"name\"," + EOL + "    \"progress\" : 3," + EOL
            + "    \"minRam\" : 62," + EOL + "    \"minDisk\" : 69," + EOL + "    \"created\" : 1485172800000," + EOL
            + "    \"updated\" : 1486468800000," + EOL + "    \"metadata\" : {" + EOL
            + "      \"metadata-k1\" : \"metadata-v1\"," + EOL + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
            + "    }," + EOL + "    \"server\" : {" + EOL + "      \"id\" : \"id\"," + EOL + "      \"links\" : [ {"
            + EOL + "        \"rel\" : \"rel\"," + EOL + "        \"href\" : \"href\"," + EOL
            + "        \"type\" : \"type\"" + EOL + "      }, {" + EOL + "        \"rel\" : \"rel\"," + EOL
            + "        \"href\" : \"href\"," + EOL + "        \"type\" : \"type\"" + EOL + "      } ]" + EOL + "    },"
            + EOL + "    \"links\" : [ {" + EOL + "      \"rel\" : \"rel\"," + EOL + "      \"href\" : \"href\"," + EOL
            + "      \"type\" : \"type\"" + EOL + "    }, {" + EOL + "      \"rel\" : \"rel\"," + EOL
            + "      \"href\" : \"href\"," + EOL + "      \"type\" : \"type\"" + EOL + "    } ]," + EOL
            + "    \"OS-EXT-IMG-SIZE:size\" : 43" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Image.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Image image = objectMapper.readValue(JSON_FULL, Image.class);
        String json = objectMapper.writeValueAsString(image);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Image image = objectMapper.readValue(JSON_FULL, Image.class);
        image.toString();

        Server server = image.getServer();
        Assert.assertNotNull(server);

        Map<String, String> metadata = image.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        image.setMetadata(metadata);

        Long size = image.getSize();
        Assert.assertNotNull(size);

        Calendar created = image.getCreated();
        Assert.assertNotNull(created);
        image.setCreated(created);

        Integer minRam = image.getMinRam();
        Assert.assertNotNull(minRam);
        image.setMinRam(minRam);

        String name = image.getName();
        Assert.assertNotNull(name);
        image.setName(name);

        Integer progress = image.getProgress();
        Assert.assertNotNull(progress);
        image.setProgress(progress);

        List<Link> links = image.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        image.setLinks(links);

        String id = image.getId();
        Assert.assertNotNull(id);
        image.setId(id);

        Calendar updated = image.getUpdated();
        Assert.assertNotNull(updated);
        image.setUpdated(updated);

        Integer minDisk = image.getMinDisk();
        Assert.assertNotNull(minDisk);
        image.setMinDisk(minDisk);

        String status = image.getStatus();
        Assert.assertNotNull(status);
        image.setStatus(status);
    }
}
