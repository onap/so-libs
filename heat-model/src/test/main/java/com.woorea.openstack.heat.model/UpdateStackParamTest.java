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
