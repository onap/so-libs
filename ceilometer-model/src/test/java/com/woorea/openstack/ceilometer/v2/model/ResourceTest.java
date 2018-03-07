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
package com.woorea.openstack.ceilometer.v2.model;

import org.junit.Test;

public class ResourceTest {

    Resource resource = new Resource();

    @Test
    public void getResourceTest() throws Exception {
        resource.getResource();
    }

    @Test
    public void getTimestampTest() throws Exception {
        resource.getTimestamp();
    }

    @Test
    public void getProjectTest() throws Exception {
        resource.getProject();
    }

    @Test
    public void getUserTest() throws Exception {
        resource.getUser();
    }

    @Test
    public void getMetadataTest() throws Exception {
        resource.getMetadata();
    }

}