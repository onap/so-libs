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

package com.woorea.openstack.glance.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Images implements Iterable<Image>, Serializable {

    @JsonProperty("images")
    private List<Image> list;
    
    @JsonProperty("next")
    private String next;
    
    @JsonProperty("first")
    private String first;
    
    @JsonProperty("schema")
    private String schema;

    /**
     * @return the list
     */
    public List<Image> getList() {
        return list;
    }

    public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	@Override
    public Iterator<Image> iterator() {
        return list.iterator();
    }
    
}
