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

package com.woorea.openstack.nova;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.nova.api.AvailabilityZoneResource;
import com.woorea.openstack.nova.api.ExtensionsResource;
import com.woorea.openstack.nova.api.FlavorsResource;
import com.woorea.openstack.nova.api.ImagesResource;
import com.woorea.openstack.nova.api.QuotaSetsResource;
import com.woorea.openstack.nova.api.ServersResource;
import com.woorea.openstack.nova.api.extensions.AggregatesExtension;
import com.woorea.openstack.nova.api.extensions.FloatingIpsExtension;
import com.woorea.openstack.nova.api.extensions.HostsExtension;
import com.woorea.openstack.nova.api.extensions.HypervisorsExtension;
import com.woorea.openstack.nova.api.extensions.KeyPairsExtension;
import com.woorea.openstack.nova.api.extensions.SecurityGroupsExtension;
import com.woorea.openstack.nova.api.extensions.SnapshotsExtension;
import com.woorea.openstack.nova.api.extensions.VolumesExtension;

public class Nova extends OpenStackClient {

    private final ExtensionsResource extensions;

    private final ServersResource servers;

    private final ImagesResource images;

    private final FlavorsResource flavors;

    private final KeyPairsExtension keyPairs;

    private final FloatingIpsExtension floatingIps;

    private final SecurityGroupsExtension securityGroups;

    private final SnapshotsExtension snapshots;

    private final VolumesExtension volumes;

    private final AggregatesExtension aggregates;

    private final QuotaSetsResource quotaSets;

    private final HostsExtension hosts;

    private final HypervisorsExtension hypervisor;

    private final AvailabilityZoneResource availabilityZones;

    public Nova(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        extensions = new ExtensionsResource(this);
        servers = new ServersResource(this);
        images = new ImagesResource(this);
        flavors = new FlavorsResource(this);
        keyPairs = new KeyPairsExtension(this);
        floatingIps = new FloatingIpsExtension(this);
        securityGroups = new SecurityGroupsExtension(this);
        snapshots = new SnapshotsExtension(this);
        volumes = new VolumesExtension(this);
        aggregates = new AggregatesExtension(this);
        quotaSets = new QuotaSetsResource(this);
        hosts = new HostsExtension(this);
        hypervisor = new HypervisorsExtension(this);
        availabilityZones = new AvailabilityZoneResource(this);
    }

    public Nova(String endpoint) {
        this(endpoint, null);
    }

    public ExtensionsResource extensions() {
        return extensions;
    }

    public ServersResource servers() {
        return servers;
    }

    public ImagesResource images() {
        return images;
    }

    public FlavorsResource flavors() {
        return flavors;
    }

    public KeyPairsExtension keyPairs() {
        return keyPairs;
    }

    public FloatingIpsExtension floatingIps() {
        return floatingIps;
    }

    public SecurityGroupsExtension securityGroups() {
        return securityGroups;
    }

    public SnapshotsExtension snapshots() {
        return snapshots;
    }

    public VolumesExtension volumes() {
        return volumes;
    }

    public AggregatesExtension aggregates() {
        return aggregates;
    }

    public QuotaSetsResource quotaSets() {
        return quotaSets;
    }

    public HostsExtension hosts() {
        return hosts;
    }

    public HypervisorsExtension hypervisors() {
        return hypervisor;
    }

    public AvailabilityZoneResource availabilityZones() {
        return availabilityZones;
    }
}
