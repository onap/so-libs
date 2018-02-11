package com.woorea.openstack.keystone.v3;

import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeystoneTest {

    Keystone keystone = new Keystone("http://127.0.0.1", new OpenStackClientConnector() {
        @Override
        public <T> OpenStackResponse request(OpenStackRequest<T> request) {
            return null;
        }
    });

    @Test
    public void tokens() throws Exception {
        keystone.tokens();
    }

    @Test
    public void domains() throws Exception {
        keystone.domains();
    }

    @Test
    public void projects() throws Exception {
        keystone.projects();
    }

    @Test
    public void users() throws Exception {
        keystone.users();
    }

    @Test
    public void roles() throws Exception {
        keystone.roles();
    }

    @Test
    public void services() throws Exception {
        keystone.services();
    }

    @Test
    public void endpoints() throws Exception {
        keystone.endpoints();
    }

}