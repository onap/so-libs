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

package com.woorea.openstack.quantum.model;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Network Extension supporting both Provider networks and Multi-Provider networks. The attributes for both of these
 * network extensions are included. It is the responsibility of users to populate only one or the other. It is also
 * critical that the Mapper is set for serialization inclusion.NON_NULL, or both would be sent to Openstack which would
 * cause an error.
 * 
 */
@SuppressWarnings("serial")
@JsonRootName("network")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("subnets")
    private List<String> subnets;

    @JsonProperty("availability_zones")
    private List<String> availabilityZones;

    @JsonProperty("availability_zone_hints")
    private List<String> availabilityZoneHints;

    @JsonProperty("name")
    private String name;

    @JsonProperty("admin_state_up")
    private Boolean adminStateUp;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("tenant_id")
    private String tenantId;

    @JsonProperty("provider:physical_network")
    private String providerPhysicalNetwork;

    @JsonProperty("provider:network_type")
    private String providerNetworkType;

    @JsonProperty("provider:segmentation_id")
    private Integer providerSegmentationId;

    @JsonProperty("router:external")
    private Boolean routerExternal;

    @JsonProperty("ipv6_address_scope")
    private String ipv6AddressScope;

    @JsonProperty("ipv4_address_scope")
    private String ipv4AddressScope;

    @JsonProperty("revision_number")
    private Integer revisionNumber;

    @JsonProperty("port_security_enabled")
    private Boolean portSecurityEnabled;

    @JsonProperty("mtu")
    private Integer mtu;

    private String id;

    @JsonProperty("shared")
    private Boolean shared;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("description")
    private String description;



    @JsonProperty("is_default")
    private Boolean isDefault;

    private List<Segment> segments;

    @JsonProperty("tags")
    private List<String> tags;

    /**
     * @return the status
     */

    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    @JsonProperty
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the subnets
     */

    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * @param subnets the subnets to set
     */
    @JsonProperty
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
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
     * @return the providerPhyNet
     * @deprecated
     */
    @Deprecated

    public String getProviderPhyNet() {
        return getProviderPhysicalNetwork();
    }

    /**
     * @param providerPhyNet the providerPhyNet to set
     * @deprecated
     */
    @Deprecated

    public void setProviderPhyNet(String providerPhyNet) {
        setProviderPhysicalNetwork(providerPhyNet);
    }

    /**
     * @return the adminStateUp
     */

    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    public Boolean getAdminStateUp() {
        return adminStateUp;
    }

    /**
     * @param adminStateUp the adminStateUp to set
     */
    public void setAdminStateUp(Boolean adminStateUp) {
        this.adminStateUp = adminStateUp;
    }

    /**
     * @return the tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * @param tenantId the tenantId to set
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return the netType
     * @deprecated
     */
    @Deprecated

    public String getNetType() {
        return getProviderNetworkType();
    }

    /**
     * @param netType the netType to set
     * @deprecated
     */
    @Deprecated

    public void setNetType(String netType) {
        setProviderNetworkType(netType);
    }

    /**
     * @return the routerExternal
     */
    public Boolean getRouterExternal() {
        return routerExternal;
    }

    /**
     * @param routerExternal the routerExternal to set
     */
    public void setRouterExternal(Boolean routerExternal) {
        this.routerExternal = routerExternal;
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
    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the shared
     */
    public Boolean getShared() {
        return shared;
    }

    /**
     * @param shared the shared to set
     */
    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    /**
     * @return the providerSegID
     * @deprecated
     */
    @Deprecated

    public String getProviderSegID() {
        return getProviderSegmentationId() == null ? null : Integer.toString(getProviderSegmentationId());
    }

    /**
     * @param providerSegID the providerSegID to set
     * @deprecated
     */
    @Deprecated

    public void setProviderSegID(String providerSegID) {
        setProviderSegmentationId(providerSegID == null ? null : Integer.parseInt(providerSegID));
    }

    public String getProviderNetworkType() {
        return providerNetworkType;
    }

    public void setProviderNetworkType(String providerNetworkType) {
        this.providerNetworkType = providerNetworkType;
    }

    public String getProviderPhysicalNetwork() {
        return providerPhysicalNetwork;
    }

    public void setProviderPhysicalNetwork(String providerPhysicalNetwork) {
        this.providerPhysicalNetwork = providerPhysicalNetwork;
    }

    public Integer getProviderSegmentationId() {
        return providerSegmentationId;
    }

    public void setProviderSegmentationId(Integer providerSegmentationId) {
        this.providerSegmentationId = providerSegmentationId;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    /**
     * Function to detect and return the network type
     */
    public enum NetworkType {
        BASIC, PROVIDER, MULTI_PROVIDER
    };


    public NetworkType getNetworkType() {
        if (segments != null)
            return NetworkType.MULTI_PROVIDER;
        else if (providerNetworkType != null)
            return NetworkType.PROVIDER;
        else
            return NetworkType.BASIC;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("Network [id=" + id + ", name=" + name + ", subnets=" + subnets
                + ", status=" + status + ", admin_state_up=" + adminStateUp + ", tenant_id=" + tenantId + ", shared="
                + shared + ", router:external=" + routerExternal);
        if (getNetworkType() == NetworkType.PROVIDER)
            buf.append(", provider:physical_network=" + providerPhysicalNetwork + ", provider:network_type="
                    + providerNetworkType + ", provider:segmentation_id=" + providerSegmentationId);
        if (getNetworkType() == NetworkType.MULTI_PROVIDER) {
            buf.append(", segments: ");
            for (Segment s : segments)
                buf.append(s.toString()).append(" ");
        }
        buf.append("]");
        return buf.toString();
    }
}
