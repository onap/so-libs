/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
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

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateStackParamTest {

    UpdateStackParam test = new UpdateStackParam();

    @Test
    public void getTemplateUrlTest() throws Exception {
        test.getTemplateUrl();
    }

    @Test
    public void setTemplateUrlTest() throws Exception {
        test.setTemplateUrl("url");
    }

    @Test
    public void getParametersTest() throws Exception {
        test.getParameters();
    }

    @Test
    public void getTemplateTest() throws Exception {
        test.getTemplate();
    }

    @Test
    public void setTemplateTest() throws Exception {
        test.setTemplate("template");
    }


    @Test
    public void setParametersTest() throws Exception {
        Map<String, Object> paramters = new HashMap<String,Object>();
        paramters.put("1",test);
        test.setParameters(paramters);
    }
    @Test
    public void getTimeoutMinutesTest() throws Exception {
        test.getTimeoutMinutes();
    }

    @Test
    public void setTimeoutMinutesTest() throws Exception {
        test.setTimeoutMinutes(0);
    }
    @Test
    public void getEnvironmentTest() throws Exception {
        test.getEnvironment();
    }

    @Test
    public void setFilesTest() throws Exception {
        Map<String, Object> files = new HashMap<String,Object>();
        files.put("1",test);
        test.setFiles(files);
    }

    @Test
    public void getFilesTest() throws Exception {
        test.getFiles();
    }

    @Test
    public void setEnvironmentTest() throws Exception {
        test.setEnvironment("environment");
    }


    @Test
    public void getDisableRollbackTest() throws Exception {
        test.getDisableRollback();
    }

    @Test
    public void setDisableRollbackTest() throws Exception {
        test.setDisableRollback(true);
    }
}
