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
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseConnection implements Serializable {
    @JsonProperty("connector")
    private Map<String, Object> connector = new HashMap<String, Object>();

    /**
     * @return the connector
     */
    public Map<String, Object> getConnector() {
        return connector;
    }

    /**
     * @param connector the connector to set
     */
    public void setConnector(Map<String, Object> connector) {
        this.connector = connector;
    }

}
