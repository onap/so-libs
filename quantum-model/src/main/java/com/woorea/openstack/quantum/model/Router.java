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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName("router")
public class Router implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("external_gateway_info")
    private GatewayInfo externalGatewayInfo;

    @JsonProperty("name")
    private String name;

    @JsonProperty("admin_state_up")
    private String admin_state_up;

    @JsonProperty("tenant_id")
    private String tenantId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("routes")
    private List<HostRoute> routes;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<HostRoute> getRoutes() {
        return routes;
    }
    public void setRoutes(List<HostRoute> routes) {
        this.routes = routes;
    }
    public String getAdmin_state_up() {
        return admin_state_up;
    }
    public void setAdmin_state_up(String admin_state_up) {
        this.admin_state_up = admin_state_up;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public GatewayInfo getExternalGatewayInfo() {
        return externalGatewayInfo;
    }
    public void setExternalGatewayInfo(GatewayInfo externalGatewayInfo) {
        this.externalGatewayInfo = externalGatewayInfo;
    }
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    

}
