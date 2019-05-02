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

package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

// There is no Root element for the Explanation return
// @JsonRootName("error")
public class Explanation {
    @JsonProperty("explanation")
    private String explanation;

    @JsonProperty("code")
    private int code;

    @JsonProperty("title")
    private String title;

    @JsonRootName("error")
    public static class Error {
        @JsonProperty("message")
        private String message;

        @JsonProperty("traceback")
        private String traceback;

        @JsonProperty("type")
        private String type;

        public String getMessage() {
            return message;
        }

        public String getTraceback() {
            return traceback;
        }

        public String getType() {
            return type;
        }
    }

    private Error error;

    public String getExplanation() {
        return explanation;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Error getError() {
        return error;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Explanation [ " + "code='" + code + "', title='" + title + "', explanation='" + explanation
                + "', Error [type='" + error.type + "', message='" + error.message + "' ] ]";
    }

}
