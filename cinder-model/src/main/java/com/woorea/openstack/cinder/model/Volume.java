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


package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("volume")
public class Volume implements Serializable {

    private String id;

    private String status;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("availability_zone")
    private String availabilityZone;

    @JsonProperty("volume_type")
    private String volumeType;

    @JsonProperty("bootable")
    private String bootable;

    @JsonProperty("os-vol-host-attr:host")
    private String osVolhostAttribute;

    @JsonProperty("os-vol-tenant-attr:tenant_id")
    private String tenantId;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("source_volid")
    private String sourceVolid;

    private List<Link> links;

    private List<Map<String, Object>> attachments;

    private Map<String, String> metadata;

    @JsonProperty("created_at")
    private Date createdAt;

    private Integer size;

    public String getBootable() {
        return bootable;
    }

    public void setBootable(String bootable) {
        this.bootable = bootable;
    }

    public String getOsVolhostAttribute() {
        return osVolhostAttribute;
    }

    public void setOsVolhostAttribute(String osVolhostAttribute) {
        this.osVolhostAttribute = osVolhostAttribute;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSourceVolid() {
        return sourceVolid;
    }

    public void setSourceVolid(String sourceVolid) {
        this.sourceVolid = sourceVolid;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public void setAttachments(List<Map<String, Object>> attachments) {
        this.attachments = attachments;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

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
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }



}
