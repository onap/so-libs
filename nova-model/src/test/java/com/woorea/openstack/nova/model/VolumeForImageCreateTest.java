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

public class VolumeForImageCreateTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"os-volume_upload_image\" : {" + EOL
        + "    \"volumeId\" : \"volumeid\"," + EOL
        + "    \"tenantId\" : \"tenantid\"," + EOL
        + "    \"force\" : false," + EOL
        + "    \"container_format\" : \"container_format\"," + EOL
        + "    \"disk_format\" : \"disk_format\"," + EOL
        + "    \"image_name\" : \"image_name\"" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(SerializationFeature.WRAP_ROOT_VALUE)
        .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + VolumeForImageCreate.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        VolumeForImageCreate volumeforimagecreate = objectMapper.readValue(JSON_FULL, VolumeForImageCreate.class);
        String json = objectMapper.writeValueAsString(volumeforimagecreate);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        VolumeForImageCreate volumeforimagecreate = objectMapper.readValue(JSON_FULL, VolumeForImageCreate.class);
        volumeforimagecreate.toString();
        
        String image_name = volumeforimagecreate.getImage_name();
        Assert.assertNotNull(image_name);
        volumeforimagecreate.setImage_name(image_name);
        
        String tenantId = volumeforimagecreate.getTenantId();
        Assert.assertNotNull(tenantId);
        volumeforimagecreate.setTenantId(tenantId);
        
        String volumeId = volumeforimagecreate.getVolumeId();
        Assert.assertNotNull(volumeId);
        volumeforimagecreate.setVolumeId(volumeId);
        
        String disk_format = volumeforimagecreate.getDisk_format();
        Assert.assertNotNull(disk_format);
        volumeforimagecreate.setDisk_format(disk_format);
        
        Boolean force = volumeforimagecreate.getForce();
        Assert.assertNotNull(force);
        volumeforimagecreate.setForce(force);
        
        String container_format = volumeforimagecreate.getContainer_format();
        Assert.assertNotNull(container_format);
        volumeforimagecreate.setContainer_format(container_format);
    }
}
