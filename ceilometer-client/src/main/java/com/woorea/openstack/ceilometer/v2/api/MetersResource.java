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

package com.woorea.openstack.ceilometer.v2.api;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.ceilometer.v2.model.Sample;

public class MetersResource {

    private final OpenStackClient client;

    public MetersResource(OpenStackClient client) {
        this.client = client;
    }

    public List list() {
        return new List();
    }

    public Show show() {
        return new Show();
    }

    public Statistics statistics() {
        return new Statistics();
    }

    public class List extends QueriableCeilometerCommand<List, java.util.List<Sample>> {
        public List() {

        }
    }

    public class Show extends QueriableCeilometerCommand<Show, java.util.List<Sample>> {

        private String name;

        public Show() {

        }

        public Show name(String name) {
            this.name = name;
            return this;
        }

    }

    public class Statistics extends QueriableCeilometerCommand<Statistics, java.util.List<Statistics>> {

        private String name;

        public Statistics() {

        }

        public Statistics name(String name) {
            this.name = name;
            return this;
        }

    }

}
