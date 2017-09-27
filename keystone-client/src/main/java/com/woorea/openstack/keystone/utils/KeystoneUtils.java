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

package com.woorea.openstack.keystone.utils;

import com.woorea.openstack.keystone.model.Access.Service;
import java.util.List;

public class KeystoneUtils {

    private KeystoneUtils() {
    }

    public static String findEndpointURL(List<Service> serviceCatalog, String type, String region, String facing) {
        for (Service service : serviceCatalog) {
            if (type.equals(service.getType())) {
                for (Service.Endpoint endpoint : service.getEndpoints()) {
                    String url = handleServiceEndPoints(endpoint, region, facing);
                    if (url != null) {
                        return url;
                    }
                }
            }
        }
        throw new RuntimeException("endpoint url not found");
    }

    private static String handleServiceEndPoints(Service.Endpoint endpoint, String region, String facing) {
        if (region == null || region.equals(endpoint.getRegion())) {
            switch (facing) {
                case "public":
                    return endpoint.getPublicURL();
                case "internal":
                    return endpoint.getInternalURL();
                case "admin":
                    return endpoint.getAdminURL();
                default:
                    return null;
            }
        }
        return null;
    }
}
