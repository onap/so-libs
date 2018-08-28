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

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Host implements Serializable {
    
    public static final class ResourceWrapper implements Serializable {
        
        public static final class Resource implements Serializable {
            
            private String project;
            
            @JsonProperty("memory_mb")
            private Integer memoryMb;
            
            private String host;
            
            private Integer cpu;
            
            @JsonProperty("disk_gb")
            private Integer diskGb;

            /**
             * @return the project
             */
            public String getProject() {
                return project;
            }

            /**
             * @return the memoryMb
             */
            public Integer getMemoryMb() {
                return memoryMb;
            }

            /**
             * @return the host
             */
            public String getHost() {
                return host;
            }

            /**
             * @return the cpu
             */
            public Integer getCpu() {
                return cpu;
            }

            /**
             * @return the diskGb
             */
            public Integer getDiskGb() {
                return diskGb;
            }

            /* (non-Javadoc)
             * @see java.lang.Object#toString()
             */
            @Override
            public String toString() {
                return "Resource [project=" + project + ", memoryMb="
                        + memoryMb + ", host=" + host + ", cpu=" + cpu
                        + ", diskGb=" + diskGb + "]";
            }
            
        }
        
        private Resource resource;

        /**
         * @return the resource
         */
        public Resource getResource() {
            return resource;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "ResourceWrapper [resource=" + resource + "]";
        }
        
    }

    private List<ResourceWrapper> host;

    /**
     * @return the host
     */
    public List<ResourceWrapper> getHost() {
        return host;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Host [host=" + host + "]";
    }
    
}
