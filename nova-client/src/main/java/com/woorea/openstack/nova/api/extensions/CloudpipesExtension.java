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
import com.woorea.openstack.nova.model.Cloudpipe;
import com.woorea.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
    
    private final OpenStackClient CLIENT;
    
    public CloudpipesExtension(OpenStackClient client) {
        CLIENT = client;
    }
    
    public List list() {
        return new List();
    }
    
    public Create create(Cloudpipe cloudpipe) {
        return new Create(cloudpipe);
    }
    
    public class List extends OpenStackRequest<Cloudpipes> {

        
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-cloudpipes", null, Cloudpipes.class);
        }

    }

    public class Create extends OpenStackRequest<Cloudpipe> {

        private Cloudpipe cloudpipe;
        
        public Create(Cloudpipe cloudpipe) {
            super(CLIENT, HttpMethod.POST, "/os-cloudpipes", Entity.json(cloudpipe), Cloudpipe.class);
            this.cloudpipe = cloudpipe;
        }

    }

    
    
}
