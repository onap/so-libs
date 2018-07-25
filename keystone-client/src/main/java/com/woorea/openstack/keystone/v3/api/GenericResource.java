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

package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;

public class GenericResource<One, Many> {

    protected final OpenStackClient CLIENT;
    
    protected CharSequence path;
    
    protected Class<One> oneClass;
    protected Class<Many> manyClass;
    
    public GenericResource(OpenStackClient client, CharSequence path, Class<One> oneClass, Class<Many> manyClass) {
        CLIENT = client;
        this.path = path;
        this.oneClass = oneClass;
        this.manyClass = manyClass;
    }
    
    public OpenStackRequest<Many> list() {
        return new OpenStackRequest<>(CLIENT, HttpMethod.GET, path, null, manyClass);
    }
    
    public OpenStackRequest<One> create(One one) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.POST, path, Entity.json(one), oneClass);
    }
    
    public OpenStackRequest<One> show(String id) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.GET, new StringBuilder(path).append("/").append(id).toString(), null, oneClass);
    }
    
    public OpenStackRequest<One> update(String id, One one) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.PATCH, new StringBuilder(path).append("/").append(id).toString(), Entity.json(one), oneClass);
    }
    
    public OpenStackRequest<One> delete(String id) {
        return new OpenStackRequest<>(CLIENT, HttpMethod.DELETE, new StringBuilder(path).append("/").append(id).toString(), null, oneClass);
    }
    
}
