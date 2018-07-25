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

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("snapshot")
public class Snapshot implements Serializable {

    private String id;
    
    private String status;
    
    @JsonProperty("displayName")
    private String name;
    
    @JsonProperty("displayDescription")
    private String description;
    
    private String volumeId;
    
    private Integer size;
    
    private String createdAt;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the volumeId
     */
    public String getVolumeId() {
        return volumeId;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Snapshot [id=" + id + ", status=" + status + ", displayName="
                + name + ", displayDescription=" + description
                + ", volumeId=" + volumeId + ", size=" + size + ", createdAt="
                + createdAt + "]";
    }
    
}
