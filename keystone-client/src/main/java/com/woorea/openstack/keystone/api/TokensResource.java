package com.woorea.openstack.keystone.api;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Authentication;
import com.woorea.openstack.keystone.model.authentication.AccessKey;
import com.woorea.openstack.keystone.model.authentication.TokenAuthentication;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

public class TokensResource {

    private final OpenStackClient client;

    public TokensResource(OpenStackClient client) {
        this.client = client;
    }

    public Authenticate.Builder authenticate() {
        return new Authenticate().new Builder();
    }

    public Authenticate authenticate(Authentication authentication) {
        return new Authenticate(authentication);
    }

    public class Authenticate extends OpenStackRequest<Access> {

        private Authentication authentication;

        public Authenticate() {

        }

        public Authenticate(Authentication authentication) {
            super(client, HttpMethod.POST, "/tokens", Entity.json(authentication), Access.class);
            this.authentication = authentication;
        }

        public Authenticate withTenantId(String tenantId) {
            authentication.setTenantId(tenantId);
            return this;
        }

        public Authenticate withTenantName(String tenantName) {
            authentication.setTenantName(tenantName);
            return this;
        }

        public class Builder {

            public Authenticate withUsernamePassword(String username, String password) {
                return new Authenticate(new UsernamePassword(username, password));
            }

            public Authenticate withToken(String token) {
                return new Authenticate(new TokenAuthentication(token));
            }

            public Authenticate withAccessKey(String accessKey, String secretKey) {
                return new Authenticate(new AccessKey(accessKey, secretKey));
            }
        }
    }
}
