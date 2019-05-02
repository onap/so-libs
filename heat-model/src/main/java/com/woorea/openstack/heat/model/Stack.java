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

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("stack")
public class Stack {
    @JsonProperty("description")
    private String description;

    @JsonProperty("links")
    private List<Link> links;
   

    @JsonProperty("stack_status_reason")
    private String stackStatusReason;

    @JsonProperty("stack_name")
    private String stackName;

    @JsonProperty("updated_time")
    private Date updatedTime;

    @JsonProperty("creation_time")
    private Date creationTime;

    @JsonProperty("stack_status")
    private String stackStatus;

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("template_description")
    private String templateDescription;
    
    @JsonProperty("stack_owner")
    private String stackOwner;
    
    @JsonProperty("disable_rollback")
    private boolean disableRollback;
    
    @JsonProperty("stack_user_project_id")
    private String userProjectId;
    
    @JsonProperty("timeout_mins")
    private int timeouteMinutes;
    
    public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public String getStackOwner() {
		return stackOwner;
	}

	public void setStackOwner(String stackOwner) {
		this.stackOwner = stackOwner;
	}

	public boolean isDisableRollback() {
		return disableRollback;
	}

	public void setDisableRollback(boolean disableRollback) {
		this.disableRollback = disableRollback;
	}

	public String getUserProjectId() {
		return userProjectId;
	}

	public void setUserProjectId(String userProjectId) {
		this.userProjectId = userProjectId;
	}

	public int getTimeouteMinutes() {
		return timeouteMinutes;
	}

	public void setTimeouteMinutes(int timeouteMinutes) {
		this.timeouteMinutes = timeouteMinutes;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@JsonProperty("project")
    private String project;
    
    @JsonProperty("files")
    private Map<String, Object> files = null;
    
    // ObjectMapper instance to parse Json stack outputs
    @JsonIgnore
    private static ObjectMapper mapper = new ObjectMapper();

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStackStatus() {
        return stackStatus;
    }

    public void setStackStatus(String stackStatus) {
        this.stackStatus = stackStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getStackStatusReason() {
        return stackStatusReason;
    }

    public void setStackStatusReason(String stackStatusReason) {
        this.stackStatusReason = stackStatusReason;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Map<String, Object> getFiles() {
        return this.files;
    }
    public void setFiles(Map<String, Object> files) {
        this.files = files;
    }


    @Override
    public String toString() {
        return "Stack{" +
                "description='" + description + '\'' +
                ", links=" + links +
                ", stackStatusReason='" + stackStatusReason + '\'' +
                ", stackName='" + stackName + '\'' +
                ", updatedTime=" + updatedTime +
                ", creationTime=" + creationTime +
                ", stackStatus='" + stackStatus + '\'' +
                ", id='" + id + '\'' +
                ", outputs='" + outputs + '\'' +
                ", parameters='" + parameters + '\'' +
                ", files='" + files + '\'' +
                '}';
    }
    
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static final class Output {
        @JsonProperty("output_value")
        private Object outputValue;
        
        private String description;
        
        @JsonProperty("output_key")
        private String outputKey;
        
        public Object getOutputValue() {
            return outputValue;
        }

        public String getDescription() {
            return description;
        }

        public String getOutputKey() {
            return outputKey;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Output [key=" + outputKey + ", value="
                    + outputValue + "]";
        }
    }
    
    private List<Output> outputs;

    public List<Output> getOutputs() {
        return outputs;
    }
    
    private Object _findOutputValue (String key) {
        for (Output o : outputs) {
            if (o.getOutputKey().equals(key)) {
                return o.getOutputValue();
            }
        }
        return null;
    }
    
    /*
     * Return a stack output as a String.
     * Generally speaking, most outputs will be Strings.
     */
    public String getOutputValue (String key)
    {
        Object value = _findOutputValue(key);
        if (value != null)
            return value.toString();
        else
            return null;
    }
    
    /*
     * Return a stack output as a Json-mapped Object of the provided type.
     * This is useful for json-object stack outputs.
     */
    public <T> T getOutputValue (String key, Class<T> type)
    {
        try {
            String s = mapper.writeValueAsString(_findOutputValue(key));
            return mapper.readValue(s, type);
        }
        catch (IOException e) {
            return null;
        }
    }
    
    @JsonProperty("parameters")
    private Map<String,Object> parameters = new HashMap<>();
    
    public void setParameters (Map<String,Object> params)
    {
        // Need to "fix" comma-delimited-list parameters for pre-Juno Heat
        // (see https://bugs.launchpad.net/heat/+bug/1367393)
        parameters = params;
        
        for (Entry<String,Object> param : parameters.entrySet())
        {
            // CDL params are returned as a string with format:
            // "[u'<value1>',u'<value2>',...]"
            String value = param.getValue().toString();
            if (value.startsWith("[") && value.endsWith("]"))
            {
                param.setValue(value.substring(1,value.length()-1).replaceAll("u'([^\']+)'","$1"));
            }
        }
    }
    
    public Map<String,Object> getParameters() {
        return parameters;
    }
}
