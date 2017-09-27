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

package com.woorea.openstack.common.client;
//package org.openstack.common.client;
//
//import java.io.IOException;
//import java.util.logging.Logger;
//
//import javax.ws.rs.client.ClientRequestContext;
//import javax.ws.rs.client.ClientRequestFilter;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//
//import org.glassfish.jersey.filter.LoggingFilter;
//import org.openstack.connector.OpenStack;
//
//public class AbstractOpenStackClient {
//
//	protected String endpointURL;
//	
//	protected String token;
//	
//	protected LoggingFilter loggingFilter;
//	
//	protected ClientRequestFilter tokenFilter = new ClientRequestFilter() {
//		
//		@Override
//		public void filter(ClientRequestContext requestContext) throws IOException {
//			requestContext.getHeaders().putSingle("X-Auth-Token", token);
//		}
//	};
//
//	public AbstractOpenStackClient(String endpointURL, String token) {
//		this.endpointURL = endpointURL;
//		this.token = token;
//	}
//	
//	public AbstractOpenStackClient(String endpointURL) {
//		this(endpointURL, null);
//	}
//
//	/**
//	 * @param token the token to set
//	 */
//	public void setToken(String token) {
//		this.token = token;
//	}
//	
//	public OpenStackRequest request(String uri, String... mediaTypes) {
//		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
//		if(token != null) {
//			endpoint.register(tokenFilter);
//		}
//		return new OpenStackRequest(endpoint.path(uri).request(mediaTypes));
//	}
//	
//	public OpenStackRequest request(String uri) {
//		return request(uri, MediaType.APPLICATION_JSON);
//	}
//	
//	protected WebTarget create(String endpoint) {
//		WebTarget target = OpenStack.CLIENT.target(endpoint);
//		if(loggingFilter != null) {
//			target.register(loggingFilter);
//		}
//		if(token != null) {
//			target.register(tokenFilter);
//		}
//		return target;
//	}
//	
//	public void enableLogging(Logger logger, int entitySize) {
//		loggingFilter = new LoggingFilter(logger, entitySize);
//	}
//	
//	public void disableLogging() {
//		loggingFilter = null;
//	}
//	
//	public static class OpenStackRequest {
//		
//		private Builder builder;
//		
//		private OpenStackRequest(Builder builder) {
//			this.builder = builder;
//		}
//		
//		public <ResponseType> ResponseType execute(String method, Class<ResponseType> type) {
//			return builder.method(method, type);
//		}
//		
//		public <RequestType, ResponseType> ResponseType execute(String method, Entity<RequestType> data, Class<ResponseType> type) {
//			return builder.method(method, data, type);
//		}
//		
//		public void execute(String method) {
//			builder.method(method);
//		}
//		
//		public <RequestType> void execute(String method, Entity<RequestType> data) {
//			builder.method(method, data, Void.class);
//		}
//		
//		public <ResponseType> ResponseType get(Class<ResponseType> type) {
//			return execute("GET", type);
//		}
//		
//		public <ResponseType> ResponseType postJson(Object data, Class<ResponseType> type) {
//			return execute("POST", Entity.json(data), type);
//		}
//		
//		public <ResponseType> ResponseType putJson(Object data, Class<ResponseType> type) {
//			return execute("PUT", Entity.json(data), type);
//		}
//		
//		public <ResponseType> ResponseType patchJson(Object data, Class<ResponseType> type) {
//			return execute("PATCH", Entity.json(data), type);
//		}
//		
//		public void delete() {
//			execute("DELETE", Void.class);
//		}
//	}
//
//}
