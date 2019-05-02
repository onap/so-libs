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
import com.woorea.openstack.heat.model.Stack.Output;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class StackTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"stack\" : {" + EOL
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
            + "    \"creation_time\" : 1488974400000," + EOL + "    \"stack_status\" : \"stackstatus\"" + EOL + "  }"
            + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Stack.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Stack stack = objectMapper.readValue(JSON_FULL, Stack.class);
        String json = objectMapper.writeValueAsString(stack);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Stack stack = objectMapper.readValue(JSON_FULL, Stack.class);
        stack.toString();

        Date updatedTime = stack.getUpdatedTime();
        Assert.assertNotNull(updatedTime);
        stack.setUpdatedTime(updatedTime);

        List<Output> outputs = stack.getOutputs();
        Assert.assertNotNull(outputs);
        Assert.assertEquals(2, outputs.size());

        String stackStatus = stack.getStackStatus();
        Assert.assertNotNull(stackStatus);
        stack.setStackStatus(stackStatus);

        String description = stack.getDescription();
        Assert.assertNotNull(description);
        stack.setDescription(description);

        Map<String, Object> files = stack.getFiles();
        Assert.assertNotNull(files);
        Assert.assertEquals(2, files.size());
        stack.setFiles(files);

        List<Link> links = stack.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        stack.setLinks(links);

        String stackName = stack.getStackName();
        Assert.assertNotNull(stackName);
        stack.setStackName(stackName);

        String id = stack.getId();
        Assert.assertNotNull(id);
        stack.setId(id);

        Date creationTime = stack.getCreationTime();
        Assert.assertNotNull(creationTime);
        stack.setCreationTime(creationTime);

        Map<String, Object> parameters = stack.getParameters();
        Assert.assertNotNull(parameters);
        Assert.assertEquals(2, parameters.size());
        stack.setParameters(parameters);

        String stackStatusReason = stack.getStackStatusReason();
        Assert.assertNotNull(stackStatusReason);
        stack.setStackStatusReason(stackStatusReason);
    }
}
