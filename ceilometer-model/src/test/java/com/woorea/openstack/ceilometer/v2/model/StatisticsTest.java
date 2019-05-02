/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 AT&T Intellectual Property. All rights reserved.
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

package com.woorea.openstack.ceilometer.v2.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class StatisticsTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"avg\" : 79," + EOL + "  \"count\" : 14," + EOL
            + "  \"duration\" : 31," + EOL + "  \"max\" : 87," + EOL + "  \"min\" : 85," + EOL + "  \"period\" : 4,"
            + EOL + "  \"sum\" : 2," + EOL + "  \"duration_start\" : \"durationstart\"," + EOL
            + "  \"duration_end\" : \"durationend\"," + EOL + "  \"period_start\" : \"periodstart\"," + EOL
            + "  \"period_end\" : \"periodend\"" + EOL + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Statistics.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Statistics statistics = objectMapper.readValue(JSON_FULL, Statistics.class);
        String json = objectMapper.writeValueAsString(statistics);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Statistics statistics = objectMapper.readValue(JSON_FULL, Statistics.class);
        statistics.toString();

        BigDecimal duration = statistics.getDuration();
        Assert.assertNotNull(duration);

        BigDecimal period = statistics.getPeriod();
        Assert.assertNotNull(period);

        BigDecimal avg = statistics.getAvg();
        Assert.assertNotNull(avg);

        BigDecimal min = statistics.getMin();
        Assert.assertNotNull(min);

        String durationStart = statistics.getDurationStart();
        Assert.assertNotNull(durationStart);

        BigDecimal max = statistics.getMax();
        Assert.assertNotNull(max);

        String durationEnd = statistics.getDurationEnd();
        Assert.assertNotNull(durationEnd);

        BigDecimal count = statistics.getCount();
        Assert.assertNotNull(count);

        BigDecimal sum = statistics.getSum();
        Assert.assertNotNull(sum);

        String periodStart = statistics.getPeriodStart();
        Assert.assertNotNull(periodStart);

        String periodEnd = statistics.getPeriodEnd();
        Assert.assertNotNull(periodEnd);
    }
}
