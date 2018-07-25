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
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume")
public class Volume implements Serializable {

    private String id;
    
    private String status;
    
    @JsonProperty("displayName")
    private String name;
    
    @JsonProperty("displayDescription")
    private String description;
    
    private String availabilityZone;

    private String volumeType;
    
    private String snapshotId;
    
    private List<Map<String, Object>> attachments;
    
    private Map<String, String> metadata;
    
    private String createdAt;
    
    private Integer size;

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
     * @return the availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * @return the volumeType
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * @return the snapshotId
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * @return the attachments
     */
    public List<Map<String, Object>> getAttachments() {
        return attachments;
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    
    
}
