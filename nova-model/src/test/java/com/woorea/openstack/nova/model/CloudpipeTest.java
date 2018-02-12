/*-
 * ============LICENSE_START=======================================================
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

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CloudpipeTest {

    private Cloudpipe pipe = new Cloudpipe();

    @Test
    public void getProjectId() {
        pipe.getProjectId();
    }

    @Test
    public void setProjectId() {
        pipe.setProjectId("1234");
    }

    @Test
    public void getInternalIp() {
        pipe.getInternalIp();
    }

    @Test
    public void setInternalIp() {
        pipe.setInternalIp("123");
    }

    @Test
    public void getPublicIp() {
        pipe.getPublicIp();
    }

    @Test
    public void setPublicIp() {
        pipe.setPublicIp("1234");
    }

    @Test
    public void getPublicPort() {
        pipe.getPublicPort();
    }

    @Test
    public void setPublicPort() {
        pipe.setPublicPort("1234");
    }

    @Test
    public void getState() {
        pipe.getState();
    }

    @Test
    public void setState() {
        pipe.setState("1234");
    }

    @Test
    public void getInstanceId() {
        pipe.getInstanceId();
    }

    @Test
    public void setInstanceId() {
        pipe.setInstanceId("1234");
    }

    @Test
    public void getCreatedAt() {
        pipe.getCreatedAt();
    }

    @Test
    public void setCreatedAt() {
        pipe.setCreatedAt(Calendar.getInstance());
    }
}