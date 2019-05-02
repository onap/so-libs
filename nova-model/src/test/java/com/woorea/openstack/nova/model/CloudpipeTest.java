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
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class CloudpipeTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"cloudpipe\" : {" + EOL
            + "    \"projectId\" : \"projectid\"," + EOL + "    \"internalIp\" : \"internalip\"," + EOL
            + "    \"publicIp\" : \"publicip\"," + EOL + "    \"publicPort\" : \"publicport\"," + EOL
            + "    \"state\" : \"state\"," + EOL + "    \"instanceId\" : \"instanceid\"," + EOL
            + "    \"createdAt\" : 1486296000000" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Cloudpipe.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Cloudpipe cloudpipe = objectMapper.readValue(JSON_FULL, Cloudpipe.class);
        String json = objectMapper.writeValueAsString(cloudpipe);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Cloudpipe cloudpipe = objectMapper.readValue(JSON_FULL, Cloudpipe.class);
        cloudpipe.toString();

        Calendar createdAt = cloudpipe.getCreatedAt();
        Assert.assertNotNull(createdAt);
        cloudpipe.setCreatedAt(createdAt);

        String instanceId = cloudpipe.getInstanceId();
        Assert.assertNotNull(instanceId);
        cloudpipe.setInstanceId(instanceId);

        String publicIp = cloudpipe.getPublicIp();
        Assert.assertNotNull(publicIp);
        cloudpipe.setPublicIp(publicIp);

        String publicPort = cloudpipe.getPublicPort();
        Assert.assertNotNull(publicPort);
        cloudpipe.setPublicPort(publicPort);

        String state = cloudpipe.getState();
        Assert.assertNotNull(state);
        cloudpipe.setState(state);

        String projectId = cloudpipe.getProjectId();
        Assert.assertNotNull(projectId);
        cloudpipe.setProjectId(projectId);

        String internalIp = cloudpipe.getInternalIp();
        Assert.assertNotNull(internalIp);
        cloudpipe.setInternalIp(internalIp);
    }
}
