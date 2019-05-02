/* ============LICENSE_START=======================================================
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
package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.Limits;

public class LimitsExtension {

    private final OpenStackClient CLIENT;

    public LimitsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public class List extends OpenStackRequest<Limits> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/limits", null, Limits.class);
        }

    }

}
