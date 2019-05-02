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

package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("volume_type")
public class VolumeTypeForCreate implements Serializable {

    private String name;

    @JsonProperty("extra_specs")
    private Map<String, String> extraSpecs;

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
     * @return the extraSpecs
     */
    public Map<String, String> getExtraSpecs() {
        return extraSpecs;
    }

    /**
     * @param extraSpecs the extra_specs to set
     */
    public void setExtraSpecs(Map<String, String> extraSpecs) {
        this.extraSpecs = extraSpecs;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VolumeForCreate [name=" + name + ", metadata=" + extraSpecs + "]";
    }

}
