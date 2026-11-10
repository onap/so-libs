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

package com.woorea.openstack.cinder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VolumeTest {

    private static final ObjectMapper WRAPPED_READER =
            new ObjectMapper().enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    @Test
    public void attachmentsAreTyped() throws Exception {
        Volume volume = WRAPPED_READER.readValue("{\"volume\":{\"id\":\"v1\",\"attachments\":[{\"server_id\":\"s1\","
                + "\"attachment_id\":\"a1\",\"volume_id\":\"v1\",\"device\":\"/dev/vdb\",\"host_name\":null,"
                + "\"id\":\"v1\",\"attached_at\":\"2026-01-01T00:00:00.000000\"}]}}", Volume.class);

        Volume.Attachment attachment = volume.getAttachments().get(0);
        Assertions.assertEquals("s1", attachment.getServerId());
        Assertions.assertEquals("/dev/vdb", attachment.getDevice());
    }

    @Test
    public void noAttachments() throws Exception {
        Volume volume = WRAPPED_READER.readValue("{\"volume\":{\"id\":\"v1\",\"attachments\":[]}}", Volume.class);
        Assertions.assertTrue(volume.getAttachments().isEmpty());
    }
}
