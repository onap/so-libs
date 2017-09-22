package com.woorea.openstack.keystone.utils;

import com.woorea.openstack.base.client.OpenStackTokenProvider;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import java.util.concurrent.ConcurrentHashMap;

public class KeystoneTokenProvider {

    protected Keystone keystone;

    protected String username;

    protected String password;

    protected ConcurrentHashMap<String, Access> hashTenantAccess;

    public KeystoneTokenProvider(String endpoint, String username, String password) {
        keystone = new Keystone(endpoint);
        this.username = username;
        this.password = password;
        hashTenantAccess = new ConcurrentHashMap<>();
    }

    public Access getAccessByTenant(String tenantName) {
        Access access = hashTenantAccess.get(tenantName);
        if (access == null) {
            access = keystone.tokens().authenticate(new UsernamePassword(username, password))
                .withTenantName(tenantName)
                .execute();
            hashTenantAccess.put(tenantName, access);
        }
        return access;
    }

    public void expireAccessByTenant(String tenantName) {
        hashTenantAccess.remove(tenantName);
    }

    public OpenStackTokenProvider getProviderByTenant(final String tenantName) {
        final KeystoneTokenProvider keystoneTokenProvider = this;
        return new OpenStackTokenProvider() {
            @Override
            public String getToken() {
                return keystoneTokenProvider.getAccessByTenant(tenantName)
                    .getToken().getId();
            }

            @Override
            public void expireToken() {
                keystoneTokenProvider.expireAccessByTenant(tenantName);
            }
        };
    }
}
