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

import java.util.*;

public class StackTest {

    Stack stack = new Stack();

    @Test
    public void getUpdatedTimeTest() throws Exception {
        stack.getUpdatedTime();
    }

    @Test
    public void setUpdatedTimeTest() throws Exception {
        Date date = new Date();
        date.setTime(3600);
        stack.setUpdatedTime(date);
    }

    @Test
    public void getStackStatusTest() throws Exception {
        stack.getStackStatus();
    }

    @Test
    public void setStackStatusTest() throws Exception {
        stack.setStackStatus("status");
    }

    @Test
    public void getIdTest() throws Exception {
        stack.getId();
    }

    @Test
    public void setIdTest() throws Exception {
        stack.setId("id");
    }

    @Test
    public void getCreationTimeTest() throws Exception {
        stack.getCreationTime();
    }

    @Test
    public void setCreationTimeTest() throws Exception {
        Date date = new Date();
        date.setTime(3600);
        stack.setCreationTime(date);
    }

    @Test
    public void getStackNameTest() throws Exception {
        stack.getStackName();
    }

    @Test
    public void setStackNameTest() throws Exception {
        stack.setStackName("stack");
    }

    @Test
    public void getStackStatusReasonTest() throws Exception {
        stack.getStackStatusReason();
    }

    @Test
    public void setStackStatusReasonTest() throws Exception {
        stack.setStackStatusReason("stack");
    }

    @Test
    public void getLinksTest() throws Exception {
        stack.getLinks();
    }

    @Test
    public void setLinksTest() throws Exception {
        Link link = new Link();
        List<Link> arrayList= new ArrayList<Link>();
        arrayList.add(link);
        stack.setLinks(arrayList);
    }

    @Test
    public void getDescriptionTest() throws Exception {
        stack.getDescription();
    }

    @Test
    public void setDescriptionTest() throws Exception {
        stack.setDescription("description");
    }

    @Test
    public void getFilesTest() throws Exception {
        stack.getFiles();
    }

    @Test
    public void setFilesTest() throws Exception {
        Map<String, Object> files = new HashMap<String,Object>();
        files.put("1",stack);
        stack.setFiles(files);
    }

}
