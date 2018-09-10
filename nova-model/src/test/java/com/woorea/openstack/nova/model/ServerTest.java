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

import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Image;
import com.woorea.openstack.nova.model.Link;
import com.woorea.openstack.nova.model.SecurityGroup;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.Server.Addresses;
import com.woorea.openstack.nova.model.Server.Fault;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ServerTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL
        + "  \"server\" : {" + EOL
        + "    \"id\" : \"id\"," + EOL
        + "    \"name\" : \"name\"," + EOL
        + "    \"addresses\" : {" + EOL
        + "      \"addresses\" : {" + EOL
        + "        \"addresses-k1\" : [ {" + EOL
        + "          \"version\" : \"version\"," + EOL
        + "          \"addr\" : \"addr\"," + EOL
        + "          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL
        + "          \"OS-EXT-IPS:type\" : \"type\"" + EOL
        + "        }, {" + EOL
        + "          \"version\" : \"version\"," + EOL
        + "          \"addr\" : \"addr\"," + EOL
        + "          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL
        + "          \"OS-EXT-IPS:type\" : \"type\"" + EOL
        + "        } ]," + EOL
        + "        \"addresses-k2\" : [ {" + EOL
        + "          \"version\" : \"version\"," + EOL
        + "          \"addr\" : \"addr\"," + EOL
        + "          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL
        + "          \"OS-EXT-IPS:type\" : \"type\"" + EOL
        + "        }, {" + EOL
        + "          \"version\" : \"version\"," + EOL
        + "          \"addr\" : \"addr\"," + EOL
        + "          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL
        + "          \"OS-EXT-IPS:type\" : \"type\"" + EOL
        + "        } ]" + EOL
        + "      }" + EOL
        + "    }," + EOL
        + "    \"links\" : [ {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    }, {" + EOL
        + "      \"rel\" : \"rel\"," + EOL
        + "      \"href\" : \"href\"," + EOL
        + "      \"type\" : \"type\"" + EOL
        + "    } ]," + EOL
        + "    \"image\" : {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"status\" : \"status\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"progress\" : 3," + EOL
        + "      \"minRam\" : 62," + EOL
        + "      \"minDisk\" : 69," + EOL
        + "      \"created\" : 1485172800000," + EOL
        + "      \"updated\" : 1486468800000," + EOL
        + "      \"metadata\" : {" + EOL
        + "        \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "        \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "      }," + EOL
        + "      \"server\" : {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"links\" : [ {" + EOL
        + "          \"rel\" : \"rel\"," + EOL
        + "          \"href\" : \"href\"," + EOL
        + "          \"type\" : \"type\"" + EOL
        + "        }, {" + EOL
        + "          \"rel\" : \"rel\"," + EOL
        + "          \"href\" : \"href\"," + EOL
        + "          \"type\" : \"type\"" + EOL
        + "        } ]" + EOL
        + "      }," + EOL
        + "      \"links\" : [ {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      }, {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      } ]," + EOL
        + "      \"OS-EXT-IMG-SIZE:size\" : 43" + EOL
        + "    }," + EOL
        + "    \"flavor\" : {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"vcpus\" : 79," + EOL
        + "      \"ram\" : 38," + EOL
        + "      \"disk\" : 45," + EOL
        + "      \"swap\" : \"swap\"," + EOL
        + "      \"links\" : [ {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      }, {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      } ]," + EOL
        + "      \"public\" : false," + EOL
        + "      \"OS-FLV-EXT-DATA:ephemeral\" : 65," + EOL
        + "      \"rxtx_factor\" : 11.0," + EOL
        + "      \"OS-FLV-DISABLED:disabled\" : true," + EOL
        + "      \"rxtx_quota\" : 42," + EOL
        + "      \"rxtx_cap\" : 96," + EOL
        + "      \"os-flavor-access:is_public\" : false" + EOL
        + "    }," + EOL
        + "    \"accessIPv4\" : \"accessipv4\"," + EOL
        + "    \"accessIPv6\" : \"accessipv6\"," + EOL
        + "    \"status\" : \"status\"," + EOL
        + "    \"progress\" : 3," + EOL
        + "    \"fault\" : {" + EOL
        + "      \"code\" : 29," + EOL
        + "      \"message\" : \"message\"," + EOL
        + "      \"details\" : \"details\"," + EOL
        + "      \"created\" : 1485172800000" + EOL
        + "    }," + EOL
        + "    \"hostId\" : \"hostid\"," + EOL
        + "    \"updated\" : \"updated\"," + EOL
        + "    \"created\" : \"created\"," + EOL
        + "    \"metadata\" : {" + EOL
        + "      \"metadata-k1\" : \"metadata-v1\"," + EOL
        + "      \"metadata-k2\" : \"metadata-v2\"" + EOL
        + "    }," + EOL
        + "    \"uuid\" : \"uuid\"," + EOL
        + "    \"adminPass\" : \"adminpass\"," + EOL
        + "    \"config_drive\" : \"configdrive\"," + EOL
        + "    \"tenant_id\" : \"tenantid\"," + EOL
        + "    \"user_id\" : \"userid\"," + EOL
        + "    \"key_name\" : \"keyname\"," + EOL
        + "    \"security_groups\" : [ {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"description\" : \"description\"," + EOL
        + "      \"rules\" : [ {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"group\" : {" + EOL
        + "          \"name\" : \"name\"," + EOL
        + "          \"tenant_id\" : \"tenantid\"" + EOL
        + "        }," + EOL
        + "        \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "        \"from_port\" : 7," + EOL
        + "        \"to_port\" : 98," + EOL
        + "        \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "        \"ip_range\" : {" + EOL
        + "          \"cidr\" : \"cidr\"" + EOL
        + "        }" + EOL
        + "      }, {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"group\" : {" + EOL
        + "          \"name\" : \"name\"," + EOL
        + "          \"tenant_id\" : \"tenantid\"" + EOL
        + "        }," + EOL
        + "        \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "        \"from_port\" : 7," + EOL
        + "        \"to_port\" : 98," + EOL
        + "        \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "        \"ip_range\" : {" + EOL
        + "          \"cidr\" : \"cidr\"" + EOL
        + "        }" + EOL
        + "      } ]," + EOL
        + "      \"links\" : [ {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      }, {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      } ]," + EOL
        + "      \"tenant_id\" : \"tenantid\"" + EOL
        + "    }, {" + EOL
        + "      \"id\" : \"id\"," + EOL
        + "      \"name\" : \"name\"," + EOL
        + "      \"description\" : \"description\"," + EOL
        + "      \"rules\" : [ {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"group\" : {" + EOL
        + "          \"name\" : \"name\"," + EOL
        + "          \"tenant_id\" : \"tenantid\"" + EOL
        + "        }," + EOL
        + "        \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "        \"from_port\" : 7," + EOL
        + "        \"to_port\" : 98," + EOL
        + "        \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "        \"ip_range\" : {" + EOL
        + "          \"cidr\" : \"cidr\"" + EOL
        + "        }" + EOL
        + "      }, {" + EOL
        + "        \"id\" : \"id\"," + EOL
        + "        \"name\" : \"name\"," + EOL
        + "        \"group\" : {" + EOL
        + "          \"name\" : \"name\"," + EOL
        + "          \"tenant_id\" : \"tenantid\"" + EOL
        + "        }," + EOL
        + "        \"parent_group_id\" : \"parentgroupid\"," + EOL
        + "        \"from_port\" : 7," + EOL
        + "        \"to_port\" : 98," + EOL
        + "        \"ip_protocol\" : \"ipprotocol\"," + EOL
        + "        \"ip_range\" : {" + EOL
        + "          \"cidr\" : \"cidr\"" + EOL
        + "        }" + EOL
        + "      } ]," + EOL
        + "      \"links\" : [ {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      }, {" + EOL
        + "        \"rel\" : \"rel\"," + EOL
        + "        \"href\" : \"href\"," + EOL
        + "        \"type\" : \"type\"" + EOL
        + "      } ]," + EOL
        + "      \"tenant_id\" : \"tenantid\"" + EOL
        + "    } ]," + EOL
        + "    \"OS-EXT-STS:task_state\" : \"taskstate\"," + EOL
        + "    \"OS-EXT-STS:power_state\" : \"powerstate\"," + EOL
        + "    \"OS-EXT-STS:vm_state\" : \"vmstate\"," + EOL
        + "    \"OS-EXT-SRV-ATTR:host\" : \"host\"," + EOL
        + "    \"OS-EXT-SRV-ATTR:instance_name\" : \"instancename\"," + EOL
        + "    \"OS-EXT-SRV-ATTR:hypervisor_hostname\" : \"hypervisorhostname\"," + EOL
        + "    \"OS-DCF:diskConfig\" : \"diskconfig\"," + EOL
        + "    \"OS-EXT-AZ:availability_zone\" : \"availabilityzone\"," + EOL
        + "    \"OS-SRV-USG:launched_at\" : \"launchedat\"," + EOL
        + "    \"OS-SRV-USG:terminated_at\" : \"terminatedat\"," + EOL
        + "    \"os-extended-volumes:volumes_attached\" : [ \"osextendedvolumesattached-v1\", \"osextendedvolumesattached-v2\" ]" + EOL
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
        System.out.println("CLASS: " + Server.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Server server = objectMapper.readValue(JSON_FULL, Server.class);
        String json = objectMapper.writeValueAsString(server);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Server server = objectMapper.readValue(JSON_FULL, Server.class);
        server.toString();
        
        Addresses addresses = server.getAddresses();
        Assert.assertNotNull(addresses);
        
        Map<String,String> metadata = server.getMetadata();
        Assert.assertNotNull(metadata);
        Assert.assertEquals(2, metadata.size());
        
        String hostId = server.getHostId();
        Assert.assertNotNull(hostId);
        
        String uuid = server.getUuid();
        Assert.assertNotNull(uuid);
        
        String userId = server.getUserId();
        Assert.assertNotNull(userId);
        
        String taskState = server.getTaskState();
        Assert.assertNotNull(taskState);
        
        String powerState = server.getPowerState();
        Assert.assertNotNull(powerState);
        
        String vmState = server.getVmState();
        Assert.assertNotNull(vmState);
        
        String tenantId = server.getTenantId();
        Assert.assertNotNull(tenantId);
        
        String configDrive = server.getConfigDrive();
        Assert.assertNotNull(configDrive);
        
        String host = server.getHost();
        Assert.assertNotNull(host);
        
        String keyName = server.getKeyName();
        Assert.assertNotNull(keyName);
        
        List<Link> links = server.getLinks();
        Assert.assertNotNull(links);
        Assert.assertEquals(2, links.size());
        
        String id = server.getId();
        Assert.assertNotNull(id);
        
        String launchedAt = server.getLaunchedAt();
        Assert.assertNotNull(launchedAt);
        
        Image image = server.getImage();
        Assert.assertNotNull(image);
        server.setImage(image);
        
        String terminatedAt = server.getTerminatedAt();
        Assert.assertNotNull(terminatedAt);
        
        String created = server.getCreated();
        Assert.assertNotNull(created);
        
        Fault fault = server.getFault();
        Assert.assertNotNull(fault);
        
        String hypervisorHostname = server.getHypervisorHostname();
        Assert.assertNotNull(hypervisorHostname);
        
        Flavor flavor = server.getFlavor();
        Assert.assertNotNull(flavor);
        server.setFlavor(flavor);
        
        String instanceName = server.getInstanceName();
        Assert.assertNotNull(instanceName);
        
        List<String> osExtendedVolumesAttached = server.getOsExtendedVolumesAttached();
        Assert.assertNotNull(osExtendedVolumesAttached);
        Assert.assertEquals(2, osExtendedVolumesAttached.size());
        
        String name = server.getName();
        Assert.assertNotNull(name);
        
        Integer progress = server.getProgress();
        Assert.assertNotNull(progress);
        
        String adminPass = server.getAdminPass();
        Assert.assertNotNull(adminPass);
        
        String accessIPv6 = server.getAccessIPv6();
        Assert.assertNotNull(accessIPv6);
        
        String diskConfig = server.getDiskConfig();
        Assert.assertNotNull(diskConfig);
        
        List<SecurityGroup> securityGroups = server.getSecurityGroups();
        Assert.assertNotNull(securityGroups);
        Assert.assertEquals(2, securityGroups.size());
        
        String updated = server.getUpdated();
        Assert.assertNotNull(updated);
        
        String availabilityZone = server.getAvailabilityZone();
        Assert.assertNotNull(availabilityZone);
        
        String accessIPv4 = server.getAccessIPv4();
        Assert.assertNotNull(accessIPv4);
        
        String status = server.getStatus();
        Assert.assertNotNull(status);
    }
}
