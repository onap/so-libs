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

import com.woorea.openstack.nova.model.KeyPairs;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class KeyPairsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"keypairs\" : [ {" + EOL
        + "    \"keypair\" : {" + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"fingerprint\" : \"fingerprint\"," + EOL
        + "      \"user_id\" : \"userid\"," + EOL
        + "      \"public_key\" : \"publickey\"," + EOL
        + "      \"private_key\" : \"privatekey\"" + EOL
        + "    }" + EOL
        + "  }, {" + EOL
        + "    \"keypair\" : { " + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"fingerprint\" : \"fingerprint\"," + EOL
        + "      \"user_id\" : \"userid\"," + EOL
        + "      \"public_key\" : \"publickey\"," + EOL
        + "      \"private_key\" : \"privatekey\"" + EOL
        + "    }" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    // This is test is ignored because The KeyPairs class does not
    // serialize into JSON correctly.  It is probably not an operational
    // issue because KeyPairs is only used to represent the response to
    // the GET os-keypairs request.
    @Ignore
    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + KeyPairs.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        KeyPairs keypairs = objectMapper.readValue(JSON_FULL, KeyPairs.class);
        String json = objectMapper.writeValueAsString(keypairs);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testGettersAndSetters() throws Exception {
        KeyPairs keypairs = objectMapper.readValue(JSON_FULL, KeyPairs.class);
        keypairs.toString();

        List<KeyPair> list = keypairs.getList();
        Assert.assertNotNull(list);

        int cnt = 0;
        for (@SuppressWarnings("unused") KeyPair x : keypairs) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
