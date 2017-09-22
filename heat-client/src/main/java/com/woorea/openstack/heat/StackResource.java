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

package com.woorea.openstack.heat;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.CreateStackParam;
import com.woorea.openstack.heat.model.Stack;
import com.woorea.openstack.heat.model.Stacks;
import com.woorea.openstack.heat.model.UpdateStackParam;

public class StackResource {

    private static final String STACKS = "/stacks/";
    private final OpenStackClient client;

    public StackResource(OpenStackClient client) {
        this.client = client;
    }

    public CreateStack create(CreateStackParam param) {
        return new CreateStack(param);
    }

    public UpdateStack update(String name, UpdateStackParam param) {
        return new UpdateStack(name, param);
    }

    public List list() {
        return new List();
    }

    public GetStack byName(String name) {
        return new GetStack(name);
    }

    public DeleteStack deleteByName(String name) {
        return new DeleteStack(name);
    }

    public class CreateStack extends OpenStackRequest<Stack> {

        public CreateStack(CreateStackParam params) {
            super(client, HttpMethod.POST, "/stacks", Entity.json(params), Stack.class);
        }
    }

    public class UpdateStack extends OpenStackRequest<Void> {

        public UpdateStack(String name, UpdateStackParam params) {
            super(client, HttpMethod.PUT, STACKS + name, Entity.json(params), Void.class);
        }
    }

    public class DeleteStack extends OpenStackRequest<Void> {

        public DeleteStack(String name) {
            super(client, HttpMethod.DELETE, STACKS + name, null, Void.class);
        }
    }


    public class GetStack extends OpenStackRequest<Stack> {

        public GetStack(String name) {
            super(client, HttpMethod.GET, STACKS + name, null, Stack.class);
        }
    }

    public class List extends OpenStackRequest<Stacks> {

        public List() {
            super(client, HttpMethod.GET, "/stacks", null, Stacks.class);
        }
    }
}
