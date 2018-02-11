package com.woorea.openstack.keystone.utils;

import com.woorea.openstack.keystone.model.Access.Service;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KeystoneUtilsTest {
    @Test(expected = RuntimeException.class)
    public void findEndpointURL() throws Exception {
        Service service = new Service();
        List<Service> services = Arrays.asList(service);
        KeystoneUtils.findEndpointURL(services, "type", "region", "facing");
    }

}