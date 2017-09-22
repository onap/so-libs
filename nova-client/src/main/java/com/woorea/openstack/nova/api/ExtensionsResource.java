package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Extensions;

public class ExtensionsResource {

    private final OpenStackClient client;

    public ExtensionsResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public class List extends OpenStackRequest<Extensions> {

        public List(boolean detail) {
            super(client, HttpMethod.GET, detail ? "extensions/detail" : "extensions", null, Extensions.class);
        }
    }
}

