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

package com.woorea.openstack.swift.model;

import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonProperty;


public class Object implements Serializable {
    
    private String subdir;
    
    private String name;
    
    private String hash;
    
    private int bytes;
    
    @JsonProperty("content_type")
    private String contentType;
    
    @JsonProperty("last_modified")
    private Calendar lastModified;

    /**
     * @return the subdir
     */
    public String getSubdir() {
        return subdir;
    }

    /**
     * @param subdir the subdir to set
     */
    public void setSubdir(String subdir) {
        this.subdir = subdir;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the bytes
     */
    public int getBytes() {
        return bytes;
    }

    /**
     * @param bytes the bytes to set
     */
    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the lastModified
     */
    public Calendar getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Calendar lastModified) {
        this.lastModified = lastModified;
    }
    
}
