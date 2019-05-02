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

package com.woorea.openstack.base.client;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import java.util.Properties;
import java.util.ServiceLoader;

public class OpenStackClient {

    protected String endpoint;

    protected OpenStackTokenProvider tokenProvider;

    protected static int authenticationRetries = 1;

    protected OpenStackClientConnector connector;

    protected Properties properties = new Properties();

    protected static OpenStackClientConnector defaultConnector;

    static {
        ServiceLoader<OpenStackClientConnector> connectorLoader;
        connectorLoader = ServiceLoader.load(OpenStackClientConnector.class);

        for (OpenStackClientConnector clientConnector : connectorLoader) {
            defaultConnector = clientConnector;
            break;
        }
    }

    public OpenStackClient(String endpoint) {
        this.endpoint = endpoint;
        this.connector = defaultConnector;
    }

    public OpenStackClient(String endpoint, OpenStackClientConnector connector) {
        this.endpoint = endpoint;
        this.connector = (connector == null) ? defaultConnector : connector;
    }

    public <T> OpenStackResponse request(OpenStackRequest<T> request) {
        OpenStackResponseException authException = null;

        for (int i = 0; i <= authenticationRetries; i++) {
            request.endpoint(endpoint);

            if (tokenProvider != null) {
                request.header("X-Auth-Token", tokenProvider.getToken());
            }

            try {
                return connector.request(request);
            } catch (OpenStackResponseException e) {
                if (e.getStatus() != OpenStackResponseStatus.NOT_AUTHORIZED || tokenProvider == null) {
                    throw e;
                }
                authException = e;
                tokenProvider.expireToken();
            }
        }
        if (null == authException) {
            authException = new OpenStackResponseException("Unknown issue", 500);
        }
        throw authException;
    }

    public <T> T execute(OpenStackRequest<T> request) {
        OpenStackResponse response = request(request);
        return (request.returnType() != null && request.returnType() != Void.class)
                ? response.getEntity(request.returnType())
                : null;
    }

    public void property(String property, String value) {
        properties.put(property, value);
    }

    public void setTokenProvider(OpenStackTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public void token(String token) {
        setTokenProvider(new OpenStackSimpleTokenProvider(token));
    }

    public <R> OpenStackRequest<R> get(String path, Class<R> returnType) {
        return new OpenStackRequest<>(this, HttpMethod.GET, path, null, returnType);
    }

}
