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

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;

public class CreateStackParam {

    @JsonProperty("stack_name")
    private String stackName;

    @JsonProperty("template_url")
    private String templateUrl;

    @JsonProperty
    private String template;

    @JsonProperty("parameters")
    private Map<String, Object> parameters;

    @JsonProperty("timeout_mins")
    private int timeoutMinutes;

    @JsonProperty("environment")
    private String environment;

    @JsonProperty("disable_rollback")
    private boolean disableRollback = true;

    @JsonProperty("files")
    private Map<String, Object> files;

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    /**
     * The URL of the template to instantiate. This value is ignored if the template is supplied inline.
     *
     * @param templateUrl a template url.
     */
    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public String getTemplate() {
        return template;
    }

    /**
     * A JSON template to instantiate. This value takes precedence over the template URL if both are supplied.
     *
     * @param template a template json.
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public int getTimeoutMinutes() {
        return timeoutMinutes;
    }

    public void setTimeoutMinutes(int timeoutMinutes) {
        this.timeoutMinutes = timeoutMinutes;
    }

    public String getEnvironment() {
        return environment;
    }

    /**
     * A JSON environment for the stack.
     *
     * @param environment a environment.
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean getDisableRollback() {
        return disableRollback;
    }

    public void setDisableRollback(boolean disableRollback) {
        this.disableRollback = disableRollback;
    }

    public void setFiles(Map<String, Object> files) {
        this.files = files;
    }

    public Map<String, Object> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return String.format("CreateStackParam{"
                + "stackName='%s',"
                + " templateUrl='%s',"
                + " template='%s',"
                + " parameters=%s,"
                + " timeoutMinutes=%d,"
                + " environment='%s',"
                + " disableRollback='%s',"
                + " files=%s"
                + "}",
            stackName,
            templateUrl,
            template,
            parameters,
            timeoutMinutes,
            environment,
            disableRollback,
            files);
    }
}
