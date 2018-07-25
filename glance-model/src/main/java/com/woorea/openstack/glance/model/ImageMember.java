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

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageMember implements Serializable {

    @JsonProperty("can_share")
    private boolean canShare;
    
    @JsonProperty("member_id")
    private String memberId;

    public ImageMember() {
        
    }

    public ImageMember(boolean canShare, String memberId) {
        this.canShare = canShare;
        this.memberId = memberId;
    }

    /**
     * @return the canShare
     */
    public boolean isCanShare() {
        return canShare;
    }

    /**
     * @param canShare the canShare to set
     */
    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
