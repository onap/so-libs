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

public class ImageFromVolumeTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"os-volume_upload_image\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"updates_at\" : \"updates_at\"," + EOL
        + "    \"status\" : \"status\"," + EOL
        + "    \"display_description\" : \"display_description\"," + EOL
        + "    \"size\" : \"size\"," + EOL
        + "    \"volume_type\" : \"volume_type\"," + EOL
        + "    \"image_id\" : \"image_id\"," + EOL
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
        System.out.println("CLASS: " + ImageFromVolume.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        ImageFromVolume imagefromvolume = objectMapper.readValue(JSON_FULL, ImageFromVolume.class);
        String json = objectMapper.writeValueAsString(imagefromvolume);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        ImageFromVolume imagefromvolume = objectMapper.readValue(JSON_FULL, ImageFromVolume.class);
        imagefromvolume.toString();
        
        String image_name = imagefromvolume.getImage_name();
        Assert.assertNotNull(image_name);
        imagefromvolume.setImage_name(image_name);
        
        String display_description = imagefromvolume.getDisplay_description();
        Assert.assertNotNull(display_description);
        imagefromvolume.setDisplay_description(display_description);
        
        String updates_at = imagefromvolume.getUpdates_at();
        Assert.assertNotNull(updates_at);
        imagefromvolume.setUpdates_at(updates_at);
        
        String volume_type = imagefromvolume.getVolume_type();
        Assert.assertNotNull(volume_type);
        imagefromvolume.setVolume_type(volume_type);
        
        String size = imagefromvolume.getSize();
        Assert.assertNotNull(size);
        imagefromvolume.setSize(size);
        
        String disk_format = imagefromvolume.getDisk_format();
        Assert.assertNotNull(disk_format);
        imagefromvolume.setDisk_format(disk_format);
        
        String id = imagefromvolume.getId();
        Assert.assertNotNull(id);
        imagefromvolume.setId(id);
        
        String image_id = imagefromvolume.getImage_id();
        Assert.assertNotNull(image_id);
        imagefromvolume.setImage_id(image_id);
        
        String container_format = imagefromvolume.getContainer_format();
        Assert.assertNotNull(container_format);
        imagefromvolume.setContainer_format(container_format);
        
        String status = imagefromvolume.getStatus();
        Assert.assertNotNull(status);
        imagefromvolume.setStatus(status);
    }
}
