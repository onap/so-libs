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

package com.woorea.openstack.connector;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;

public class JaxRs20Response implements OpenStackResponse {
	
	private Response response;
	
	public JaxRs20Response(Response response) {
		this.response = response;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
		if(response.getStatus() >= 400) {
			throw new OpenStackResponseException(response.getStatusInfo().getReasonPhrase(),
					response.getStatusInfo().getStatusCode(), this);
		}
		return response.readEntity(returnType);
	}

	@Override
	public <T> T getErrorEntity(Class<T> returnType) {
		if(response.getStatus() >= 400 && response.hasEntity()) {
			return response.readEntity(returnType);
		}
		return null;
	}
	

	@Override
	public InputStream getInputStream() {
		return (InputStream) response.getEntity();
	}

	@Override
	public String header(String name) {
		return response.getHeaderString(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaderString(k));
		}
		return headers;
	}

}
