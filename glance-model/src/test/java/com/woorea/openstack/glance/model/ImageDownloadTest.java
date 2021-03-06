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
package com.woorea.openstack.glance.model;

import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class ImageDownloadTest {

    ImageDownload imageDownload = new ImageDownload();

    @Test
    public void getImageTest() throws Exception {
        imageDownload.getImage();
    }

    @Test
    public void setImageTest() throws Exception {
        imageDownload.setImage(new Image());
    }

    @Test
    public void getInputStreamTest() throws Exception {
        imageDownload.getInputStream();
    }

    @Test
    public void setInputStreamTest() throws Exception {
        imageDownload.setInputStream(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });
    }

}
