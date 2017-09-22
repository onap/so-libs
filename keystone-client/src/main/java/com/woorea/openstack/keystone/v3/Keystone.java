package com.woorea.openstack.keystone.v3;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.keystone.v3.api.DomainsResource;
import com.woorea.openstack.keystone.v3.api.EndpointsResource;
import com.woorea.openstack.keystone.v3.api.ProjectsResource;
import com.woorea.openstack.keystone.v3.api.RolesResource;
import com.woorea.openstack.keystone.v3.api.ServicesResource;
import com.woorea.openstack.keystone.v3.api.TokensResource;
import com.woorea.openstack.keystone.v3.api.UsersResource;

public class Keystone extends OpenStackClient {

    private final TokensResource tokens;

    private final DomainsResource domains;

    private final ProjectsResource projects;

    private final UsersResource users;

    private final RolesResource roles;

    private final ServicesResource services;

    private final EndpointsResource endpoints;

    public Keystone(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        tokens = new TokensResource(this);
        domains = new DomainsResource(this);
        projects = new ProjectsResource(this);
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

    public DomainsResource domains() {
        return domains;
    }

    public ProjectsResource projects() {
        return projects;
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

