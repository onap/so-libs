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
package com.woorea.openstack.glance.model;

import org.junit.Test;

import java.util.GregorianCalendar;

public class ImageTest {

    Image image = new Image();

    @Test
    public void getIdTest() throws Exception {
        image.getId();
    }

    @Test
    public void setIdTest() throws Exception {
        image.setId("uuid");
    }

    @Test
    public void getUriTest() throws Exception {
        image.getUri();
    }

    @Test
    public void setUriTest() throws Exception {
        image.setUri("uri");
    }

    @Test
    public void getNameTest() throws Exception {
        image.getName();
    }

    @Test
    public void setNameTest() throws Exception {
        image.setName("image-123");
    }

    @Test
    public void getDiskFormatTest() throws Exception {
        image.getDiskFormat();
    }

    @Test
    public void setDiskFormatTest() throws Exception {
        image.setDiskFormat("disk-format");
    }

    @Test
    public void getContainerFormatTest() throws Exception {
        image.getContainerFormat();
    }

    @Test
    public void setContainerFormatTest() throws Exception {
        image.setContainerFormat("format");
    }

    @Test
    public void getSizeTest() throws Exception {
        image.getSize();
    }

    @Test
    public void setSizeTest() throws Exception {
        image.setSize(12345L);
    }

    @Test
    public void getVirtualSizeTest() throws Exception {
        image.getVirtualSize();
    }

    @Test
    public void setVirtualSizeTest() throws Exception {
        image.setVirtualSize(1234L);
    }

    @Test
    public void getChecksumTest() throws Exception {
        image.getChecksum();
    }

    @Test
    public void setChecksumTest() throws Exception {
        image.setChecksum("ABC");
    }

    @Test
    public void getCreatedAtTest() throws Exception {
        image.getCreatedAt();
    }

    @Test
    public void setCreatedAtTest() throws Exception {
        image.setCreatedAt(new GregorianCalendar());
    }

    @Test
    public void getUpdatedAtTest() throws Exception {
        image.getUpdatedAt();
    }

    @Test
    public void setUpdatedAt() throws Exception {
        image.setUpdatedAt(new GregorianCalendar());
    }

    @Test
    public void getDeletedAtTest() throws Exception {
        image.getDeletedAt();
    }

    @Test
    public void setDeletedAtTest() throws Exception {
        image.setDeletedAt(new GregorianCalendar());
    }

    @Test
    public void getStatus() throws Exception {
        image.getStatus();
    }

    @Test
    public void setStatusTest() throws Exception {
        image.setStatus("status");
    }

    @Test
    public void isPublicTest() throws Exception {
        image.isPublic();
    }

    @Test
    public void setPublicTest() throws Exception {
        image.setPublic(true);
    }

    @Test
    public void getMinRamTest() throws Exception {
        image.getMinRam();
    }

    @Test
    public void setMinRamTest() throws Exception {
        image.setMinRam(256);
    }

    @Test
    public void getMinDiskTest() throws Exception {
        image.getMinDisk();
    }

    @Test
    public void setMinDiskTest() throws Exception {
        image.setMinDisk(8);
    }

    @Test
    public void getOwnerTest() throws Exception {
        image.getOwner();
    }

    @Test
    public void setOwnerTest() throws Exception {
        image.setOwner("onap");
    }

    @Test
    public void isDeletedTest() throws Exception {
        image.isDeleted();
    }

    @Test
    public void setDeletedTest() throws Exception {
        image.setDeleted(true);
    }

    @Test
    public void isProtectedTest() throws Exception {
        image.isProtected();
    }

    @Test
    public void setProtectedTest() throws Exception {
        image.setProtected(true);
    }

    @Test
    public void getPropertiesTest() throws Exception {
        image.getProperties();
    }

}