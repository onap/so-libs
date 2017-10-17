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

package com.woorea.openstack.base.client;

/*
 * Modifications copyright (c) 2017 AT&T Intellectual Property
 */

public class OpenStackResponseException extends OpenStackBaseException {

	private static final long serialVersionUID = 7294957362769575271L;

	protected String message;

	protected int status;
	
	// Make the response available for exception handling (includes body)
	protected OpenStackResponse response;

	public OpenStackResponseException(String message, int status) {
		this.message = message;
		this.status = status;
		this.response = null;
	}

	public OpenStackResponseException(String message, int status, OpenStackResponse response) {
		this.message = message;
		this.status = status;
		this.response = response;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public OpenStackResponse getResponse() {
		return response;
	}

}
