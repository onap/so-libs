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

package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.keystone.v3.model.Authentication;
import com.woorea.openstack.keystone.v3.model.Token;

public class TokensResource {
	
	private final OpenStackClient CLIENT;
	
	public TokensResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public Authenticate authenticate(Authentication authentication) {
		return new Authenticate(authentication);
	}
	
	public OpenStackRequest<Token> show() {
		return CLIENT.get("/auth/tokens", Token.class);
	}

	public class Authenticate extends OpenStackRequest<Token> {
		
		private Authentication authentication;
		
		public Authenticate() {
			
		}
		
		public Authenticate(Authentication authentication) {
			super(CLIENT, HttpMethod.POST, "/auth/tokens", Entity.json(authentication), Token.class);
			this.authentication = authentication;
		}

	}
	
}

