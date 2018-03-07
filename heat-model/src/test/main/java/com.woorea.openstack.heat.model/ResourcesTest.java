package com.woorea.openstack.heat.model;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ResourcesTest {

    Resources resources = new Resources();

    @Test
    public void getListTest() throws Exception {
        resources.getList();
    }

    @Test
    public void iteratorTest() throws Exception {
        Resource res = new Resource();
        List<Resource> lists = new ArrayList<>();
        lists.add(res);
        //lists.iterator();
    }
}
