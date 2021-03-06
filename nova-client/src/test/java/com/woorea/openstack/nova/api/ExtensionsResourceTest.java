/*-
 * ONAP-SO
 * ============LICENSE_START=======================================================
 * Copyright 2018 Huawei Intellectual Property. All rights reserved.
 * =================================================================
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

package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Extensions;

public class ExtensionsResourceTest {

    private final OpenStackClient client;

    public ExtensionsResourceTest(OpenStackClient client) {
        this.client = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public class List extends OpenStackRequest<Extensions> {

        public List(boolean detail) {
            super(client, HttpMethod.GET, detail ? "extensions/detail" : "extensions", null, Extensions.class);
        }
    }
}

