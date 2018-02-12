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

package com.woorea.openstack.nova.model;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Collections;

import static org.junit.Assert.*;

public class ImageTest {

    private Image image = new Image();

    @Test
    public void getId() {
        image.getId();
    }

    @Test
    public void setId() {
        image.setId("123");
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
    public void getName() {
        image.setName("123");
    }

    @Test
    public void setName() {
        image.setName("123");
    }

    @Test
    public void getProgress() {
        image.getProgress();
    }

    @Test
    public void setProgress() {
        image.setProgress(123);
    }

    @Test
    public void getMinRam() {
        image.getMinRam();
    }

    @Test
    public void setMinRam() {
        image.setMinRam(123);
    }

    @Test
    public void getMinDisk() {
        image.getMinDisk();
    }

    @Test
    public void setMinDisk() {
        image.setMinDisk(123);
    }

    @Test
    public void getCreated() {
        image.getCreated();
    }

    @Test
    public void setCreated() {
        image.setCreated(Calendar.getInstance());
    }

    @Test
    public void getUpdated() {
        image.getUpdated();
    }

    @Test
    public void setUpdated() {
        image.setUpdated(Calendar.getInstance());
    }

    @Test
    public void getMetadata() {
        image.getMetadata();
    }

    @Test
    public void getSize() {
        image.getSize();
    }

    @Test
    public void setMetadata() {
        image.setMetadata(Collections.<String, String>emptyMap());
    }

    @Test
    public void getServer() {
        image.getServer();
    }

    @Test
    public void getLinks() {
        image.getLinks();
    }

    @Test
    public void setLinks() {
        image.setLinks(Collections.<Link>emptyList());
    }
}