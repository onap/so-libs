.. This work is licensed under a Creative Commons Attribution 4.0 International License.
.. http://creativecommons.org/licenses/by/4.0
.. Copyright 2017 Huawei Intellectual Property.  All rights reserved.


SO Release Notes
================

		   

Version: 1.1.0
--------------


:Release Date: 2017-11-16



**New Features**
The SO provides the highest level of service orchestration in the ONAP architecture.
SO is implemented via BPMN flows that operate on Models distributed from SDC that describe the Services and associated VNFs and other Resource components.
Cloud orchestration currently based on HEAT and TOSCA templates.	
The orchestration engine is a reusable service. Any component of the architecture can execute process workflows. 
Orchestration services can consume a process workflow and execute it. 
The service model maintains consistency and reusability across all orchestration activities and ensures consistent methods, structure and version of the workflow execution environment.
Orchestration processes interact with other platform components or external systems via standard and well-defined APIs.


**Upgrade Notes**
This is the initial release of ONAP SO.

**Deprecation Notes**
There is a MSO 1.0.0 SO implementation existing in the pre-R1 ONAP Gerrit system.  
The MSO1.0.0 is deprecated by the R1 release and the current release is built over this release.
The Gerrit repos of mso/* are voided and already locked as read-only.
Following are the deprecated SO projects in gerrit repo:
mso
mso/chef-repo
mso/docker-config
mso/libs
mso/mso-config
	

**Other**

===========

End of Release Notes
