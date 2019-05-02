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
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("connection_info")
public class ConnectionInfo implements Serializable {

    @JsonProperty("driver_volume_type")
    private String driverVolumeType;

    private Map<String, Object> data;

    /**
     * @return the driverVolumeType
     */
    public String getDriverVolumeType() {
        return driverVolumeType;
    }

    /**
     * @param driverVolumeType
     *            the driverVolumeType to set
     */
    public void setDriverVolumeType(String driverVolumeType) {
        this.driverVolumeType = driverVolumeType;
    }

    /**
     * @return the data
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConnectionInfo [driverVolumeType=" + driverVolumeType + "," +
                " data=" + data + "]";
    }

}
