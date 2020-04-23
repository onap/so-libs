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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hypervisor {

    @JsonProperty("cpu_info")
    private String cpuInfo;
    @JsonProperty("current_workload")
    private Integer currentWorkload;
    @JsonProperty("status")
    private String status;
    @JsonProperty("state")
    private String state;
    @JsonProperty("disk_available_least")
    private Integer diskAvailableLeast;
    @JsonProperty("host_ip")
    private String hostIp;
    @JsonProperty("free_disk_gb")
    private Integer freeDiskGb;
    @JsonProperty("free_ram_mb")
    private Integer freeRamMb;
    @JsonProperty("hypervisor_hostname")
    private String hypervisorHostname;
    @JsonProperty("hypervisor_type")
    private String hypervisorType;
    @JsonProperty("hypervisor_version")
    private Integer hypervisorVersion;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("local_gb")
    private Integer localGb;
    @JsonProperty("local_gb_used")
    private Integer localGbUsed;
    @JsonProperty("memory_mb")
    private Integer memoryMb;
    @JsonProperty("memory_mb_used")
    private Integer memoryMbUsed;
    @JsonProperty("running_vms")
    private Integer runningVms;
    @JsonProperty("service")
    private Service service;
    @JsonProperty("vcpus")
    private Integer vcpus;
    @JsonProperty("vcpus_used")
    private Integer vcpusUsed;

    @JsonProperty("cpu_info")
    public String getCpuInfo() {
        return cpuInfo;
    }

    @JsonProperty("cpu_info")
    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    @JsonProperty("current_workload")
    public Integer getCurrentWorkload() {
        return currentWorkload;
    }

    @JsonProperty("current_workload")
    public void setCurrentWorkload(Integer currentWorkload) {
        this.currentWorkload = currentWorkload;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("disk_available_least")
    public Integer getDiskAvailableLeast() {
        return diskAvailableLeast;
    }

    @JsonProperty("disk_available_least")
    public void setDiskAvailableLeast(Integer diskAvailableLeast) {
        this.diskAvailableLeast = diskAvailableLeast;
    }

    @JsonProperty("host_ip")
    public String getHostIp() {
        return hostIp;
    }

    @JsonProperty("host_ip")
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    @JsonProperty("free_disk_gb")
    public Integer getFreeDiskGb() {
        return freeDiskGb;
    }

    @JsonProperty("free_disk_gb")
    public void setFreeDiskGb(Integer freeDiskGb) {
        this.freeDiskGb = freeDiskGb;
    }

    @JsonProperty("free_ram_mb")
    public Integer getFreeRamMb() {
        return freeRamMb;
    }

    @JsonProperty("free_ram_mb")
    public void setFreeRamMb(Integer freeRamMb) {
        this.freeRamMb = freeRamMb;
    }

    @JsonProperty("hypervisor_hostname")
    public String getHypervisorHostname() {
        return hypervisorHostname;
    }

    @JsonProperty("hypervisor_hostname")
    public void setHypervisorHostname(String hypervisorHostname) {
        this.hypervisorHostname = hypervisorHostname;
    }

    @JsonProperty("hypervisor_type")
    public String getHypervisorType() {
        return hypervisorType;
    }

    @JsonProperty("hypervisor_type")
    public void setHypervisorType(String hypervisorType) {
        this.hypervisorType = hypervisorType;
    }

    @JsonProperty("hypervisor_version")
    public Integer getHypervisorVersion() {
        return hypervisorVersion;
    }

    @JsonProperty("hypervisor_version")
    public void setHypervisorVersion(Integer hypervisorVersion) {
        this.hypervisorVersion = hypervisorVersion;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("local_gb")
    public Integer getLocalGb() {
        return localGb;
    }

    @JsonProperty("local_gb")
    public void setLocalGb(Integer localGb) {
        this.localGb = localGb;
    }

    @JsonProperty("local_gb_used")
    public Integer getLocalGbUsed() {
        return localGbUsed;
    }

    @JsonProperty("local_gb_used")
    public void setLocalGbUsed(Integer localGbUsed) {
        this.localGbUsed = localGbUsed;
    }

    @JsonProperty("memory_mb")
    public Integer getMemoryMb() {
        return memoryMb;
    }

    @JsonProperty("memory_mb")
    public void setMemoryMb(Integer memoryMb) {
        this.memoryMb = memoryMb;
    }

    @JsonProperty("memory_mb_used")
    public Integer getMemoryMbUsed() {
        return memoryMbUsed;
    }

    @JsonProperty("memory_mb_used")
    public void setMemoryMbUsed(Integer memoryMbUsed) {
        this.memoryMbUsed = memoryMbUsed;
    }

    @JsonProperty("running_vms")
    public Integer getRunningVms() {
        return runningVms;
    }

    @JsonProperty("running_vms")
    public void setRunningVms(Integer runningVms) {
        this.runningVms = runningVms;
    }

    @JsonProperty("service")
    public Service getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(Service service) {
        this.service = service;
    }

    @JsonProperty("vcpus")
    public Integer getVcpus() {
        return vcpus;
    }

    @JsonProperty("vcpus")
    public void setVcpus(Integer vcpus) {
        this.vcpus = vcpus;
    }

    @JsonProperty("vcpus_used")
    public Integer getVcpusUsed() {
        return vcpusUsed;
    }

    @JsonProperty("vcpus_used")
    public void setVcpusUsed(Integer vcpusUsed) {
        this.vcpusUsed = vcpusUsed;
    }
}
