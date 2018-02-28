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

public class ImageMemberTest {

    ImageMember imageMember = new ImageMember();

    @Test
    public void isCanShareTest() throws Exception {
        imageMember.isCanShare();
    }

    @Test
    public void setCanShareTest() throws Exception {
        imageMember.setCanShare(true);
    }

    @Test
    public void getMemberIdTest() throws Exception {
        imageMember.getMemberId();
    }

    @Test
    public void setMemberIdTest() throws Exception {
        imageMember.setMemberId("id");
    }

}