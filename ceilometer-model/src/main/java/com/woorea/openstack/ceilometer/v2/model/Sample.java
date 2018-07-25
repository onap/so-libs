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

package com.woorea.openstack.ceilometer.v2.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class Sample {

    @JsonProperty("counter_type")
    private String counterType;

    @JsonProperty("counter_name")
    private String counterName;
    
    @JsonProperty("counter_unit")
    private String counterUnit;
    
    @JsonProperty("counter_volume")
    private String counterVolume;
    
    private String source;
    
    @JsonProperty("project_id")
    private String project;
    
    @JsonProperty("user_id")
    private String user;
    
    @JsonProperty("resource_id")
    private String resource;
    
    private String timestamp;
    
    @JsonProperty("message_id")
    private String message;
    
    @JsonProperty("resource_metadata")
    private Map<String, Object> metadata;

    public String getCounterType() {
        return counterType;
    }

    public String getCounterName() {
        return counterName;
    }

    public String getCounterUnit() {
        return counterUnit;
    }

    public String getCounterVolume() {
        return counterVolume;
    }

    public String getSource() {
        return source;
    }

    public String getProject() {
        return project;
    }

    public String getUser() {
        return user;
    }

    public String getResource() {
        return resource;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "Sample [counterType=" + counterType + ", counterName="
                + counterName + ", counterUnit=" + counterUnit
                + ", counterVolume=" + counterVolume + ", source=" + source
                + ", project=" + project + ", user=" + user + ", resource="
                + resource + ", timestamp=" + timestamp + ", message="
                + message + ", metadata=" + metadata + "]";
    }
    
}
