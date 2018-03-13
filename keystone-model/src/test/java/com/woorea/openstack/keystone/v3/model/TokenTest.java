/*-

 * ONAP-SO
 * ============LICENSE_START=======================================================
 * Copyright 2018 Huawei Intellectual Property. All rights reserved.
 * ===================================================================
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
package com.woorea.openstack.keystone.v3.model;

import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

public class TokenTest {

    Token token = new Token();

    @Test
    public void getId() throws Exception {
        token.getId();
    }

    @Test
    public void setId() throws Exception {
        token.setId("test");
    }

    @Test
    public void getExpiresAt() throws Exception {
        token.getExpiresAt();
    }

    @Test
    public void setExpiresAt() throws Exception {
        Calendar calendar = new GregorianCalendar();
        token.setExpiresAt(calendar);
    }

    @Test
    public void getIssuedAt() throws Exception {
        token.getIssuedAt();
    }

    @Test
    public void setIssuedAt() throws Exception {
        token.setIssuedAt(new GregorianCalendar());
    }

    @Test
    public void getMethods() throws Exception {
        token.getMethods();
    }

    @Test
    public void setMethods() throws Exception {
        token.setMethods(Collections.<String>emptyList());
    }

    @Test
    public void getDomain() throws Exception {
        token.getDomain();
    }

    @Test
    public void setDomain() throws Exception {
        token.setDomain(new Token.Domain());
    }

    @Test
    public void getProject() throws Exception {
        token.getProject();
    }

    @Test
    public void setProject() throws Exception {
        token.setProject(new Token.Project());
    }

    @Test
    public void getUser() throws Exception {
        token.getUser();
    }

    @Test
    public void setUser() throws Exception {
        token.setUser(new Token.User());
    }

    @Test
    public void getRoles() throws Exception {
        token.getRoles();
    }

    @Test
    public void setRoles() throws Exception {
        token.setRoles(Collections.<Token.Role>emptyList());
    }

    @Test
    public void getCatalog() throws Exception {
        token.getCatalog();
    }

    @Test
    public void setCatalog() throws Exception {
        token.setCatalog(Collections.<Token.Service>emptyList());
    }

}