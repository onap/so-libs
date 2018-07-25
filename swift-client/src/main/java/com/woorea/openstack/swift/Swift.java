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

package com.woorea.openstack.swift;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.swift.api.AccountResource;
import com.woorea.openstack.swift.api.ContainersResource;

public class Swift extends OpenStackClient {
    
    private final AccountResource ACCOUNT;
    
    private final ContainersResource CONTAINERS;
    
    public Swift(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        CONTAINERS = new ContainersResource(this);
        ACCOUNT = new AccountResource(this);
    }
    
    public Swift(String endpoint) {
        this(endpoint, null);
    }
    
    public ContainersResource containers() {
        return CONTAINERS;
    }
    
    public AccountResource account() {
        return ACCOUNT;
    }

}
