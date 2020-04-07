.. This work is licensed under a Creative Commons Attribution 4.0 International License.
.. http://creativecommons.org/licenses/by/4.0
.. Copyright 2017 Huawei Intellectual Property.  All rights reserved.
.. _release_notes:


SO Release Notes
================

Openstack Java SDK v2.0 used by SO components.

Version: 1.1.0
--------------


:Release Date: 2017-11-16



**Included Features**

*Ceilometer client*:
    Ceilometer client will collect, normalise and transform data produced by OpenStack services. The data it produces is intended to be used to create different views and help solve various telemetry use cases.
    
*Glance client*: 
    Glance client discover, register, and retrieve virtual machine images.it provide RESTful client to query of VM image metadata as well as retrieval of the actual image.
    
*Heat client*:
    Heat client used for orchestrating the infrastructure resources for a cloud application based on templates in the form of text files that can be treated like code.
    
*Keystone client*:
    Keystone client provides API client authentication, service discovery, and distributed multi-tenant authorization.
    
*Nova client*:
    To implement services and associated libraries to provide massively scalable, on demand, self service access to compute resources, including bare metal, virtual machines, and containers.
    
*Openstack client* :
    Provide a single command-line interface for OpenStack services with a uniform command set and format.
    
*Quantum client* :
    It provides API for delivering networking-as-a-service (NaaS) in virtual compute environments.

*Swift client* :
    Swift client provides functionalities for object storage in OpenStack. Swift is ideal for storing unstructured data that can grow without bound.



**Deprecation Notes**

There is a MSO 1.0.0 SO implementation existing in the pre-R1 ONAP Gerrit system.  
The MSO1.0.0 is deprecated by the R1 release and the current release is built over this release.
The Gerrit repos of mso/* are voided and already locked as read-only.
Following are the deprecated SO projects in gerrit repo:

* mso/libs


**Other**

===========

End of Release Notes
