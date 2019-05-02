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

package com.woorea.openstack.keystone.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("endpoint")
public class Endpoint implements Serializable {

    private String id;

    @JsonProperty("service_id")
    private String serviceId;

    private String region;

    @JsonProperty("publicurl")
    private String publicURL;

    @JsonProperty("internalurl")
    private String internalURL;

    @JsonProperty("adminurl")
    private String adminURL;

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
     * @return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the publicURL
     */
    public String getPublicURL() {
        return publicURL;
    }

    /**
     * @param publicURL the publicURL to set
     */
    public void setPublicURL(String publicURL) {
        this.publicURL = publicURL;
    }

    /**
     * @return the internalURL
     */
    public String getInternalURL() {
        return internalURL;
    }

    /**
     * @param internalURL the internalURL to set
     */
    public void setInternalURL(String internalURL) {
        this.internalURL = internalURL;
    }

    /**
     * @return the adminURL
     */
    public String getAdminURL() {
        return adminURL;
    }

    /**
     * @param adminURL the adminURL to set
     */
    public void setAdminURL(String adminURL) {
        this.adminURL = adminURL;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Endpoint [id=" + id + ", serviceId=" + serviceId + ", region=" + region + ", publicURL=" + publicURL
                + ", internalURL=" + internalURL + ", adminURL=" + adminURL + "]";
    }

}
