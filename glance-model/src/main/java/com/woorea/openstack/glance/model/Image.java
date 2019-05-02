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

package com.woorea.openstack.glance.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("image")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

    @JsonProperty("id")
    private String id;

    private String uri;

    private String name;

    @JsonProperty("disk_format")
    private String diskFormat;

    @JsonProperty("container_format")
    private String containerFormat;

    private Long size;

    @JsonProperty("virtual_size")
    private Long virtualSize;

    @JsonProperty("checksum")
    private String checksum;

    @JsonProperty("created_at")
    private Calendar createdAt;

    @JsonProperty("updated_at")
    private Calendar updatedAt;

    @JsonProperty("deleted_at")
    private Calendar deletedAt;

    private String status;

    @JsonProperty("is_public")
    private boolean isPublic;

    @JsonProperty("min_ram")
    private Integer minRam;

    @JsonProperty("min_disk")
    private Integer minDisk;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("deleted")
    private boolean isDeleted;

    @JsonProperty("protected")
    private boolean isProtected;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("file")
    private String file;

    @JsonProperty("schema")
    private String schema;

    @JsonProperty("self")
    private String self;

    @JsonProperty("hw_cdrom_bus")
    private String hwCDROMBus;

    @JsonProperty("hw_disk_bus")
    private String hwDiskBus;

    @JsonProperty("hw_vif_mode")
    private String hwVIFMode;

    @JsonProperty("post_processing_networking")
    private String postProcessingNetworking;

    @JsonProperty("post_processing_tools")
    private String postProccesingTools;

    @JsonProperty("bypass_meta_validation")
    private String bypassMetaValidation;

    @JsonProperty("application_name")
    private String applicationName;

    @JsonProperty("application_type")
    private String applicationType;

    @JsonProperty("application_version")
    private String applicationVersion;

    @JsonProperty("application_vendor")
    private String applicationVendor;

    @JsonProperty("hw_scsi_model")
    private String hwSCSIModel;

    @JsonProperty("description")
    private String description;

    @JsonProperty("meta")
    private String meta;

    @JsonProperty("tags")
    private List<String> tags;

    private Map<String, Object> properties;

    public String getHwCDROMBus() {
        return hwCDROMBus;
    }

    public void setHwCDROMBus(String hwCDROMBus) {
        this.hwCDROMBus = hwCDROMBus;
    }

    public String getHwDiskBus() {
        return hwDiskBus;
    }

    public void setHwDiskBus(String hwDiskBus) {
        this.hwDiskBus = hwDiskBus;
    }

    public String getHwVIFMode() {
        return hwVIFMode;
    }

    public void setHwVIFMode(String hwVIFMode) {
        this.hwVIFMode = hwVIFMode;
    }

    public String getPostProcessingNetworking() {
        return postProcessingNetworking;
    }

    public void setPostProcessingNetworking(String postProcessingNetworking) {
        this.postProcessingNetworking = postProcessingNetworking;
    }

    public String getPostProccesingTools() {
        return postProccesingTools;
    }

    public void setPostProccesingTools(String postProccesingTools) {
        this.postProccesingTools = postProccesingTools;
    }

    public String getBypassMetaValidation() {
        return bypassMetaValidation;
    }

    public void setBypassMetaValidation(String bypassMetaValidation) {
        this.bypassMetaValidation = bypassMetaValidation;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplicationVendor() {
        return applicationVendor;
    }

    public void setApplicationVendor(String applicationVendor) {
        this.applicationVendor = applicationVendor;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the diskFormat
     */
    public String getDiskFormat() {
        return diskFormat;
    }

    /**
     * @param diskFormat the diskFormat to set
     */
    public void setDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
    }

    /**
     * @return the containerFormat
     */
    public String getContainerFormat() {
        return containerFormat;
    }

    /**
     * @param containerFormat the containerFormat to set
     */
    public void setContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
    }

    /**
     * @return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * @return the virtual size
     */
    public Long getVirtualSize() {
        return virtualSize;
    }

    /**
     * @param virtualSize the virtual size to set
     */
    public void setVirtualSize(Long virtualSize) {
        this.virtualSize = virtualSize;
    }

    /**
     * @return the checksum
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * @param checksum the checksum to set
     */
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    /**
     * @return the createdAt
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the deletedAt
     */
    public Calendar getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt the deletedAt to set
     */
    public void setDeletedAt(Calendar deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the isPublic
     */
    public boolean isPublic() {
        return isPublic;
    }

    /**
     * @param isPublic the isPublic to set
     */
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the minRam
     */
    public Integer getMinRam() {
        return minRam;
    }

    /**
     * @param minRam the minRam to set
     */
    public void setMinRam(Integer minRam) {
        this.minRam = minRam;
    }

    /**
     * @return the minDisk
     */
    public Integer getMinDisk() {
        return minDisk;
    }

    /**
     * @param minDisk the minDisk to set
     */
    public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the isDeleted
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the isProtected
     */
    public boolean isProtected() {
        return isProtected;
    }

    /**
     * @param isProtected the isProtected to set
     */
    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }

    /**
     * @return the properties
     */
    public Map<String, Object> getProperties() {
        if (properties == null) {
            properties = new HashMap<>();
        }
        return properties;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Image [id=%s, uri=%s, name=%s, diskFormat=%s containerFormat=%s, size=%d, checksum=%s,"
                + " createdAt=%s, updatedAt=%s, deletedAt=%s, status=%s, isPublic=%s, minRam=%d, minDisk=%d, owner=%s,"
                + " isDeleted=%s, isProtected=%s, properties=%s]", id, uri, name, diskFormat, containerFormat, size,
                checksum, createdAt, updatedAt, deletedAt, status, isPublic, minRam, minDisk, owner, isDeleted,
                isProtected, properties);
    }
}
