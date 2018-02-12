package com.woorea.openstack.nova.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;

public class SimpleTenantUsageTest {

    SimpleTenantUsage simpleTenantUsage = new SimpleTenantUsage();

    @Test
    public void getTotalMemoryMbUsage() throws Exception {
        simpleTenantUsage.getTotalMemoryMbUsage();
    }

    @Test
    public void setTotalMemoryMbUsage() throws Exception {
        simpleTenantUsage.setTotalMemoryMbUsage(new BigDecimal(1));
    }

    @Test
    public void getTotalVcpusUsage() throws Exception {
        simpleTenantUsage.getTotalVcpusUsage();
    }

    @Test
    public void setTotalVcpusUsage() throws Exception {
        simpleTenantUsage.setTotalVcpusUsage(new BigDecimal(1));
    }

    @Test
    public void getTotalLocalGbUsage() throws Exception {
        simpleTenantUsage.getTotalLocalGbUsage();
    }

    @Test
    public void setTotalLocalGbUsage() throws Exception {
        simpleTenantUsage.setTotalLocalGbUsage(BigDecimal.ONE);
    }

    @Test
    public void getStart() throws Exception {
        simpleTenantUsage.getStart();
    }

    @Test
    public void setStart() throws Exception {
        simpleTenantUsage.setStart("test");
    }

    @Test
    public void getStop() throws Exception {
        simpleTenantUsage.getStop();
    }

    @Test
    public void setStop() throws Exception {
        simpleTenantUsage.setStop("test");
    }

    @Test
    public void getTenantId() throws Exception {
        simpleTenantUsage.getTenantId();
    }

    @Test
    public void setTenantId() throws Exception {
        simpleTenantUsage.setTenantId("test");
    }

    @Test
    public void getTotalHours() throws Exception {
        simpleTenantUsage.getTotalHours();
    }

    @Test
    public void setTotalHours() throws Exception {
        simpleTenantUsage.setTotalHours("test");
    }

    @Test
    public void getServerUsages() throws Exception {
        simpleTenantUsage.getServerUsages();
    }

    @Test
    public void setServerUsages() throws Exception {
        simpleTenantUsage.setServerUsages(Collections.<SimpleTenantUsage.ServerUsage>emptyList());
    }

}