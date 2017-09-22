package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Metadata;

public class FlavorsResource {

    private final OpenStackClient client;

    public FlavorsResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Create create(Flavor flavor) {
        return new Create(flavor);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }


    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Flavors> {

        public List(boolean detail) {
            super(client, HttpMethod.GET, detail ? "/flavors/detail" : "/flavors", null, Flavors.class);
        }
    }

    public class Create extends OpenStackRequest<Flavor> {

        private Flavor flavor;

        public Create(Flavor flavor) {
            super(client, HttpMethod.POST, "/flavors", Entity.json(flavor), Flavor.class);
            this.flavor = flavor;
        }
    }

    public class Show extends OpenStackRequest<Flavor> {

        public Show(String id) {
            super(client, HttpMethod.GET, getFlavorsString(id), null, Flavor.class);
        }
    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(client, HttpMethod.GET, "/flavors/" + id + "/metadata", null, Metadata.class);
        }
    }

    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, getFlavorsString(id), null, Void.class);
        }
    }

    private String getFlavorsString(String id) {
        return "/flavors/" + id;
    }
}

