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

package com.woorea.openstack.swift.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Container implements Serializable {

    private String name;

    @JsonProperty("count")
    private Integer objectCount;

    @JsonProperty("bytes")
    private Long bytesUsed;

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
     * @return the objectCount
     */
    public Integer getObjectCount() {
        return objectCount;
    }

    /**
     * @param objectCount the objectCount to set
     */
    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    /**
     * @return the bytesUsed
     */
    public Long getBytesUsed() {
        return bytesUsed;
    }

    /**
     * @param bytesUsed the bytesUsed to set
     */
    public void setBytesUsed(Long bytesUsed) {
        this.bytesUsed = bytesUsed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Container [name=" + name + ", objectCount=" + objectCount + ", bytesUsed=" + bytesUsed + "]";
    }



}
