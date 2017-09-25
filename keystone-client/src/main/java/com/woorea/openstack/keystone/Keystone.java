package com.woorea.openstack.keystone;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.keystone.api.EndpointsResource;
import com.woorea.openstack.keystone.api.RolesResource;
import com.woorea.openstack.keystone.api.ServicesResource;
import com.woorea.openstack.keystone.api.TenantsResource;
import com.woorea.openstack.keystone.api.TokensResource;
import com.woorea.openstack.keystone.api.UsersResource;

public class Keystone extends OpenStackClient {

    private final TokensResource tokens;

    private final TenantsResource tenants;

    private final UsersResource users;

    private final RolesResource roles;

    private final ServicesResource services;

    private final EndpointsResource endpoints;

    public Keystone(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        tokens = new TokensResource(this);
        tenants = new TenantsResource(this);
        users = new UsersResource(this);
        roles = new RolesResource(this);
        services = new ServicesResource(this);
        endpoints = new EndpointsResource(this);
    }

    public Keystone(String endpoint) {
        this(endpoint, null);
    }

    public TokensResource tokens() {
        return tokens;
    }

    public TenantsResource tenants() {
        return tenants;
    }

    public UsersResource users() {
        return users;
    }

    public RolesResource roles() {
        return roles;
    }

    public ServicesResource services() {
        return services;
    }

    public EndpointsResource endpoints() {
        return endpoints;
    }
}
