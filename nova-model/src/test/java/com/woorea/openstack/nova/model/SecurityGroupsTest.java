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

package com.woorea.openstack.nova.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class SecurityGroupsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"security_groups\" : [ {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"rules\" : [ {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"group\" : {" + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"tenant_id\" : \"tenantid\"" + EOL
        + "      }," + EOL
        + "      \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "      \"from_port\" : 7," + EOL
        + "      \"to_port\" : 98," + EOL
        + "      \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "      \"ip_range\" : {" + EOL
        + "        \"cidr\" : \"cidr\"" + EOL
        + "      }" + EOL
        + "    }, {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"group\" : {" + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"tenant_id\" : \"tenantid\"" + EOL
        + "      }," + EOL
        + "      \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "      \"from_port\" : 7," + EOL
        + "      \"to_port\" : 98," + EOL
        + "      \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "      \"ip_range\" : {" + EOL
        + "        \"cidr\" : \"cidr\"" + EOL
        + "      }" + EOL
        + "    } ]," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]," + EOL
        + "    \"tenant_id\" : \"tenantid\"" + EOL
        + "  }, {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"description\" : \"description\"," + EOL
        + "    \"rules\" : [ {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"group\" : {" + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"tenant_id\" : \"tenantid\"" + EOL
        + "      }," + EOL
        + "      \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "      \"from_port\" : 7," + EOL
        + "      \"to_port\" : 98," + EOL
        + "      \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "      \"ip_range\" : {" + EOL
        + "        \"cidr\" : \"cidr\"" + EOL
        + "      }" + EOL
        + "    }, {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"group\" : {" + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"tenant_id\" : \"tenantid\"" + EOL
        + "      }," + EOL
        + "      \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "      \"from_port\" : 7," + EOL
        + "      \"to_port\" : 98," + EOL
        + "      \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "      \"ip_range\" : {" + EOL
        + "        \"cidr\" : \"cidr\"" + EOL
        + "      }" + EOL
        + "    } ]," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]," + EOL
        + "    \"tenant_id\" : \"tenantid\"" + EOL
        + "  } ]" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Include.NON_NULL)
        .enable(SerializationFeature.INDENT_OUTPUT)
        .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + SecurityGroups.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        SecurityGroups securitygroups = objectMapper.readValue(JSON_FULL, SecurityGroups.class);
        String json = objectMapper.writeValueAsString(securitygroups);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        SecurityGroups securitygroups = objectMapper.readValue(JSON_FULL, SecurityGroups.class);
        securitygroups.toString();
        
        List<SecurityGroup> list = securitygroups.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        
        int cnt = 0;
        for (@SuppressWarnings("unused") SecurityGroup x : securitygroups) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
