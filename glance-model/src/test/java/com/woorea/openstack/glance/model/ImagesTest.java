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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ImagesTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"images\" : [ {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"uri\" : \"uri\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"size\" : 43," + EOL
        + "    \"checksum\" : \"checksum\"," + EOL
        + "    \"status\" : \"status\"," + EOL
        + "    \"owner\" : \"owner\"," + EOL
        + "    \"properties\" : {" + EOL
        + "      \"properties-k1\" : \"properties-v1\"," + EOL
        + "      \"properties-k2\" : \"properties-v2\"" + EOL
        + "    }," + EOL
        + "    \"public\" : false," + EOL
        + "    \"deleted\" : false," + EOL
        + "    \"protected\" : true," + EOL
        + "    \"disk_format\" : \"diskformat\"," + EOL
        + "    \"container_format\" : \"containerformat\"," + EOL
        + "    \"virtual_size\" : 18," + EOL
        + "    \"created_at\" : 1486296000000," + EOL
        + "    \"updated_at\" : 1487592000000," + EOL
        + "    \"deleted_at\" : 1486209600000," + EOL
        + "    \"is_public\" : false," + EOL
        + "    \"min_ram\" : 62," + EOL
        + "    \"min_disk\" : 69" + EOL
        + "  }, {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"uri\" : \"uri\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"size\" : 43," + EOL
        + "    \"checksum\" : \"checksum\"," + EOL
        + "    \"status\" : \"status\"," + EOL
        + "    \"owner\" : \"owner\"," + EOL
        + "    \"properties\" : {" + EOL
        + "      \"properties-k1\" : \"properties-v1\"," + EOL
        + "      \"properties-k2\" : \"properties-v2\"" + EOL
        + "    }," + EOL
        + "    \"public\" : false," + EOL
        + "    \"deleted\" : false," + EOL
        + "    \"protected\" : true," + EOL
        + "    \"disk_format\" : \"diskformat\"," + EOL
        + "    \"container_format\" : \"containerformat\"," + EOL
        + "    \"virtual_size\" : 18," + EOL
        + "    \"created_at\" : 1486296000000," + EOL
        + "    \"updated_at\" : 1487592000000," + EOL
        + "    \"deleted_at\" : 1486209600000," + EOL
        + "    \"is_public\" : false," + EOL
        + "    \"min_ram\" : 62," + EOL
        + "    \"min_disk\" : 69" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Images.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Images images = objectMapper.readValue(JSON_FULL, Images.class);
        String json = objectMapper.writeValueAsString(images);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Images images = objectMapper.readValue(JSON_FULL, Images.class);
        images.toString();
        
        List<Image> list = images.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        
        int cnt = 0;
        for (@SuppressWarnings("unused") Image x : images) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
