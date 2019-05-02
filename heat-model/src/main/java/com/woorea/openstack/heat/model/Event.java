
package com.woorea.openstack.heat.model;

import java.util.List;
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"event_time", "id", "links", "logical_resource_id", "physical_resource_id", "resource_name",
        "resource_status", "resource_status_reason"})
public class Event {

    @JsonProperty("event_time")
    private String eventTime;
    @JsonProperty("id")
    private String id;
    @JsonProperty("links")
    private List<Link> links = null;
    @JsonProperty("logical_resource_id")
    private String logicalResourceId;
    @JsonProperty("physical_resource_id")
    private Object physicalResourceId;
    @JsonProperty("resource_name")
    private String resourceName;
    @JsonProperty("resource_status")
    private String resourceStatus;
    @JsonProperty("resource_status_reason")
    private String resourceStatusReason;

    @JsonProperty("event_time")
    public String getEventTime() {
        return eventTime;
    }

    @JsonProperty("event_time")
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonProperty("logical_resource_id")
    public String getLogicalResourceId() {
        return logicalResourceId;
    }

    @JsonProperty("logical_resource_id")
    public void setLogicalResourceId(String logicalResourceId) {
        this.logicalResourceId = logicalResourceId;
    }

    @JsonProperty("physical_resource_id")
    public Object getPhysicalResourceId() {
        return physicalResourceId;
    }

    @JsonProperty("physical_resource_id")
    public void setPhysicalResourceId(Object physicalResourceId) {
        this.physicalResourceId = physicalResourceId;
    }

    @JsonProperty("resource_name")
    public String getResourceName() {
        return resourceName;
    }

    @JsonProperty("resource_name")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @JsonProperty("resource_status")
    public String getResourceStatus() {
        return resourceStatus;
    }

    @JsonProperty("resource_status")
    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    @JsonProperty("resource_status_reason")
    public String getResourceStatusReason() {
        return resourceStatusReason;
    }

    @JsonProperty("resource_status_reason")
    public void setResourceStatusReason(String resourceStatusReason) {
        this.resourceStatusReason = resourceStatusReason;
    }

}
