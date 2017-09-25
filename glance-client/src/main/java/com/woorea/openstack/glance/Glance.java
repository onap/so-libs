package com.woorea.openstack.glance;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Glance extends OpenStackClient {

    private final ImagesResource images;

    private final SharedImagesResource sharedImages;

    public Glance(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        images = new ImagesResource(this);
        sharedImages = new SharedImagesResource(this);
    }

    public Glance(String endpoint) {
        this(endpoint, null);
    }

    public final ImagesResource images() {
        return images;
    }

    public final SharedImagesResource sharedImages() {
        return sharedImages;
    }
}
