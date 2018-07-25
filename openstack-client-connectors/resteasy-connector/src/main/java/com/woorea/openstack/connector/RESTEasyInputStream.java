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

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.jboss.resteasy.client.ClientExecutor;


public class RESTEasyInputStream extends FilterInputStream {

    protected ClientExecutor clientExecutor;

    public RESTEasyInputStream(InputStream inputStream, ClientExecutor clientExecutor) {
        super(inputStream);
        this.clientExecutor = clientExecutor;
    }

    @Override
    public void close() throws IOException {
        try {
            clientExecutor.close();
        } catch (Exception e) {
            // Silently skip errors in the socket close errors
        }

        try {
            super.close();
        } catch (SocketException e) {
            // We expect this exception because the socket is closed
        } catch (IllegalStateException e) {
            // We expect this exception because the socket is closed (httpclient 4.2)
        }
    }

}
