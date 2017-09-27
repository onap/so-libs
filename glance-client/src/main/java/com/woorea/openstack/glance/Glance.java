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

package com.woorea.openstack.glance;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Glance extends OpenStackClient {

    private final ImagesResource images;

    private final SharedImagesResource sharedImages;

    public Glance(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        images = new ImagesResource(this);
        sharedImages = new SharedImagesResource(this);
    }

    public Glance(String endpoint) {
        this(endpoint, null);
    }

    public final ImagesResource images() {
        return images;
    }

    public final SharedImagesResource sharedImages() {
        return sharedImages;
    }
}
