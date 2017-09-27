/*-
 * ============LICENSE_START=======================================================
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

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Statistics {
	
	private BigDecimal avg;
	
	private BigDecimal count;
	
	private BigDecimal duration;
	
	@JsonProperty("duration_start")
	private String durationStart;
	
	@JsonProperty("duration_end")
	private String durationEnd;
	
	private BigDecimal max;
	
	private BigDecimal min;
	
	private BigDecimal period;
	
	@JsonProperty("period_start")
	private String periodStart;
	
	@JsonProperty("period_end")
	private String periodEnd;
	
	private BigDecimal sum;

	public BigDecimal getAvg() {
		return avg;
	}

	public BigDecimal getCount() {
		return count;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public String getDurationStart() {
		return durationStart;
	}

	public String getDurationEnd() {
		return durationEnd;
	}

	public BigDecimal getMax() {
		return max;
	}

	public BigDecimal getMin() {
		return min;
	}

	public BigDecimal getPeriod() {
		return period;
	}

	public String getPeriodStart() {
		return periodStart;
	}

	public String getPeriodEnd() {
		return periodEnd;
	}

	public BigDecimal getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "Statistics [avg=" + avg + ", count=" + count + ", duration="
				+ duration + ", durationStart=" + durationStart
				+ ", durationEnd=" + durationEnd + ", max=" + max + ", min="
				+ min + ", period=" + period + ", periodStart=" + periodStart
				+ ", periodEnd=" + periodEnd + ", sum=" + sum + "]";
	}
	
}
