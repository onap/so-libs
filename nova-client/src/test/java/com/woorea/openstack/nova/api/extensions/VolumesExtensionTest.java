/*-
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
 * ================================================================================
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

import com.woorea.openstack.nova.model.VolumeForCreate;
import com.woorea.openstack.nova.model.VolumeForImageCreate;
import org.junit.Test;

public class VolumesExtensionTest {

    VolumesExtension volumesExtension = new VolumesExtension(null);

    @Test
    public void list() throws Exception {
        volumesExtension.list(true);
    }

    @Test
    public void create() throws Exception {
        volumesExtension.create(new VolumeForCreate());
    }

    @Test
    public void uploadToImage() throws Exception {
        volumesExtension.uploadToImage(new VolumeForImageCreate());
    }

    @Test
    public void show() throws Exception {
        volumesExtension.show("test");
    }

    @Test
    public void showMetadata() throws Exception {
        volumesExtension.showMetadata("test");
    }

    @Test
    public void delete() throws Exception {
        volumesExtension.delete("test");
    }

}