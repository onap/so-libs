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

package com.woorea.openstack.quantum.model;

import java.io.Serializable;

public class Routes implements Serializable {

    private String destination;
    private String nexthop;

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the nexthop
     */
    public String getNexthop() {
        return nexthop;
    }

    /**
     * @param nexthop the nexthop to set
     */
    public void setNexthop(String nexthop) {
        this.nexthop = nexthop;
    }

    @Override
    public String toString() {
        return "host_routes [destination=" + destination + ", nexthop=" + nexthop + "]";
    }

}
