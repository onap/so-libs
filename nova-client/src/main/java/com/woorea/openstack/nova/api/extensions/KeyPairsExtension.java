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


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.KeyPair;
import com.woorea.openstack.nova.model.KeyPairs;

public class KeyPairsExtension {

    private final OpenStackClient CLIENT;

    public KeyPairsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(String name, String publicKey) {
        KeyPair keyPairForCreate = new KeyPair(name, publicKey);
        return new Create(keyPairForCreate);
    }

    public Create create(String name) {
        return create(name, null);
    }

    public Delete delete(String name) {
        return new Delete(name);
    }

    public class Create extends OpenStackRequest<KeyPair> {

        private KeyPair keyPairForCreate;

        public Create(KeyPair keyPairForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-keypairs", Entity.json(keyPairForCreate), KeyPair.class);
            this.keyPairForCreate = keyPairForCreate;
        }

    }

    public class Delete extends OpenStackRequest<Void> {



        public Delete(String name) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-keypairs/").append(name).toString(), null, Void.class);
        }

    }

    public class List extends OpenStackRequest<KeyPairs> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/os-keypairs", null, KeyPairs.class);
        }

    }

}