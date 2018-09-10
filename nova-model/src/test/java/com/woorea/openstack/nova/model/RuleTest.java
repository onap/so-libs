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

import com.woorea.openstack.nova.model.SecurityGroup.Rule;
import com.woorea.openstack.nova.model.SecurityGroup.Rule.Group;
import com.woorea.openstack.nova.model.SecurityGroup.Rule.IpRange;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class RuleTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"security_group_rule\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"group\" : {" + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"tenant_id\" : \"tenantid\"" + EOL
        + "    }," + EOL
        + "    \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "    \"from_port\" : 7," + EOL
        + "    \"to_port\" : 98," + EOL
        + "    \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "    \"ip_range\" : {" + EOL
        + "      \"cidr\" : \"cidr\"" + EOL
        + "    }" + EOL
        + "  }" + EOL
        + "}";

    private ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(Inclusion.NON_NULL)
        .enable(SerializationConfig.Feature.INDENT_OUTPUT)
        .enable(SerializationConfig.Feature.WRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE)
        .enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Rule.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Rule rule = objectMapper.readValue(JSON_FULL, Rule.class);
        String json = objectMapper.writeValueAsString(rule);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Rule rule = objectMapper.readValue(JSON_FULL, Rule.class);
        rule.toString();
        
        String parentGroupId = rule.getParentGroupId();
        Assert.assertNotNull(parentGroupId);
        
        String ipProtocol = rule.getIpProtocol();
        Assert.assertNotNull(ipProtocol);
        
        IpRange ipRange = rule.getIpRange();
        Assert.assertNotNull(ipRange);
        
        Integer fromPort = rule.getFromPort();
        Assert.assertNotNull(fromPort);
        
        String name = rule.getName();
        Assert.assertNotNull(name);
        
        String id = rule.getId();
        Assert.assertNotNull(id);
        
        Integer toPort = rule.getToPort();
        Assert.assertNotNull(toPort);
        
        Group group = rule.getGroup();
        Assert.assertNotNull(group);
    }
}
