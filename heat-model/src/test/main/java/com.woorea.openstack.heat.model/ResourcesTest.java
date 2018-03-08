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
package com.woorea.openstack.heat.model;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ResourcesTest {

    Resources resources = new Resources();

    @Test
    public void getListTest() throws Exception {
        resources.getList();
    }

    @Test
    public void iteratorTest() throws Exception {
        Resource res = new Resource();
        List<Resource> lists = new ArrayList<>();
        lists.add(res);
        //lists.iterator();
    }
}
