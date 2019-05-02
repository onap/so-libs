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

package com.woorea.openstack.keystone.model.authentication;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.woorea.openstack.keystone.model.Authentication;

@JsonRootName("auth")
public class AccessKey extends Authentication {

    public static final class ApiAccessKeyCredentials {

        private String accessKey;

        private String secretKey;

        /**
         * @return the accessKey
         */
        public String getAccessKey() {
            return accessKey;
        }

        /**
         * @param accessKey the accessKey to set
         */
        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        /**
         * @return the secretKey
         */
        public String getSecretKey() {
            return secretKey;
        }

        /**
         * @param secretKey the secretKey to set
         */
        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

    }

    private ApiAccessKeyCredentials apiAccessKeyCredentials = new ApiAccessKeyCredentials();

    public AccessKey() {

    }

    public AccessKey(String accessKey, String secretKey) {
        apiAccessKeyCredentials.setAccessKey(accessKey);
        apiAccessKeyCredentials.setSecretKey(secretKey);
    }

    /**
     * @return the apiAccessKeyCredentials
     */
    public ApiAccessKeyCredentials getApiAccessKeyCredentials() {
        return apiAccessKeyCredentials;
    }

    /**
     * @param apiAccessKeyCredentials the apiAccessKeyCredentials to set
     */
    public void setApiAccessKeyCredentials(ApiAccessKeyCredentials apiAccessKeyCredentials) {
        this.apiAccessKeyCredentials = apiAccessKeyCredentials;
    }

}
