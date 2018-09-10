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

import com.woorea.openstack.nova.model.Extension;
import com.woorea.openstack.nova.model.Extensions;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ExtensionsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"extensions\" : [ {" + EOL
        + "    \"alias\" : \"alias\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"namespace\" : \"namespace\"," + EOL
        + "    \"updated\" : 1486468800000," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]" + EOL
        + "  }, {" + EOL
        + "    \"alias\" : \"alias\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"namespace\" : \"namespace\"," + EOL
        + "    \"updated\" : 1486468800000," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Extensions.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Extensions extensions = objectMapper.readValue(JSON_FULL, Extensions.class);
        String json = objectMapper.writeValueAsString(extensions);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Extensions extensions = objectMapper.readValue(JSON_FULL, Extensions.class);
        extensions.toString();
        
        List<Extension> list = extensions.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        
        int cnt = 0;
        for (@SuppressWarnings("unused") Extension x : extensions) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
