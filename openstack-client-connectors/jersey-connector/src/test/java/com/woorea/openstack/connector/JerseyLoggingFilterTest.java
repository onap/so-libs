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

package com.woorea.openstack.connector;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.ws.rs.core.MultivaluedMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.sun.jersey.api.client.ClientHandler;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientRequestAdapter;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class JerseyLoggingFilterTest {

	private static Logger logger;
	private static LogFormatter logFormatter;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		logger = Logger.getLogger(JerseyLoggingFilterTest.class.getSimpleName());
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);

		ConsoleHandler handler = new ConsoleHandler();
		logFormatter = new LogFormatter();
		handler.setFormatter(logFormatter);
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
	}

	@Before
	public void setUpTest() {
		logFormatter.clearLog();
	}
	
	/**
	 * Tests a scenario with no request content (GET).
	 * @throws Exception for unexpected errors
	 */
	@Test
	public void testGET() throws Exception {
		String responseContent = "<response>Hello, I am Eliza.</response>";
		execute("GET", "http://www.onap.org/eliza", null, responseContent);
	}
	
	/**
	 * Tests a scenario with request content (POST).
	 * @throws Exception for unexpected errors
	 */
	@Test
	public void testPOST() throws Exception {
		String requestContent = "<request>I feel sad.</request>";
		String responseContent = "<response>Do you often feel sad?</response>";
		execute("POST", "http://www.onap.org/eliza", requestContent, responseContent);
	}

	/**
	 * Runs a single test.
	 * @param httpMethod any HTTP method (POST, GET, ...)
	 * @param url any URL
	 * @param requestContent mock request content, possibly null
	 * @param responseContent mock response content, never null
	 * @throws Exception for unexpected errors
	 */
	private void execute(String httpMethod, String url, String requestContent, String responseContent)
			throws Exception {
		JerseyLoggingFilter loggingFilter = new JerseyLoggingFilter(logger);

		// Mock multi-valued and single valued request headers

		HashMap<String, List<Object>> requestHeaderMap = new HashMap<>();
		requestHeaderMap.put("Accept", Arrays.asList(new Object[]{"application/xml","application/json"}));

		if (requestContent != null) {
			requestHeaderMap.put("Content-Type", Arrays.asList(new Object[]{"application/xml"}));
			requestHeaderMap.put("Content-Length", Arrays.asList(new Object[]{String.valueOf(requestContent.length())}));
		}

		@SuppressWarnings("unchecked")
		MultivaluedMap<String, Object> requestHeaders = mock(MultivaluedMap.class);
		when(requestHeaders.entrySet()).thenReturn(requestHeaderMap.entrySet());

		// Mock the request object

		ClientRequest request = mock(TestClientRequest.class);
		when(request.getURI()).thenReturn(new URI(url));
		when(request.getMethod()).thenReturn(httpMethod);
		when(request.getHeaders()).thenReturn(requestHeaders);

		if (requestContent != null) {
			when(request.getEntity()).thenReturn(requestContent.getBytes("UTF-8"));
		}

		doCallRealMethod().when(request).setAdapter(any(ClientRequestAdapter.class));
		when(request.getAdapter()).thenCallRealMethod();
		request.setAdapter(new DefaultClientRequestAdapter());

		// Mock multi-valued and single valued response headers

		HashMap<String, List<String>> responseHeaderMap = new HashMap<>();
		responseHeaderMap.put("Cache-Control", Arrays.asList(new String[]{"no-cache","no-store"}));
		responseHeaderMap.put("Content-Type", Arrays.asList(new String[]{"application/xml"}));
		responseHeaderMap.put("Content-Length", Arrays.asList(new String[]{String.valueOf(responseContent.length())}));
		@SuppressWarnings("unchecked")
		MultivaluedMap<String, String> responseHeaders = mock(MultivaluedMap.class);
		when(responseHeaders.entrySet()).thenReturn(responseHeaderMap.entrySet());

		// Mock the response object

		ClientResponse response = mock(ClientResponse.class);
		when(response.getStatus()).thenReturn(200);
		when(response.getHeaders()).thenReturn(responseHeaders);
		when(response.getEntityInputStream()).thenReturn(
				new ByteArrayInputStream(responseContent.getBytes("UTF-8")));

		// Mock a handler that returns the response object and set
		// it to be the next filter after the logging filter.

		ClientFilter handler = mock(ClientFilter.class);
		when(handler.handle(request)).then(produceResponse(response));
		Method setNext = ClientFilter.class.getDeclaredMethod("setNext", new Class<?>[]{ClientHandler.class});
		setNext.setAccessible(true);
		setNext.invoke(loggingFilter, new Object[]{handler});

		// Run the request into the logging filter

		loggingFilter.handle(request);

		// Validate resulting the log content

		String log = logFormatter.getLog();

		assertContains(log, "* Client out-bound request");
		assertContains(log, "> " + httpMethod + " " + url);

		for (String header : requestHeaderMap.keySet()) {
			assertContains(log, "> " + header + ": ");
		}

		if (requestContent != null) {
			assertContains(log, requestContent);
		}

		assertContains(log, "* Client in-bound response");
		assertContains(log, "< 200");

		for (String header : responseHeaderMap.keySet()) {
			assertContains(log, "< " + header + ": ");
		}

		assertContains(log, responseContent);
	}
	
	private void assertContains(String log, String expect) {
		assertTrue("Log does not contain '" + expect + "'", log.contains(expect));
	}

	private class DefaultClientRequestAdapter implements ClientRequestAdapter {
		@Override
		public OutputStream adapt(ClientRequest request, OutputStream out) throws IOException {
			return out;
		}
	}

	private abstract class TestClientRequest extends ClientRequest {
		private ClientRequestAdapter adapter;

		@Override
		public ClientRequestAdapter getAdapter() {
			return adapter;
		}

		@Override
		public void setAdapter(ClientRequestAdapter adapter) {
			this.adapter = adapter;
		}
	}
	
	private Answer<ClientResponse> produceResponse(final ClientResponse response) { 
		return new Answer<ClientResponse>() {
			public ClientResponse answer(InvocationOnMock invocation) throws IOException {
				ClientRequest request = (ClientRequest) invocation.getArguments()[0];
				byte[] entity = (byte[]) request.getEntity();

				if (entity != null) {
					ClientRequestAdapter adapter = request.getAdapter();
	
					OutputStream nullOutputStream = new OutputStream() {
						@Override
						public void write(int b) {
							// Discard
						}
					};

					OutputStream outputStream = adapter.adapt(request, nullOutputStream);
					outputStream.write(entity);
					outputStream.close();
				}

				return response;
			}
		};
	}

	private static class LogFormatter extends SimpleFormatter {
		StringBuilder buffer = new StringBuilder();

		public synchronized String getLog() {
			return buffer.toString();
		}

		public synchronized void clearLog() {
			buffer.setLength(0);
		}

		@Override
		public synchronized String format(LogRecord record) {
			String logData = super.format(record);
			buffer.append(logData);
			return logData;
		}
	}
}