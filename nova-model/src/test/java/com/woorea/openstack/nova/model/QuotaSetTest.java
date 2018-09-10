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

import com.woorea.openstack.nova.model.QuotaSet;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class QuotaSetTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"quota_set\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"gigabytes\" : 77," + EOL
        + "    \"ram\" : 38," + EOL
        + "    \"instances\" : 86," + EOL
        + "    \"volumes\" : 97," + EOL
        + "    \"cores\" : 58," + EOL
        + "    \"metadata_items\" : 97," + EOL
        + "    \"injected_file_content_bytes\" : 86," + EOL
        + "    \"injected_files\" : 87," + EOL
        + "    \"floating_ips\" : 2," + EOL
        + "    \"security_groups\" : 78," + EOL
        + "    \"security_group_rules\" : 18," + EOL
        + "    \"injected_file_path_bytes\" : 52," + EOL
        + "    \"key_pairs\" : 90" + EOL
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
        System.out.println("CLASS: " + QuotaSet.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        QuotaSet quotaset = objectMapper.readValue(JSON_FULL, QuotaSet.class);
        String json = objectMapper.writeValueAsString(quotaset);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        QuotaSet quotaset = objectMapper.readValue(JSON_FULL, QuotaSet.class);
        quotaset.toString();
        
        Integer injectedFileContentBytes = quotaset.getInjectedFileContentBytes();
        Assert.assertNotNull(injectedFileContentBytes);
        quotaset.setInjectedFileContentBytes(injectedFileContentBytes);
        
        Integer injectedFiles = quotaset.getInjectedFiles();
        Assert.assertNotNull(injectedFiles);
        quotaset.setInjectedFiles(injectedFiles);
        
        Integer instances = quotaset.getInstances();
        Assert.assertNotNull(instances);
        quotaset.setInstances(instances);
        
        Integer gigabytes = quotaset.getGigabytes();
        Assert.assertNotNull(gigabytes);
        quotaset.setGigabytes(gigabytes);
        
        Integer metadataItems = quotaset.getMetadataItems();
        Assert.assertNotNull(metadataItems);
        quotaset.setMetadataItems(metadataItems);
        
        Integer volumes = quotaset.getVolumes();
        Assert.assertNotNull(volumes);
        quotaset.setVolumes(volumes);
        
        Integer injectedFilePathBytes = quotaset.getInjectedFilePathBytes();
        Assert.assertNotNull(injectedFilePathBytes);
        quotaset.setInjectedFilePathBytes(injectedFilePathBytes);
        
        Integer securityGroupRules = quotaset.getSecurityGroupRules();
        Assert.assertNotNull(securityGroupRules);
        quotaset.setSecurityGroupRules(securityGroupRules);
        
        Integer floatingIps = quotaset.getFloatingIps();
        Assert.assertNotNull(floatingIps);
        quotaset.setFloatingIps(floatingIps);
        
        Integer cores = quotaset.getCores();
        Assert.assertNotNull(cores);
        quotaset.setCores(cores);
        
        String id = quotaset.getId();
        Assert.assertNotNull(id);
        quotaset.setId(id);
        
        Integer securityGroups = quotaset.getSecurityGroups();
        Assert.assertNotNull(securityGroups);
        quotaset.setSecurityGroups(securityGroups);
        
        Integer ram = quotaset.getRam();
        Assert.assertNotNull(ram);
        quotaset.setRam(ram);
        
        Integer keyPairs = quotaset.getKeyPairs();
        Assert.assertNotNull(keyPairs);
        quotaset.setKeyPairs(keyPairs);
    }
}
