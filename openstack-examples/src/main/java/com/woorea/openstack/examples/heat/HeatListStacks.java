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

package com.woorea.openstack.examples.heat;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.heat.Heat;
import com.woorea.openstack.heat.model.CreateStackParam;
import com.woorea.openstack.heat.model.Stack;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.utils.KeystoneTokenProvider;
import com.woorea.openstack.keystone.utils.KeystoneUtils;

import java.util.Collections;

public class HeatListStacks {

    private static String TEMPLATE = "{\n" +
            "    \"HeatTemplateFormatVersion\": \"2012-12-12\",\n" +
            "    \"Parameters\": {},\n" +
            "    \"Mappings\": {},\n" +
            "    \"Resources\": {\n" +
            "        \"my-test-server\": {\n" +
            "            \"Type\": \"OS::Nova::Server\",\n" +
            "            \"Properties\": {\n" +
            "                \"flavor\": \"m1.small\",\n" +
            "                \"image\": \"centos:latest\"\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        KeystoneTokenProvider keystone = new KeystoneTokenProvider(
                ExamplesConfiguration.KEYSTONE_ENDPOINT,
                ExamplesConfiguration.KEYSTONE_USERNAME,
                ExamplesConfiguration.KEYSTONE_PASSWORD
        );

        Access access = keystone.getAccessByTenant(ExamplesConfiguration.TENANT_NAME);

        String endpointURL = KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "orchestration", null, "public");


        Heat heat = new Heat(endpointURL);
        heat.setTokenProvider(keystone
                .getProviderByTenant(ExamplesConfiguration.TENANT_NAME));

        CreateStackParam param = new CreateStackParam();
        param.setStackName("helloWorld");
        param.setTimeoutMinutes(1);
        param.setParameters(Collections.<String, Object>emptyMap());
        param.setTemplate(TEMPLATE);

        System.out.printf("Create: " + heat.getStacks().create(param).execute());
        Thread.sleep(3000);

        for (Stack s : heat.getStacks().list().execute()) {
            System.out.println(s.getDescription());
            System.out.println(s.getId());
            System.out.println(s.getStackName());
            System.out.println(s.getStackStatus());
            System.out.println(s.getCreationTime());
            System.out.println(s.getUpdatedTime());
            System.out.println(s.getLinks());

            System.out.println(heat.getStacks().byName(s.getStackName()).execute());


        }
    }
}
