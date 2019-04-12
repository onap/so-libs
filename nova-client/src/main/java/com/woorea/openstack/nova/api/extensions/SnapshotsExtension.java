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

package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Snapshot;
import com.woorea.openstack.nova.model.SnapshotForCreate;
import com.woorea.openstack.nova.model.Snapshots;

public class SnapshotsExtension {

    private final OpenStackClient CLIENT;

    public SnapshotsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(SnapshotForCreate snapshotForCreate) {
        return new Create(snapshotForCreate);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }


    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Snapshots> {

        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/os-snapshots/detail" : "/os-snapshots", null, Snapshots.class);
        }

    }

    public class Create extends OpenStackRequest<SnapshotForCreate> {

        private SnapshotForCreate snapshotForCreate;

        public Create(SnapshotForCreate snapshotForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-snapshots", Entity.json(snapshotForCreate), SnapshotForCreate.class);
            this.snapshotForCreate = snapshotForCreate;
        }

    }

    public class Show extends OpenStackRequest<Snapshot> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-snapshots/").append(id).toString(), null, Snapshot.class);
        }

    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-snapshots/").append(id).append("/metadata").toString(), null, Metadata.class);
        }

    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-snapshots/").append(id).toString(), null, Void.class);
        }

    }

}
