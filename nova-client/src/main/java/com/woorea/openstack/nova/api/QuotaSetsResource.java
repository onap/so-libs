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

package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Limits;
import com.woorea.openstack.nova.model.QuotaSet;
import com.woorea.openstack.nova.model.SimpleTenantUsage;

public class QuotaSetsResource {

    private final OpenStackClient client;

    public QuotaSetsResource(OpenStackClient client) {
        this.client = client;
    }

    public ShowQuota showQuota(String tenantId) {
        return new ShowQuota(tenantId);
    }

    public UpdateQuota updateQuota(String tenantId, QuotaSet quotaSet) {
        return new UpdateQuota(tenantId, quotaSet);
    }

    public ShowUsage showUsage(String tenantId) {
        return new ShowUsage(tenantId);
    }

    public ShowUsedLimits showUsedLimits() {
        return new ShowUsedLimits();
    }

    public class ShowQuota extends OpenStackRequest<QuotaSet> {

        public ShowQuota(String tenantId) {
            super(client, HttpMethod.GET, "/os-quota-sets/" + tenantId, null, QuotaSet.class);
        }
    }

    public class UpdateQuota extends OpenStackRequest<QuotaSet> {

        public UpdateQuota(String tenantId, QuotaSet quotaSet) {
            super(client, HttpMethod.PUT, "/os-quota-sets/" + tenantId, Entity.json(quotaSet), QuotaSet.class);
        }
    }

    public class ShowUsage extends OpenStackRequest<SimpleTenantUsage> {

        public ShowUsage(String tenantId) {
            super(client, HttpMethod.GET, "/os-simple-tenant-usage/" + tenantId, null, SimpleTenantUsage.class);
        }
    }

    public class ShowUsedLimits extends OpenStackRequest<Limits> {

        public ShowUsedLimits() {
            super(client, HttpMethod.GET, "/limits", null, Limits.class);
        }
    }
}

