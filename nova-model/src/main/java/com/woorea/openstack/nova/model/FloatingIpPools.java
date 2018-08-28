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
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.woorea.openstack.nova.model.FloatingIpPools.FloatingIpPool;

public class FloatingIpPools implements Iterable<FloatingIpPool>, Serializable {
    
    public static class FloatingIpPool implements Serializable {

        private String name;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "FloatingIpPool [name=" + name + "]";
        }
        
    }

    @JsonProperty("floating_ip_pools")
    private List<FloatingIpPool> list;

    /**
     * @return the list
     */
    public List<FloatingIpPool> getList() {
        return list;
    }
    
    @Override
    public Iterator<FloatingIpPool> iterator() {
        return list.iterator();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FloatingIpPools [list=" + list + "]";
    }

}
