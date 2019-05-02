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
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class UpdateStackParamTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"template\" : \"template\"," + EOL + "  \"parameters\" : {"
            + EOL + "    \"parameters-k1\" : \"parameters-v1\"," + EOL + "    \"parameters-k2\" : \"parameters-v2\""
            + EOL + "  }," + EOL + "  \"environment\" : \"environment\"," + EOL + "  \"files\" : {" + EOL
            + "    \"files-k1\" : \"files-v1\"," + EOL + "    \"files-k2\" : \"files-v2\"" + EOL + "  }," + EOL
            + "  \"template_url\" : \"templateurl\"," + EOL + "  \"timeout_mins\" : 79," + EOL
            + "  \"disable_rollback\" : true" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + UpdateStackParam.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        UpdateStackParam updatestackparam = objectMapper.readValue(JSON_FULL, UpdateStackParam.class);
        String json = objectMapper.writeValueAsString(updatestackparam);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        UpdateStackParam updatestackparam = objectMapper.readValue(JSON_FULL, UpdateStackParam.class);
        updatestackparam.toString();

        String template = updatestackparam.getTemplate();
        Assert.assertNotNull(template);
        updatestackparam.setTemplate(template);

        String environment = updatestackparam.getEnvironment();
        Assert.assertNotNull(environment);
        updatestackparam.setEnvironment(environment);

        int timeoutMinutes = updatestackparam.getTimeoutMinutes();
        Assert.assertNotNull(timeoutMinutes);
        updatestackparam.setTimeoutMinutes(timeoutMinutes);

        boolean disableRollback = updatestackparam.getDisableRollback();
        Assert.assertNotNull(disableRollback);
        updatestackparam.setDisableRollback(disableRollback);

        Map<String, Object> files = updatestackparam.getFiles();
        Assert.assertNotNull(files);
        Assert.assertEquals(2, files.size());
        updatestackparam.setFiles(files);

        Map<String, Object> parameters = updatestackparam.getParameters();
        Assert.assertNotNull(parameters);
        Assert.assertEquals(2, parameters.size());
        updatestackparam.setParameters(parameters);

        String templateUrl = updatestackparam.getTemplateUrl();
        Assert.assertNotNull(templateUrl);
        updatestackparam.setTemplateUrl(templateUrl);
    }
}
