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

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.woorea.openstack.keystone.model.Authentication;

@JsonRootName("auth")
public class UsernamePassword extends Authentication {
    
    public static final class PasswordCredentials {
        
        private String username;
        
        private String password;

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }
        
    }
    
    private PasswordCredentials passwordCredentials = new PasswordCredentials();
    
    public UsernamePassword() {
        
    }
    
    public UsernamePassword(String username, String password) {
        passwordCredentials.setUsername(username);
        passwordCredentials.setPassword(password);
    }

    /**
     * @return the passwordCredentials
     */
    public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

    /**
     * @param passwordCredentials the passwordCredentials to set
     */
    public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
    }
    
}
