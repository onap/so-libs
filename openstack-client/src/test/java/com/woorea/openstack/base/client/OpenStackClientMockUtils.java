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

import org.mockito.MockSettings;
import org.mockito.Mockito;

public class OpenStackClientMockUtils {

    private static final OpenStackClientMockUtils utils = new OpenStackClientMockUtils();

    private OpenStackClientConnector connector = null;

    public OpenStackClientMockUtils() {
        connector = Mockito.mock(OpenStackClientConnector.class, Mockito.RETURNS_DEEP_STUBS);
        mockRequestResponse(String.class, "SUCCESS");
        mockRequestError(String.class, "SUCCESS");
    }

    public static OpenStackClientMockUtils getInstance() {
        return utils;
    }

    public <T extends OpenStackRequest, R> OpenStackClientMockUtils mockRequestResponse(T request, R response) {
        Mockito.when(connector.request(Mockito.eq(request)).getEntity(Mockito.eq(request.returnType())))
                .thenReturn(response);

        return this;
    }

    public <T> OpenStackClientMockUtils mockRequestResponse(Class<T> returnType, T response) {
        Mockito.when(connector.request(Mockito.any(OpenStackRequest.class)).getEntity(Mockito.eq(returnType)))
                .thenReturn(response);

        return this;
    }

    public <T extends OpenStackRequest, R> OpenStackClientMockUtils mockRequestError(T request, R error) {
        Mockito.when(connector.request(Mockito.eq(request)).getErrorEntity(Mockito.eq(request.returnType())))
                .thenReturn(error);

        return this;
    }

    public <T> OpenStackClientMockUtils mockRequestError(Class<T> returnType, T error) {
        Mockito.when(connector.request(Mockito.any(OpenStackRequest.class)).getErrorEntity(Mockito.eq(returnType)))
                .thenReturn(error);

        return this;
    }

    public <T extends OpenStackRequest> OpenStackClientMockUtils mockRequestThrow(T request, String message,
            int status) {
        Mockito.when(connector.request(Mockito.eq(request))).thenThrow(new OpenStackResponseException(message, status));

        return this;
    }

    public <T> OpenStackClientMockUtils mockRequestThrow(Class<T> returnType, String message, int status) {
        Mockito.when(connector.request(Mockito.any(OpenStackRequest.class)).getEntity(Mockito.eq(returnType)))
                .thenThrow(new OpenStackResponseException(message, status));

        return this;
    }

    public OpenStackClientConnector getConnector() {
        return connector;
    }
}
