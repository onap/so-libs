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

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class ObjectForUpload {

    private String container;

    private String name;

    private Map<String, java.lang.Object> properties;

    private InputStream inputStream;

    /**
     * @return the container
     */
    public String getContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(String container) {
        this.container = container;
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
     * @return the properties
     */
    public Map<String, java.lang.Object> getProperties() {
        if (properties == null) {
            properties = new HashMap<>();
        }
        return properties;
    }

    /**
     * @return the inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * @param inputStream the inputStream to set
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }



}
