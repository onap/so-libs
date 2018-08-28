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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyPairs implements Iterable<KeyPair>, Serializable {
    
    public static final class KeyPairWrapper implements Serializable {
        
        @JsonProperty
        private KeyPair keypair;
        
    }

    @JsonProperty("keypairs")
    private List<KeyPairWrapper> list;

    /**
     * @return the list
     */
    public List<KeyPair> getList() {
        List<KeyPair> keyPairList = new ArrayList<>();
        for(KeyPairWrapper wrapper : this.list) {
            keyPairList.add(wrapper.keypair);
        }
        return keyPairList;
    }
    
    @Override
    public Iterator<KeyPair> iterator() {
        return getList().iterator();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "KeyPairs [list=" + getList() + "]";
    }

}
