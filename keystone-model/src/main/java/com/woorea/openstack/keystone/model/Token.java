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

package com.woorea.openstack.keystone.model;

import java.util.Calendar;

public final class Token {

    private String id;

    private Calendar issued_at;

    private Calendar expires;

    private Tenant tenant;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the issued_at
     */
    public Calendar getIssued_at() {
        return issued_at;
    }

    /**
     * @return the expires
     */
    public Calendar getExpires() {
        return expires;
    }

    /**
     * @return the tenant
     */
    public Tenant getTenant() {
        return tenant;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Token [id=" + id + ", Issued_at=" + issued_at + ", expires=" + expires + ", tenant=" + tenant + "]";
    }

}
