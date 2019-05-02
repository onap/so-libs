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

public class Account implements Serializable {

    private Integer containerCount;

    private Integer objectCount;

    private Integer bytesUsed;

    /**
     * @return the containerCount
     */
    public Integer getContainerCount() {
        return containerCount;
    }

    /**
     * @param containerCount the containerCount to set
     */
    public void setContainerCount(Integer containerCount) {
        this.containerCount = containerCount;
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
    public Integer getBytesUsed() {
        return bytesUsed;
    }

    /**
     * @param bytesUsed the bytesUsed to set
     */
    public void setBytesUsed(Integer bytesUsed) {
        this.bytesUsed = bytesUsed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account [containerCount=" + containerCount + ", objectCount=" + objectCount + ", bytesUsed=" + bytesUsed
                + "]";
    }

}
