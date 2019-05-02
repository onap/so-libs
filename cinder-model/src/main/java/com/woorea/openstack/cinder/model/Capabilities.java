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
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Model for Volume
 */
@JsonRootName("capabilities")
public class Capabilities implements Serializable {

    @JsonProperty("pool_name")
    private String poolName;
    @JsonProperty("QoS_support")
    private boolean qosSupport;
    @JsonProperty("allocated_capacity_gb")
    private Long allocatedCapacityGb;
    @JsonProperty("driver_version")
    private String driverVersion;
    @JsonProperty("free_capacity_gb")
    private Long freeCapacityGb;
    @JsonProperty("location_info")
    private String locationInfo;

    private String timestamp;
    @JsonProperty("volume_backend_name")
    private String volumeBackendName;
    @JsonProperty("total_capacity_gb")
    private Long totalCapacityGb;
    @JsonProperty("reserved_percentage")
    private Integer reservedPercentage;
    @JsonProperty("vendor_name")
    private String vendorName;
    @JsonProperty("storage_protocol")
    private String storageProtocol;
    @JsonProperty("extra_specs")
    private Map<String, String> extraSpecs;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public boolean isQosSupport() {
        return qosSupport;
    }

    public void setQosSupport(boolean qosSupport) {
        this.qosSupport = qosSupport;
    }

    public Long getAllocatedCapacityGb() {
        return allocatedCapacityGb;
    }

    public void setAllocatedCapacityGb(Long allocatedCapacityGb) {
        this.allocatedCapacityGb = allocatedCapacityGb;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public Long getFreeCapacityGb() {
        return freeCapacityGb;
    }

    public void setFreeCapacityGb(Long freeCapacityGb) {
        this.freeCapacityGb = freeCapacityGb;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVolumeBackendName() {
        return volumeBackendName;
    }

    public void setVolumeBackendName(String volumeBackendName) {
        this.volumeBackendName = volumeBackendName;
    }

    public Long getTotalCapacityGb() {
        return totalCapacityGb;
    }

    public void setTotalCapacityGb(Long totalCapacityGb) {
        this.totalCapacityGb = totalCapacityGb;
    }

    public Integer getReservedPercentage() {
        return reservedPercentage;
    }

    public void setReservedPercentage(Integer reservedPercentage) {
        this.reservedPercentage = reservedPercentage;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getStorageProtocol() {
        return storageProtocol;
    }

    public void setStorageProtocol(String storageProtocol) {
        this.storageProtocol = storageProtocol;
    }

    public Map<String, String> getExtraSpecs() {
        return extraSpecs;
    }

    public void setExtraSpecs(Map<String, String> extraSpecs) {
        this.extraSpecs = extraSpecs;
    }

    @Override
    public String toString() {
        return "Capabilities{" + "poolName='" + poolName + ", qosSupport='" + qosSupport + ", allocatedCapacityGb='"
                + allocatedCapacityGb + ", driverVersion='" + driverVersion + ", freeCapacityGb='" + freeCapacityGb
                + ", locationInfo='" + locationInfo + ", timestamp='" + timestamp + ", volumeBackendName='"
                + volumeBackendName + ", totalCapacityGb='" + totalCapacityGb + ", reservedPercentage='"
                + reservedPercentage + ", vendorName='" + vendorName + ", storageProtocol='" + storageProtocol
                + ", extraSpecs='" + extraSpecs + '}';
    }
}
