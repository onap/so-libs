/*-
 * ============LICENSE_START=======================================================
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

package com.woorea.openstack.nova.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageFromVolumeTest {

    private ImageFromVolume image = new ImageFromVolume();

    @Test
    public void getId() {
        image.getId();
    }

    @Test
    public void setId() {
        image.setId("123");
    }

    @Test
    public void getUpdates_at() {
        image.getUpdates_at();
    }

    @Test
    public void setUpdates_at() {
        image.setUpdates_at("123");
    }

    @Test
    public void getStatus() {
        image.getStatus();
    }

    @Test
    public void setStatus() {
        image.setStatus("123");
    }

    @Test
    public void getDisplay_description() {
        image.getDisplay_description();
    }

    @Test
    public void setDisplay_description() {
        image.setDisplay_description("123");
    }

    @Test
    public void getSize() {
        image.getSize();
    }

    @Test
    public void setSize() {
        image.setSize("123");
    }

    @Test
    public void getVolume_type() {
        image.getVolume_type();
    }

    @Test
    public void setVolume_type() {
        image.setVolume_type("123");
    }

    @Test
    public void getImage_id() {
        image.getImage_id();
    }

    @Test
    public void setImage_id() {
        image.setImage_id("123");
    }

    @Test
    public void getContainer_format() {
        image.getContainer_format();
    }

    @Test
    public void setContainer_format() {
        image.setContainer_format("123");
    }

    @Test
    public void getDisk_format() {
        image.getDisk_format();
    }

    @Test
    public void setDisk_format() {
        image.setDisk_format("123");
    }

    @Test
    public void getImage_name() {
        image.getImage_name();
    }

    @Test
    public void setImage_name() {
        image.setImage_name("123");
    }
}