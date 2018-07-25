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

package com.woorea.openstack.examples.metering.v2;

import java.util.List;


import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.ceilometer.Ceilometer;
import com.woorea.openstack.ceilometer.v2.model.Meter;
import com.woorea.openstack.ceilometer.v2.model.Statistics;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

public class TestAll {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
        Access access = keystone.tokens()
                .authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
                .withTenantName("admin")
                .execute();
        
        Ceilometer ceilometer = new Ceilometer(ExamplesConfiguration.CEILOMETER_ENDPOINT);
        ceilometer.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

        /*
        List<Resource> resources = ceilometer.execute(new ResourceList().eq("resource_id", "23b55841eedd41e99d5f3f32149ca086"));
        
        
        for(Resource r : resources) {
            Resource resource = ceilometer.execute(new ResourceShow().id(r.getResource()));
        }
        */
        
        /*
        //List<Meter> meters = ceilometer.meters().list().execute(); //execute(new MeterList().eq("project_id", "948eeb593acd4223ad572c49e1ef5709"));
        
        
        for(Meter m : meters) {
            System.out.println(m);
            
//            List<Sample> samples = ceilometer.execute(new MeterShow().name(m.getName()));
//            for(Sample s : samples) {
//                System.out.println("\t" + s);
//            }
            
            List<Statistics> stats = ceilometer.meters().statistics().execute(); // (new MeterStatistics().name(m.getName()));
            for(Statistics s : stats) {
                System.out.println("\t\t" + s);
            }
            
            
        }
        */
        
    }

}
