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

import com.sun.jersey.api.client.ClientResponse;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;

public class JerseyResponse implements OpenStackResponse {

	private ClientResponse response;

	public JerseyResponse(ClientResponse response) {
		this.response = response;
	}

	@Override
	public <T> T getEntity(Class<T> returnType) {
		if(response.getStatus() >= 400) {
			throw new OpenStackResponseException(response.getClientResponseStatus().getReasonPhrase(), 
					response.getStatus(), this);
		}
		if(response.hasEntity() && returnType != null && Void.class != returnType) {
			return response.getEntity(returnType);
		} else {
			return null;
		}
	}

	@Override
	public <T> T getErrorEntity(Class<T> returnType) {
		if(response.getStatus() >= 400 && response.hasEntity()) {
			return response.getEntity(returnType);
		}
		return null;
	}

	@Override
	public InputStream getInputStream() {
		if(response.hasEntity()) {
			return response.getEntityInputStream();
		} else {
			return null;
		}
	}

	@Override
	public String header(String name) {
		return response.getHeaders().getFirst(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaders().getFirst(k));
		}
		return headers;
	}
}
