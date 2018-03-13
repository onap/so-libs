/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
 * ================================================================================ 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package com.woorea.openstack.nova.model;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class LimitsTest {

    private Limits limits = new Limits();
    private Limits.AbsoluteLimit aLimit = new Limits.AbsoluteLimit();
    private Limits.RateLimit rLimit = new Limits.RateLimit();
    private Limits.RateLimit.LimitEntry entry = new Limits.RateLimit.LimitEntry();

    @Test
    public void getNextAvailable() {
         entry.getNextAvailable();
    }

    @Test
    public void getUnit() {
         entry.getUnit();
    }

    @Test
    public void getVerb() {
         entry.getVerb();
    }

    @Test
    public void getRemaining() {
         entry.getRemaining();
    }

    @Test
    public void getAvailable() {
         entry.getAvailable();
    }

    @Test
    public void getValue() {
         entry.getValue();
    }

    @Test
    public void getRate() {
        limits.getRate();
    }

    @Test
    public void getAbsolute() {
        limits.getAbsolute();
    }

    @Test
    public void getRegex() {
         rLimit.getRegex();
    }

    @Test
    public void getUri() {
         rLimit.getUri();
    }

    @Test
    public void getLimit() {
         rLimit.getLimit();
    }

    @Test
    public void getMaxServerMeta() {
        aLimit.getMaxServerMeta();
    }

    @Test
    public void getMaxPersonality() {
        aLimit.getMaxPersonality();
    }

    @Test
    public void getMaxImageMeta() {
        aLimit.getMaxImageMeta();
    }

    @Test
    public void getMaxPersonalitySize() {
         aLimit.getMaxPersonalitySize();
    }

    @Test
    public void getMaxTotalCores() {
         aLimit.getMaxTotalCores();
    }

    @Test
    public void getMaxTotalInstances() {
         aLimit.getMaxTotalInstances();
    }

    @Test
    public void getMaxTotalRAMSize() {
         aLimit.getMaxTotalRAMSize();
    }

    @Test
    public void getTotalVolumesUsed() {
         aLimit.getTotalVolumesUsed();
    }

    @Test
    public void getMaxSecurityGroupRules() {
         aLimit.getMaxSecurityGroupRules();
    }

    @Test
    public void getMaxTotalKeypairs() {
         aLimit.getMaxTotalKeypairs();
    }

    @Test
    public void getTotalCoresUsed() {
         aLimit.getTotalCoresUsed();
    }

    @Test
    public void getMaxTotalVolumes() {
         aLimit.getMaxTotalVolumes();
    }

    @Test
    public void getTotalRAMUsed() {
         aLimit.getTotalRAMUsed();
    }

    @Test
    public void getTotalInstancesUsed() {
         aLimit.getTotalInstancesUsed();
    }

    @Test
    public void getMaxSecurityGroups() {
         aLimit.getMaxSecurityGroups();
    }

    @Test
    public void getTotalVolumeGigabytesUsed() {
         aLimit.getTotalVolumeGigabytesUsed();
    }

    @Test
    public void getTotalSecurityGroupsUsed() {
         aLimit.getTotalSecurityGroupsUsed();
    }

    @Test
    public void getMaxTotalFloatingIps() {
         aLimit.getMaxTotalFloatingIps();
    }

    @Test
    public void getTotalKeyPairsUsed() {
         aLimit.getTotalKeyPairsUsed();
    }

    @Test
    public void getMaxTotalVolumeGigabytes() {
         aLimit.getMaxTotalVolumeGigabytes();
    }

    @Test
    public void getServerMetaUsed() {
         aLimit.getServerMetaUsed();
    }

    @Test
    public void getPersonalityUsed() {
         aLimit.getPersonalityUsed();
    }

    @Test
    public void getImageMetaUsed() {
         aLimit.getImageMetaUsed();
    }

    @Test
    public void getPersonalitySizeUsed() {
         aLimit.getPersonalitySizeUsed();
    }

    @Test
    public void getSecurityGroupRulesUsed() {
         aLimit.getSecurityGroupRulesUsed();
    }

    @Test
    public void getTotalFloatingIpsUsed() {
         aLimit.getTotalFloatingIpsUsed();
    }

}