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

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import com.woorea.openstack.base.client.OpenStackResponse;

import javax.ws.rs.core.MultivaluedMap;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RESTEasyResponse implements OpenStackResponse {

    private ClientRequest client;

    private ClientResponse response;

    public RESTEasyResponse(ClientRequest client, ClientResponse response) {
        this.client = client;
        this.response = response;
    }

    @Override
    public <T> T getEntity(Class<T> returnType) {
        return (T) response.getEntity(returnType);
    }

    @Override
    public <T> T getErrorEntity(Class<T> returnType) {
        return (T) response.getEntity(returnType);
    }

    @Override
    public InputStream getInputStream() {
		return new RESTEasyInputStream((InputStream) response.getEntity(InputStream.class), client.getExecutor());
    }

    @Override
    public String header(String name) {
        return response.getHeaders().getFirst(name);
    }

    @Override
    public Map<String, String> headers() {
        Map<String, String> headers = new HashMap<>();
        MultivaluedMap<String, Object> responseHeaders = response.getHeaders();

        for (String key : responseHeaders.keySet()) {
            headers.put(key, responseHeaders.getFirst(key).toString());
        }

        return headers;
    }

}
