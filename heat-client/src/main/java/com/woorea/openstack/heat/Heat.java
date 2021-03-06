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

package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.heat.model.Events;

/**
 * Reference: http://api.openstack.org/api-ref-orchestration.html
 */
public class Heat extends OpenStackClient {

    private final StackResource stacks;
    private final ResourcesResource resources;
    private final StackEvents events;

    public Heat(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        stacks = new StackResource(this);
        resources = new ResourcesResource(this);
        events = new StackEvents(this);
    }

    public Heat(String endpoint) {
        this(endpoint, null);
    }

    public StackResource getStacks() {
        return stacks;
    }

    public ResourcesResource getResources() {
        return resources;
    }

    public StackEvents getEvents() {
        return events;
    }
}
