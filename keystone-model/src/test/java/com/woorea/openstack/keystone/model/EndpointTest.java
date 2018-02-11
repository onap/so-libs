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

package com.woorea.openstack.keystone.model;

import org.junit.Test;

public class EndpointTest {

    Endpoint endpoint = new Endpoint();

    @Test
    public void getId() throws Exception {
        endpoint.getId();
    }

    @Test
    public void setId() throws Exception {
        endpoint.setId("test");
    }

    @Test
    public void getServiceId() throws Exception {
        endpoint.getServiceId();
    }

    @Test
    public void setServiceId() throws Exception {
        endpoint.setServiceId("test");
    }

    @Test
    public void getRegion() throws Exception {
        endpoint.getRegion();
    }

    @Test
    public void setRegion() throws Exception {
        endpoint.setRegion("region");
    }

    @Test
    public void getPublicURL() throws Exception {
        endpoint.getPublicURL();
    }

    @Test
    public void setPublicURL() throws Exception {
        endpoint.setPublicURL("url");
    }

    @Test
    public void getInternalURL() throws Exception {
        endpoint.getInternalURL();
    }

    @Test
    public void setInternalURL() throws Exception {
        endpoint.setInternalURL("test");
    }

    @Test
    public void getAdminURL() throws Exception {
        endpoint.getAdminURL();
    }

    @Test
    public void setAdminURL() throws Exception {
        endpoint.setAdminURL("admin url");
    }

}