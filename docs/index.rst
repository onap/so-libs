.. This work is licensed under a Creative Commons Attribution 4.0 International License.
.. http://creativecommons.org/licenses/by/4.0
.. Copyright 2018 Huawei Technologies Co., Ltd.

ONAP SO/libs Documentation
===========================
    Openstack Java SDK v2.0 used by SO components.

**Ceilometer client**:
    Ceilometer client will collect, normalise and transform data produced by OpenStack services. The data it produces is intended to be used to create different views and help solve various telemetry use cases.
    
**Glance client**: 
    Glance client discover, register, and retrieve virtual machine images.it provide RESTful client to query of VM image metadata as well as retrieval of the actual image.
    
**Heat client**:
    Heat client used for orchestrating the infrastructure resources for a cloud application based on templates in the form of text files that can be treated like code.
    
**Keystone client**:
    Keystone client provides API client authentication, service discovery, and distributed multi-tenant authorization.
    
**Nova client**:
    To implement services and associated libraries to provide massively scalable, on demand, self service access to compute resources, including bare metal, virtual machines, and containers.
    
**Openstack client** :
    Provide a single command-line interface for OpenStack services with a uniform command set and format.
    
**Quantum client** :
    It provides API for delivering networking-as-a-service (NaaS) in virtual compute environments.

**Swift client** :
    Swift client provides functionalities for object storage in OpenStack. Swift is ideal for storing unstructured data that can grow without bound.


Building SO/libs
-----------------

Build software with unit tests
------------------------------

.. code-block:: bash

  cd $HOME/onap/workspace/SO/libs

  $HOME/onap/apache-maven-3.3.9/bin/mvn -s $HOME/onap/.m2/settings.xml clean install


Build software without unit tests
----------------------------------

.. code-block:: bash

  cd $HOME/onap/workspace/SO/libs

  $HOME/onap/apache-maven-3.3.9/bin/mvn -s $HOME/onap/.m2/settings.xml -DskipTests -Dmaven.test.skip=true clean install
