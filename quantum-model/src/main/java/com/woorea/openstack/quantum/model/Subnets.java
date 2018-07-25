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
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Subnets implements Serializable, Iterable<Subnet> {
    
    @JsonProperty("subnets")
    private List<Subnet> list;
    
    /**
     * @return the list
     */
    public List<Subnet> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Subnet> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Subnets [list=" + list + "]";
    }
    
    @Override
    public Iterator<Subnet> iterator() {
        return list.iterator();
    }

}
