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

package com.woorea.openstack.ceilometer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.woorea.openstack.base.client.OpenStackRequest;

public abstract class QueriableCeilometerCommand<T,R> extends OpenStackRequest<R> {
	
	protected List<String> fields = new ArrayList<String>();
	
	protected List<String> ops = new ArrayList<String>();
	
	protected List<Serializable> values = new ArrayList<Serializable>();
	
	private T filter(String field, String op, Serializable value) {
		fields.add(field);
		ops.add(op);
		values.add(value);
		return (T) this;
	}
	
	public T lt(String field, Serializable value) {
		return filter(field, "lt", value);
	}
	
	public T le(String field, Serializable value) {
		return filter(field, "le", value);
	}
	
	public T eq(String field, Serializable value) {
		return filter(field, "eq", value);
	}
	
	public T ne(String field, Serializable value) {
		return filter(field, "ne", value);
	}
	
	public T ge(String field, Serializable value) {
		return filter(field, "ge", value);
	}
	
	public T gt(String field, Serializable value) {
		return filter(field, "gt", value);
	}

	/*
	public WebTarget query(WebTarget target) {
		if(fields.size() > 0) {
			target = target.queryParam("q.field", fields.toArray());
			target = target.queryParam("q.op", ops.toArray());
			target = target.queryParam("q.value", values.toArray());
		}
		return target;
	}
	*/
}
