/* ============LICENSE_START=======================================================
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("snapshot")
public class SnapshotForCreate implements Serializable {

    @JsonProperty("volume_id")
    private String volumeId;

    private Boolean force;

    private String name;

    private String description;

    /**
     * @return the volumeId
     */
    public String getVolumeId() {
        return volumeId;
    }

    /**
     * @param volumeId
     *            the volumeId to set
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    /**
     * @return the force
     */
    public Boolean getForce() {
        return force;
    }

    /**
     * @param force
     *            the force to set
     */
    public void setForce(Boolean force) {
        this.force = force;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SnapshotForCreate [volumeId=" + volumeId + ", force=" + force
                + ", name=" + name + ", description=" + description + "]";
    }

}
