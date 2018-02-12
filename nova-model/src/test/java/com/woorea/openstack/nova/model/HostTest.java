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

import static org.junit.Assert.*;

public class HostTest {

    private Host host = new Host();
    private Host.ResourceWrapper wrapper = new Host.ResourceWrapper();
    private Host.ResourceWrapper.Resource resource = new Host.ResourceWrapper.Resource();

    @Test
    public void getHost() {
        host.getHost();
    }

    @Test
    public void getResource() {
        wrapper.getResource();
    }

    @Test
    public String getProject() {
        return resource.getProject();
    }

    @Test
    public Integer getMemoryMb() {
        return resource.getMemoryMb();
    }

    @Test
    public String getHostResource() {
        return resource.getHost();
    }

    @Test
    public Integer getCpu() {
        return resource.getCpu();
    }

    @Test
    public Integer getDiskGb() {
        return resource.getDiskGb();
    }
}