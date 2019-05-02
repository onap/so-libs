/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 AT&T Intellectual Property. All rights reserved.
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

package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ResourceTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"links\" : [ {" + EOL + "    \"href\" : \"href\"," + EOL
            + "    \"rel\" : \"rel\"" + EOL + "  }, {" + EOL + "    \"href\" : \"href\"," + EOL
            + "    \"rel\" : \"rel\"" + EOL + "  } ]," + EOL + "  \"resource_name\" : \"name\"," + EOL
            + "  \"resource_status\" : \"status\"," + EOL + "  \"physical_resource_id\" : \"physicalresourceid\"," + EOL
            + "  \"logical_resource_id\" : \"logicalresourceid\"," + EOL
            + "  \"required_by\" : [ \"requiredby-v1\", \"requiredby-v2\" ]," + EOL
            + "  \"updated_time\" : 1488110400000," + EOL + "  \"resource_type\" : \"type\"," + EOL
            + "  \"resource_status_reason\" : \"statusreason\"" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Resource.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Resource resource = objectMapper.readValue(JSON_FULL, Resource.class);
        String json = objectMapper.writeValueAsString(resource);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Resource resource = objectMapper.readValue(JSON_FULL, Resource.class);
        resource.toString();

        Date updatedTime = resource.getUpdatedTime();
        Assert.assertNotNull(updatedTime);
        resource.setUpdatedTime(updatedTime);

        String physicalResourceId = resource.getPhysicalResourceId();
        Assert.assertNotNull(physicalResourceId);
        resource.setPhysicalResourceId(physicalResourceId);

        List<String> requiredBy = resource.getRequiredBy();
        Assert.assertNotNull(requiredBy);
        Assert.assertEquals(2, requiredBy.size());
        resource.setRequiredBy(requiredBy);

        String statusReason = resource.getStatusReason();
        Assert.assertNotNull(statusReason);
        resource.setStatusReason(statusReason);

        String name = resource.getName();
        Assert.assertNotNull(name);
        resource.setName(name);

        List<Link> links = resource.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        resource.setLinks(links);

        String logicalResourceId = resource.getLogicalResourceId();
        Assert.assertNotNull(logicalResourceId);
        resource.setLogicalResourceId(logicalResourceId);

        String type = resource.getType();
        Assert.assertNotNull(type);
        resource.setType(type);

        String status = resource.getStatus();
        Assert.assertNotNull(status);
        resource.setStatus(status);
    }
}
