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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OpenStackClientTest {

    private static final String CLIENT_ENDPOINT = "endpoint";
    private static final String OS_REQUEST_PATH = "openstack_request_path";
    private static final String SUCCESS = "Success";
    private static final String TOKEN = "token";

    private OpenStackClient client = null;
    private OpenStackRequest<String> conflictRequest = new OpenStackRequest<>();
    private OpenStackRequest<String> notAuthorizedRequest = new OpenStackRequest<>();

    @Before
    public void setUp() throws Exception {
        final OpenStackClientConnector clientConnector = mockClientConnector();
        client = new OpenStackClient(CLIENT_ENDPOINT, clientConnector);
    }

    private OpenStackClientConnector mockClientConnector() {
        return OpenStackClientMockUtils.getInstance()
                .mockRequestResponse(Entity.class, Entity.json(SUCCESS))
                .mockRequestThrow(notAuthorizedRequest, "Not Authorized", OpenStackResponseStatus.NOT_AUTHORIZED)
                .mockRequestThrow(conflictRequest, "Conflict", OpenStackResponseStatus.CONFLICT)
                .getConnector();

    }

    @Test
    public void execute() {
        final OpenStackRequest<Entity> request = client.get(OS_REQUEST_PATH, Entity.class);
        final Entity<String> resp = client.execute(request);

        Assert.assertEquals(SUCCESS, resp.getEntity());
    }

    @Test(expected = OpenStackResponseException.class)
    public void executeNotAuthorized() {
        client.token(TOKEN);
        client.execute(notAuthorizedRequest);
    }

    @Test(expected = OpenStackResponseException.class)
    public void executeConflict() {
        client.execute(conflictRequest);
    }
}