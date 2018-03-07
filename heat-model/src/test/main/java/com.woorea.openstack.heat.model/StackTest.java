package com.woorea.openstack.heat.model;


import org.junit.Test;

import java.util.*;

public class StackTest {

    Stack stack = new Stack();

    @Test
    public void getUpdatedTimeTest() throws Exception {
        stack.getUpdatedTime();
    }

    @Test
    public void setUpdatedTimeTest() throws Exception {
        Date date = new Date();
        date.setTime(3600);
        stack.setUpdatedTime(date);
    }

    @Test
    public void getStackStatusTest() throws Exception {
        stack.getStackStatus();
    }

    @Test
    public void setStackStatusTest() throws Exception {
        stack.setStackStatus("status");
    }

    @Test
    public void getIdTest() throws Exception {
        stack.getId();
    }

    @Test
    public void setIdTest() throws Exception {
        stack.setId("id");
    }

    @Test
    public void getCreationTimeTest() throws Exception {
        stack.getCreationTime();
    }

    @Test
    public void setCreationTimeTest() throws Exception {
        Date date = new Date();
        date.setTime(3600);
        stack.setCreationTime(date);
    }

    @Test
    public void getStackNameTest() throws Exception {
        stack.getStackName();
    }

    @Test
    public void setStackNameTest() throws Exception {
        stack.setStackName("stack");
    }

    @Test
    public void getStackStatusReasonTest() throws Exception {
        stack.getStackStatusReason();
    }

    @Test
    public void setStackStatusReasonTest() throws Exception {
        stack.setStackStatusReason("stack");
    }

    @Test
    public void getLinksTest() throws Exception {
        stack.getLinks();
    }

    @Test
    public void setLinksTest() throws Exception {
        Link link = new Link();
        List<Link> arrayList= new ArrayList<Link>();
        arrayList.add(link);
        stack.setLinks(arrayList);
    }

    @Test
    public void getDescriptionTest() throws Exception {
        stack.getDescription();
    }

    @Test
    public void setDescriptionTest() throws Exception {
        stack.setDescription("description");
    }

    @Test
    public void getFilesTest() throws Exception {
        stack.getFiles();
    }

    @Test
    public void setFilesTest() throws Exception {
        Map<String, Object> files = new HashMap<String,Object>();
        files.put("1",stack);
        stack.setFiles(files);
    }

}
