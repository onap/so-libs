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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("floating_ip")
public class FloatingIp implements Serializable {

    private String id;

    private String pool;

    private String ip;

    @JsonProperty("fixed_ip")
    private String fixedIp;

    @JsonProperty("instance_id")
    private String instanceId;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the pool
     */
    public String getPool() {
        return pool;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the fixedIp
     */
    public String getFixedIp() {
        return fixedIp;
    }

    /**
     * @return the instanceId
     */
    public String getInstanceId() {
        return instanceId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FloatingIp [id=" + id + ", pool=" + pool + ", ip=" + ip + ", fixedIp=" + fixedIp + ", instanceId="
                + instanceId + "]";
    }

}
