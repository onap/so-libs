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

import java.util.Map;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.swift.model.ObjectDownload;
import com.woorea.openstack.swift.model.ObjectForUpload;

public class ContainerResource {
    
    private final OpenStackClient CLIENT;
    
    private String container;
    
    public ContainerResource(OpenStackClient client, String container) {
        CLIENT = client;
        this.container = container;
    }
    
    public List list() {
        return new List(container, null);
    }
    
    public CreateDirectory createDirectory(String path) {
        return new CreateDirectory(container, path);
    }
    
    public Show show(String path) {
        return new Show(container, path);
    }
    
    public Upload upload(ObjectForUpload objectForUpload) {
        return new Upload(objectForUpload);
    }
    
    public Download download(String path) {
        return new Download(container, path);
    }
    
    public Delete delete(String path) {
        return new Delete(container, path);
    }
    
    public class List extends OpenStackRequest<java.util.List<Object>> {

        private String containerName;
        
        private Map<String, String> filters;
        
        public List(String containerName, Map<String, String> filters) {
            this.containerName = containerName;
            this.filters = filters;
        }
        
    }

    public class CreateDirectory extends OpenStackRequest<Void> {

        private String container;
        
        private String path;
        
        public CreateDirectory(String container, String path) {
            this.container = container;
            this.path = path;
        }
        
    }
    
    public class Show extends OpenStackRequest<Object> {

        private String containerName;
        
        private String objectName;
        
        public Show(String containerName, String objectName) {
            this.containerName = containerName;
            this.objectName = objectName;

        }

    }
    
    public class Upload extends OpenStackRequest<OpenStackResponse> {

        private ObjectForUpload objectForUpload;
        
        public Upload(ObjectForUpload objectForUpload) {
            this.objectForUpload = objectForUpload;

        }

    }
    
    public class Download extends OpenStackRequest<ObjectDownload> {

        private String containerName;
        
        private String objectName;
        
        public Download(String containerName, String objectName) {
            this.containerName = containerName;
            this.objectName = objectName;
        }

    }

    
    public class Delete extends OpenStackRequest<Void> {

        private String containerName;
        
        private String objectName;
        
        public Delete(String containerName, String objectName) {
            this.containerName = containerName;
            this.objectName = objectName;
        }

    }

}
