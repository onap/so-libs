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

package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Certificate;

public class CredentialsExtension {

    private final OpenStackClient CLIENT;

    public CredentialsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public Create createCertificate(String id) {
        return new Create(id);
    }

    public Show showCertificate() {
        return new Show();
    }

    public class Create extends OpenStackRequest<Certificate> {

        public Create(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuffer("/os-certificates").append(id).toString(), null, Certificate.class);
        }

    }

    public class Show extends OpenStackRequest<Certificate> {

        public Show() {
            super(CLIENT, HttpMethod.GET, "/os-certificates", null, Certificate.class);
        }

    }



}