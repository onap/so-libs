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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Please use {@link Subnet} directly.
 * @Deprecated
 */
@SuppressWarnings("serial")
@JsonRootName("subnet")
@Deprecated
public class SubnetForCreate extends Subnet {

    /**
     * @return the ipVersion
     * @deprecated
     */
    @Deprecated
    @JsonIgnore
    public int getIpVersion() {
        return getIpversion().code();
    }

    /**
     * @param ipVersion
     *            the ipVersion to set
     * @deprecated
     */
    @Deprecated
    @JsonIgnore
    public void setIpVersion(int ipVersion) {
        setIpversion(IpVersion.valueOf(ipVersion));
    }
}
