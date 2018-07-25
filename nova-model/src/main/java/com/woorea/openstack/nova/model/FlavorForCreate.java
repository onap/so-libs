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
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("flavor")
public class FlavorForCreate implements Serializable {
    
    private String id;
    
    private String name;
    
    private String vcpus;
    
    private Integer ram;
    
    private String disk;
    
    @JsonProperty("OS-FLV-EXT-DATA:ephemeral")
    private Integer ephemeral;
    
    private String swap;
    
    @JsonProperty("rxtx_factor")
    private Float rxtxFactor;

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
     * @return the vcpus
     */
    public String getVcpus() {
        return vcpus;
    }

    /**
     * @param vcpus the vcpus to set
     */
    public void setVcpus(String vcpus) {
        this.vcpus = vcpus;
    }

    /**
     * @return the ram
     */
    public Integer getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(Integer ram) {
        this.ram = ram;
    }

    /**
     * @return the disk
     */
    public String getDisk() {
        return disk;
    }

    /**
     * @param disk the disk to set
     */
    public void setDisk(String disk) {
        this.disk = disk;
    }

    /**
     * @return the ephemeral
     */
    public Integer getEphemeral() {
        return ephemeral;
    }

    /**
     * @param ephemeral the ephemeral to set
     */
    public void setEphemeral(Integer ephemeral) {
        this.ephemeral = ephemeral;
    }

    /**
     * @return the swap
     */
    public String getSwap() {
        return swap;
    }

    /**
     * @param swap the swap to set
     */
    public void setSwap(String swap) {
        this.swap = swap;
    }

    /**
     * @return the rxtxFactor
     */
    public Float getRxtxFactor() {
        return rxtxFactor;
    }

    /**
     * @param rxtxFactor the rxtxFactor to set
     */
    public void setRxtxFactor(Float rxtxFactor) {
        this.rxtxFactor = rxtxFactor;
    }
    
}
