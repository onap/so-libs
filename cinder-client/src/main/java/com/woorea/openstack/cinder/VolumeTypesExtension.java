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

package com.woorea.openstack.cinder;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.cinder.model.VolumeType;
import com.woorea.openstack.cinder.model.VolumeTypeForCreate;
import com.woorea.openstack.cinder.model.VolumeTypes;

public class VolumeTypesExtension {

    private final OpenStackClient CLIENT;

    public VolumeTypesExtension(OpenStackClient client) {
        CLIENT = client;
    }

    public List list() {
        return new List();
    }

    public Create create(VolumeTypeForCreate volumeTypeForCreate) {
        return new Create(volumeTypeForCreate);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<VolumeTypes> {

        public List() {
            super(CLIENT, HttpMethod.GET, "/types", null, VolumeTypes.class);
        }

    }

    public class Create extends OpenStackRequest<VolumeType> {

        private VolumeTypeForCreate volumeTypeForCreate;

        public Create(VolumeTypeForCreate volumeTypeForCreate) {
            super(CLIENT, HttpMethod.POST, "/types", Entity.json(volumeTypeForCreate), VolumeType.class);
            this.volumeTypeForCreate = volumeTypeForCreate;
        }

    }

    public class Show extends OpenStackRequest<VolumeType> {

        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/types/").append(id).toString(), null, VolumeType.class);
        }

    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/types/").append(id).toString(), null, Void.class);
        }

    }

}
