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

import com.woorea.openstack.heat.model.CreateStackParam;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class CreateStackParamTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"template\" : \"template\"," + EOL
        + "  \"parameters\" : {" + EOL
        + "    \"parameters-k1\" : \"parameters-v1\"," + EOL
        + "    \"parameters-k2\" : \"parameters-v2\"" + EOL
        + "  }," + EOL
        + "  \"environment\" : \"environment\"," + EOL
        + "  \"files\" : {" + EOL
        + "    \"files-k1\" : \"files-v1\"," + EOL
        + "    \"files-k2\" : \"files-v2\"" + EOL
        + "  }," + EOL
        + "  \"stack_name\" : \"stackname\"," + EOL
        + "  \"template_url\" : \"templateurl\"," + EOL
        + "  \"timeout_mins\" : 79," + EOL
        + "  \"disable_rollback\" : true" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + CreateStackParam.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        CreateStackParam createstackparam = objectMapper.readValue(JSON_FULL, CreateStackParam.class);
        String json = objectMapper.writeValueAsString(createstackparam);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        CreateStackParam createstackparam = objectMapper.readValue(JSON_FULL, CreateStackParam.class);
        createstackparam.toString();
        
        String template = createstackparam.getTemplate();
        Assert.assertNotNull(template);
        createstackparam.setTemplate(template);
        
        String environment = createstackparam.getEnvironment();
        Assert.assertNotNull(environment);
        createstackparam.setEnvironment(environment);
        
        int timeoutMinutes = createstackparam.getTimeoutMinutes();
        Assert.assertNotNull(timeoutMinutes);
        createstackparam.setTimeoutMinutes(timeoutMinutes);
        
        boolean disableRollback = createstackparam.getDisableRollback();
        Assert.assertNotNull(disableRollback);
        createstackparam.setDisableRollback(disableRollback);
        
        Map<String,Object> files = createstackparam.getFiles();
        Assert.assertNotNull(files);
        Assert.assertEquals(2, files.size());
        createstackparam.setFiles(files);
        
        String stackName = createstackparam.getStackName();
        Assert.assertNotNull(stackName);
        createstackparam.setStackName(stackName);
        
        Map<String,Object> parameters = createstackparam.getParameters();
        Assert.assertNotNull(parameters);
        Assert.assertEquals(2, parameters.size());
        createstackparam.setParameters(parameters);
        
        String templateUrl = createstackparam.getTemplateUrl();
        Assert.assertNotNull(templateUrl);
        createstackparam.setTemplateUrl(templateUrl);
    }
}
