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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class QuotaSetTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"quota_set\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"gigabytes\" : 77," + EOL + "    \"ram\" : 38," + EOL + "    \"instances\" : 86," + EOL
            + "    \"volumes\" : 97," + EOL + "    \"cores\" : 58," + EOL + "    \"metadata_items\" : 97," + EOL
            + "    \"injected_file_content_bytes\" : 86," + EOL + "    \"injected_files\" : 87," + EOL
            + "    \"floating_ips\" : 2," + EOL + "    \"security_groups\" : 78," + EOL
            + "    \"security_group_rules\" : 18," + EOL + "    \"injected_file_path_bytes\" : 52," + EOL
            + "    \"key_pairs\" : 90" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

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
        Assertions.assertNotNull(injectedFileContentBytes);
        quotaset.setInjectedFileContentBytes(injectedFileContentBytes);

        Integer injectedFiles = quotaset.getInjectedFiles();
        Assertions.assertNotNull(injectedFiles);
        quotaset.setInjectedFiles(injectedFiles);

        Integer instances = quotaset.getInstances();
        Assertions.assertNotNull(instances);
        quotaset.setInstances(instances);

        Integer gigabytes = quotaset.getGigabytes();
        Assertions.assertNotNull(gigabytes);
        quotaset.setGigabytes(gigabytes);

        Integer metadataItems = quotaset.getMetadataItems();
        Assertions.assertNotNull(metadataItems);
        quotaset.setMetadataItems(metadataItems);

        Integer volumes = quotaset.getVolumes();
        Assertions.assertNotNull(volumes);
        quotaset.setVolumes(volumes);

        Integer injectedFilePathBytes = quotaset.getInjectedFilePathBytes();
        Assertions.assertNotNull(injectedFilePathBytes);
        quotaset.setInjectedFilePathBytes(injectedFilePathBytes);

        Integer securityGroupRules = quotaset.getSecurityGroupRules();
        Assertions.assertNotNull(securityGroupRules);
        quotaset.setSecurityGroupRules(securityGroupRules);

        Integer floatingIps = quotaset.getFloatingIps();
        Assertions.assertNotNull(floatingIps);
        quotaset.setFloatingIps(floatingIps);

        Integer cores = quotaset.getCores();
        Assertions.assertNotNull(cores);
        quotaset.setCores(cores);

        String id = quotaset.getId();
        Assertions.assertNotNull(id);
        quotaset.setId(id);

        Integer securityGroups = quotaset.getSecurityGroups();
        Assertions.assertNotNull(securityGroups);
        quotaset.setSecurityGroups(securityGroups);

        Integer ram = quotaset.getRam();
        Assertions.assertNotNull(ram);
        quotaset.setRam(ram);

        Integer keyPairs = quotaset.getKeyPairs();
        Assertions.assertNotNull(keyPairs);
        quotaset.setKeyPairs(keyPairs);
    }
}
