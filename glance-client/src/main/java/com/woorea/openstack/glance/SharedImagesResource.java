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

package com.woorea.openstack.glance;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.glance.model.SharedImages;

public class SharedImagesResource {

    private final OpenStackClient client;

    public SharedImagesResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(String tenantId, boolean detail) {
        return new List(tenantId, detail);
    }

    public class List extends OpenStackRequest<SharedImages> {

        public List(String tenantId, boolean detail) {
            super(client, HttpMethod.GET,
                new StringBuffer(detail ? "/shared-images/detail" : "/shared-images/").append(tenantId).toString(),
                null, SharedImages.class);
        }
    }
}
