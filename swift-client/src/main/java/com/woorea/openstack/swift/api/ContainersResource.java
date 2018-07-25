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

package com.woorea.openstack.swift.api;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.swift.model.Container;

public class ContainersResource {
    
    private final OpenStackClient CLIENT;
    
    public ContainersResource(OpenStackClient client) {
        CLIENT = client;
    }
    
    public List list() {
        return new List();
    }
    
    public Create create(String name) {
        return new Create(name);
    }
    
    public Show show(String name) {
        return new Show(name);
    }
    
    public Delete delete(String name) {
        return new Delete(name);
    }
    
    public ContainerResource container(String name) {
        return new ContainerResource(CLIENT, name);
    }
    
    public class List extends OpenStackRequest<java.util.List<Container>> {

        public List() {
            //return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Container>>(){});
        }

    }


    public class Create extends OpenStackRequest<Container> {
        
        public Create(String containerName) {
            //return target.path(containerName).request().method("PUT",Entity.text("*"));
        }

    }
    
    public class Show extends OpenStackRequest<Container> {

        private String containerName;
        
        public Show(String containerName) {
//            return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
        }

    }
    
    public class Delete extends OpenStackRequest<Void> {

        private String containerName;
        
        public Delete(String containerName) {
            this.containerName = containerName;
            //return target.path(containerName).request(MediaType.APPLICATION_JSON).delete();
        }

    }
    
}
