/* ============LICENSE_START=======================================================
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

package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Cinder extends OpenStackClient {

    private final VolumesExtension VOLUMES;

    private final SnapshotsExtension SNAPSHOTS;

    private final VolumeTypesExtension VOLUME_TYPES;

    private final LimitsExtension LIMITS;

    private final SchedulerStatsExtension SCHEDULER_STATS;

    public Cinder(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        VOLUMES = new VolumesExtension(this);
        SNAPSHOTS = new SnapshotsExtension(this);
        VOLUME_TYPES = new VolumeTypesExtension(this);
        LIMITS = new LimitsExtension(this);
        SCHEDULER_STATS = new SchedulerStatsExtension(this);
    }

    public Cinder(String endpoint) {
        this(endpoint, null);
    }

    public final VolumesExtension volumes() {
        return VOLUMES;
    }

    public final SnapshotsExtension snapshots() {
        return SNAPSHOTS;
    }

    public final VolumeTypesExtension volumeTypes() {
        return VOLUME_TYPES;
    }

    public final LimitsExtension limits() {
        return LIMITS;
    }

    public final SchedulerStatsExtension schedulerStats() {
        return SCHEDULER_STATS;
    }
}
