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
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for List of pools
 */
public class Pools implements Iterable<Pool>, Serializable {

    @JsonProperty("pools")
    private List<Pool> list;

    public List<Pool> getList() {
        return list;
    }

    public void setList(List<Pool> list) {
        this.list = list;
    }

    @Override
    public Iterator<Pool> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Pools [list=" + list + "]";
    }
}
