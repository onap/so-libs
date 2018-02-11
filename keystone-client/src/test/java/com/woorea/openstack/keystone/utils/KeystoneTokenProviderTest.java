package com.woorea.openstack.keystone.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeystoneTokenProviderTest {

    KeystoneTokenProvider keystoneTokenProvider = new KeystoneTokenProvider("endpoint",
            "username",
            "password");

    @Test(expected = NullPointerException.class)
    public void getAccessByTenant() throws Exception {
        keystoneTokenProvider.getAccessByTenant("id-123");
    }

    @Test
    public void expireAccessByTenant() throws Exception {
        keystoneTokenProvider.expireAccessByTenant("id-123");
    }

    @Test
    public void getProviderByTenant() throws Exception {
        keystoneTokenProvider.getProviderByTenant("id-123");
    }

}