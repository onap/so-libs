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

package com.woorea.openstack.console.keystone;

import org.apache.commons.cli.CommandLine;

import com.woorea.openstack.console.utils.Column;
import com.woorea.openstack.console.utils.Table;
import com.woorea.openstack.console.utils.TableModel;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Tenant;
import com.woorea.openstack.keystone.model.Tenants;

public class KeystoneTenantList extends KeystoneCommand {
    
    public KeystoneTenantList() {
        super("tenant-list");
    }

    @Override
    public void execute(Keystone keystone, CommandLine args) {
        
        final Tenants tenants = keystone.tenants().list().execute();
        
        Table t = new Table(new TableModel<Tenant>(tenants.getList()) {

            @Override
            public Column[] getHeaders() {
                return new Column[]{
                    new Column("id", 32, Column.ALIGN_LEFT),
                    new Column("name", 32, Column.ALIGN_LEFT),
                    new Column("description", 32, Column.ALIGN_LEFT),
                    new Column("enabled", 7, Column.ALIGN_LEFT)
                };
            }

            @Override
            public String[] getRow(Tenant tenant) {
                return new String[]{
                    tenant.getId(),
                    tenant.getName(),
                    tenant.getDescription(),
                    tenant.getEnabled().toString()
                };
            }
        });
        System.out.println(t.render());
    }

}
