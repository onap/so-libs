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

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("floating-ip-pool")
public class FloatingIpDomain implements Serializable {

    private String domain;
    
    private String scope;
    
    private String project;
    
    @JsonProperty("availabilityZone")
    private String availabilityZone;

    /**
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @return the project
     */
    public String getProject() {
        return project;
    }

    /**
     * @return the availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FloatingIpDomain [domain=" + domain + ", scope=" + scope
                + ", project=" + project + ", availabilityZone="
                + availabilityZone + "]";
    }
    
}
