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
package com.woorea.openstack.keystone.api;

import com.woorea.openstack.keystone.model.Metadata;
import com.woorea.openstack.keystone.model.Tenant;
import org.junit.Test;

import static org.junit.Assert.*;

public class TenantsResourceTest {

    TenantsResource tenantsResource = new TenantsResource(null);

    @Test
    public void listTest() throws Exception {
        tenantsResource.list();
    }

    @Test
    public void createTest() throws Exception {
        tenantsResource.create(new Tenant());
    }

    @Test
    public void showTest() throws Exception {
        tenantsResource.show("123");
    }

    @Test
    public void updateTest() throws Exception {
        tenantsResource.update("123", new Tenant());
    }

    @Test
    public void deleteTest() throws Exception {
        tenantsResource.delete("123");
    }

    @Test
    public void listUsersTest() throws Exception {
        tenantsResource.listUsers("123");
    }

    @Test
    public void addUserTest() throws Exception {
        tenantsResource.addUser("123", "123", "123");
    }

    @Test
    public void removeUserTest() throws Exception {
        tenantsResource.removeUser("123", "123", "123");
    }

    @Test
    public void listUserRolesTest() throws Exception {
        tenantsResource.listUserRoles("tenantid", "userid");
    }

    @Test
    public void showMetadataTest() throws Exception {
        tenantsResource.showMetadata("123");
    }

    @Test
    public void createOrUpdateMetadata() throws Exception {
        tenantsResource.createOrUpdateMetadata("123", new Metadata());
    }

    @Test
    public void replaceMetadataTest() throws Exception {
        tenantsResource.replaceMetadata("123", new Metadata());
    }

    @Test
    public void showMetadataItemTest() throws Exception {
        tenantsResource.showMetadataItem("123", "123key");
    }

    @Test
    public void createOrUpdateMetadataItemTest() throws Exception {
        tenantsResource.createOrUpdateMetadataItem("123", "key", new Metadata());
    }

    @Test
    public void deleteMetadataItemTest() throws Exception {
        tenantsResource.deleteMetadataItem("123", "key");
    }

}