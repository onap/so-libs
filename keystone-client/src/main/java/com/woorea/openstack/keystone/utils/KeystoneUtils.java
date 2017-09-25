package com.woorea.openstack.keystone.utils;

import com.woorea.openstack.keystone.model.Access.Service;
import java.util.List;

public class KeystoneUtils {

    private KeystoneUtils() {
    }

    public static String findEndpointURL(List<Service> serviceCatalog, String type, String region, String facing) {
        for (Service service : serviceCatalog) {
            if (type.equals(service.getType())) {
                for (Service.Endpoint endpoint : service.getEndpoints()) {
                    String url = handleServiceEndPoints(endpoint, region, facing);
                    if (url != null) {
                        return url;
                    }
                }
            }
        }
        throw new RuntimeException("endpoint url not found");
    }

    private static String handleServiceEndPoints(Service.Endpoint endpoint, String region, String facing) {
        if (region == null || region.equals(endpoint.getRegion())) {
            switch (facing) {
                case "public":
                    return endpoint.getPublicURL();
                case "internal":
                    return endpoint.getInternalURL();
                case "admin":
                    return endpoint.getAdminURL();
                default:
                    return null;
            }
        }
        return null;
    }
}
