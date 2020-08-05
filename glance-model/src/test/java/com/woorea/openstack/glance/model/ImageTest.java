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

package com.woorea.openstack.glance.model;

import java.util.Calendar;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ImageTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "    \"id\" : \"id\"," + EOL + "    \"uri\" : \"uri\"," + EOL
            + "    \"name\" : \"name\"," + EOL + "    \"os_distro\" : \"gw\"," + EOL + "    \"os_version\" : \"1\","
            + EOL + "    \"size\" : 43," + EOL + "    \"checksum\" : \"checksum\"," + EOL
            + "    \"status\" : \"status\"," + EOL + "    \"owner\" : \"owner\"," + EOL + "    \"properties\" : {" + EOL
            + "      \"properties-k1\" : \"properties-v1\"," + EOL + "      \"properties-k2\" : \"properties-v2\"" + EOL
            + "    }," + EOL + "    \"public\" : false," + EOL + "    \"deleted\" : false," + EOL
            + "    \"protected\" : true," + EOL + "    \"disk_format\" : \"diskformat\"," + EOL
            + "    \"container_format\" : \"containerformat\"," + EOL + "    \"virtual_size\" : 18," + EOL
            + "    \"created_at\" : 1486296000000," + EOL + "    \"updated_at\" : 1487592000000," + EOL
            + "    \"deleted_at\" : 1486209600000," + EOL + "    \"is_public\" : false," + EOL + "    \"min_ram\" : 62,"
            + EOL + "    \"min_disk\" : 69" + EOL + "  }";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
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

        String owner = image.getOwner();
        Assert.assertNotNull(owner);
        image.setOwner(owner);

        String containerFormat = image.getContainerFormat();
        Assert.assertNotNull(containerFormat);
        image.setContainerFormat(containerFormat);

        String uri = image.getUri();
        Assert.assertNotNull(uri);
        image.setUri(uri);

        Calendar createdAt = image.getCreatedAt();
        Assert.assertNotNull(createdAt);
        image.setCreatedAt(createdAt);

        Calendar deletedAt = image.getDeletedAt();
        Assert.assertNotNull(deletedAt);
        image.setDeletedAt(deletedAt);

        Long size = image.getSize();
        Assert.assertNotNull(size);
        image.setSize(size);

        Integer minRam = image.getMinRam();
        Assert.assertNotNull(minRam);
        image.setMinRam(minRam);

        String diskFormat = image.getDiskFormat();
        Assert.assertNotNull(diskFormat);
        image.setDiskFormat(diskFormat);

        String checksum = image.getChecksum();
        Assert.assertNotNull(checksum);
        image.setChecksum(checksum);

        String name = image.getName();
        Assert.assertNotNull(name);
        image.setName(name);

        String id = image.getId();
        Assert.assertNotNull(id);
        image.setId(id);

        Long virtualSize = image.getVirtualSize();
        Assert.assertNotNull(virtualSize);
        image.setVirtualSize(virtualSize);

        Map<String, Object> properties = image.getProperties();
        Assert.assertNotNull(properties);
        Assert.assertEquals(2, properties.size());

        Integer minDisk = image.getMinDisk();
        Assert.assertNotNull(minDisk);
        image.setMinDisk(minDisk);

        String status = image.getStatus();
        Assert.assertNotNull(status);
        image.setStatus(status);

        Calendar updatedAt = image.getUpdatedAt();
        Assert.assertNotNull(updatedAt);
        image.setUpdatedAt(updatedAt);

        String distro = image.getOsDistro();
        Assert.assertNotNull(distro);

        String version = image.getOsVersion();
        Assert.assertNotNull(version);

    }
}
