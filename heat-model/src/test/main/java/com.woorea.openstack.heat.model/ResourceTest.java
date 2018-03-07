package com.woorea.openstack.heat.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceTest {

    Resource resource = new Resource();

    @Test
    public void getStatusReasonTest() throws Exception {
        resource.getStatusReason();
    }

    @Test
    public void setStatusReasonTest() throws Exception {
        resource.setStatusReason("status");
    }

    @Test
    public void getLogicalResourceIdTest() throws Exception {
        resource.getLogicalResourceId();
    }

    @Test
    public void setLogicalResourceIdTest() throws Exception {
        resource.setLogicalResourceId("resourceId");
    }

    @Test
    public void getStatusTest() throws Exception {
        resource.getStatus();
    }

    @Test
    public void setStatusTest() throws Exception {
        resource.setStatus("status");
    }

    @Test
    public void getPhysicalResourceIdTest() throws Exception {
        resource.getPhysicalResourceId();
    }

    @Test
    public void setPhysicalResourceIdTest() throws Exception {
        resource.setPhysicalResourceId("resourceId");
    }

    @Test
    public void getRequiredByTest() throws Exception {
        resource.getRequiredBy();
    }

    @Test
    public void setRequiredByTest() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("testString");
        resource.setRequiredBy(list);
    }

    @Test
    public void getUpdatedTimeTest() throws Exception {
        resource.getUpdatedTime();
    }

    @Test
    public void setUpdatedTimeTest() throws Exception {
        Date date = new Date();
        date.setTime(3600);
        resource.setUpdatedTime(date);
    }

    @Test
    public void getTypeTest() throws Exception {
        resource.getType();
    }

    @Test
    public void setTypeTest() throws Exception {
        resource.setType("type");
    }

    @Test
    public void getNameTest() throws Exception {
        resource.getName();
    }

    @Test
    public void setNameTest() throws Exception {
        resource.setName("name");
    }

    @Test
    public void getLinksTest() throws Exception {
        resource.getLinks();
    }

    @Test
    public void setLinksTest() throws Exception {
        Link link = new Link();
        List<Link> arrayList= new ArrayList<Link>();
        arrayList.add(link);
        resource.setLinks(arrayList);
    }

}
