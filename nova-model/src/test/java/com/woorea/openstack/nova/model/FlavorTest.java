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

public class FlavorTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"flavor\" : {" + EOL + "    \"id\" : \"id\"," + EOL
            + "    \"name\" : \"name\"," + EOL + "    \"vcpus\" : 79," + EOL + "    \"ram\" : 38," + EOL
            + "    \"disk\" : 45," + EOL + "    \"swap\" : \"swap\"," + EOL + "    \"links\" : [ {" + EOL
            + "      \"rel\" : \"rel\"," + EOL + "      \"href\" : \"href\"," + EOL + "      \"type\" : \"type\"" + EOL
            + "    }, {" + EOL + "      \"rel\" : \"rel\"," + EOL + "      \"href\" : \"href\"," + EOL
            + "      \"type\" : \"type\"" + EOL + "    } ]," + EOL + "    \"public\" : false," + EOL
            + "    \"OS-FLV-EXT-DATA:ephemeral\" : 65," + EOL + "    \"rxtx_factor\" : 11.0," + EOL
            + "    \"OS-FLV-DISABLED:disabled\" : true," + EOL + "    \"rxtx_quota\" : 42," + EOL
            + "    \"rxtx_cap\" : 96," + EOL + "    \"os-flavor-access:is_public\" : false" + EOL + "  }" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(SerializationFeature.WRAP_ROOT_VALUE)
            .enable(DeserializationFeature.UNWRAP_ROOT_VALUE).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Flavor.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Flavor flavor = objectMapper.readValue(JSON_FULL, Flavor.class);
        String json = objectMapper.writeValueAsString(flavor);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Flavor flavor = objectMapper.readValue(JSON_FULL, Flavor.class);
        flavor.toString();

        Integer rxtxQuota = flavor.getRxtxQuota();
        Assert.assertNotNull(rxtxQuota);
        flavor.setRxtxQuota(rxtxQuota);

        String swap = flavor.getSwap();
        Assert.assertNotNull(swap);
        flavor.setSwap(swap);

        Float rxtxFactor = flavor.getRxtxFactor();
        Assert.assertNotNull(rxtxFactor);
        flavor.setRxtxFactor(rxtxFactor);

        Integer ephemeral = flavor.getEphemeral();
        Assert.assertNotNull(ephemeral);
        flavor.setEphemeral(ephemeral);

        Integer vcpus = flavor.getVcpus();
        Assert.assertNotNull(vcpus);
        flavor.setVcpus(vcpus);

        Integer rxtxCap = flavor.getRxtxCap();
        Assert.assertNotNull(rxtxCap);
        flavor.setRxtxCap(rxtxCap);

        Integer disk = flavor.getDisk();
        Assert.assertNotNull(disk);
        flavor.setDisk(disk);

        String name = flavor.getName();
        Assert.assertNotNull(name);
        flavor.setName(name);

        List<Link> links = flavor.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        flavor.setLinks(links);

        Boolean disabled = flavor.getDisabled();
        Assert.assertNotNull(disabled);
        flavor.setDisabled(disabled);

        String id = flavor.getId();
        Assert.assertNotNull(id);
        flavor.setId(id);

        Integer ram = flavor.getRam();
        Assert.assertNotNull(ram);
        flavor.setRam(ram);
    }
}
