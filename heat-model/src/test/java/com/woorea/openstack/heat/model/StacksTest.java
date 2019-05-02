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

package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class StacksTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"stacks\" : [ {" + EOL
            + "    \"description\" : \"description\"," + EOL + "    \"links\" : [ {" + EOL
            + "      \"href\" : \"href\"," + EOL + "      \"rel\" : \"rel\"" + EOL + "    }, {" + EOL
            + "      \"href\" : \"href\"," + EOL + "      \"rel\" : \"rel\"" + EOL + "    } ]," + EOL
            + "    \"id\" : \"id\"," + EOL + "    \"files\" : {" + EOL + "      \"files-k1\" : \"files-v1\"," + EOL
            + "      \"files-k2\" : \"files-v2\"" + EOL + "    }," + EOL + "    \"outputs\" : [ {" + EOL
            + "      \"description\" : \"description\"," + EOL + "      \"output_value\" : \"outputvalue\"," + EOL
            + "      \"output_key\" : \"outputkey\"" + EOL + "    }, {" + EOL
            + "      \"description\" : \"description\"," + EOL + "      \"output_value\" : \"outputvalue\"," + EOL
            + "      \"output_key\" : \"outputkey\"" + EOL + "    } ]," + EOL + "    \"parameters\" : {" + EOL
            + "      \"parameters-k1\" : \"parameters-v1\"," + EOL + "      \"parameters-k2\" : \"parameters-v2\"" + EOL
            + "    }," + EOL + "    \"stack_status_reason\" : \"stackstatusreason\"," + EOL
            + "    \"stack_name\" : \"stackname\"," + EOL + "    \"updated_time\" : 1488110400000," + EOL
            + "    \"creation_time\" : 1488974400000," + EOL + "    \"stack_status\" : \"stackstatus\"" + EOL + "  }, {"
            + EOL + "    \"description\" : \"description\"," + EOL + "    \"links\" : [ {" + EOL
            + "      \"href\" : \"href\"," + EOL + "      \"rel\" : \"rel\"" + EOL + "    }, {" + EOL
            + "      \"href\" : \"href\"," + EOL + "      \"rel\" : \"rel\"" + EOL + "    } ]," + EOL
            + "    \"id\" : \"id\"," + EOL + "    \"files\" : {" + EOL + "      \"files-k1\" : \"files-v1\"," + EOL
            + "      \"files-k2\" : \"files-v2\"" + EOL + "    }," + EOL + "    \"outputs\" : [ {" + EOL
            + "      \"description\" : \"description\"," + EOL + "      \"output_value\" : \"outputvalue\"," + EOL
            + "      \"output_key\" : \"outputkey\"" + EOL + "    }, {" + EOL
            + "      \"description\" : \"description\"," + EOL + "      \"output_value\" : \"outputvalue\"," + EOL
            + "      \"output_key\" : \"outputkey\"" + EOL + "    } ]," + EOL + "    \"parameters\" : {" + EOL
            + "      \"parameters-k1\" : \"parameters-v1\"," + EOL + "      \"parameters-k2\" : \"parameters-v2\"" + EOL
            + "    }," + EOL + "    \"stack_status_reason\" : \"stackstatusreason\"," + EOL
            + "    \"stack_name\" : \"stackname\"," + EOL + "    \"updated_time\" : 1488110400000," + EOL
            + "    \"creation_time\" : 1488974400000," + EOL + "    \"stack_status\" : \"stackstatus\"" + EOL + "  } ]"
            + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Stacks.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Stacks stacks = objectMapper.readValue(JSON_FULL, Stacks.class);
        String json = objectMapper.writeValueAsString(stacks);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Stacks stacks = objectMapper.readValue(JSON_FULL, Stacks.class);
        stacks.toString();

        int cnt = 0;
        for (@SuppressWarnings("unused")
        Stack x : stacks) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
