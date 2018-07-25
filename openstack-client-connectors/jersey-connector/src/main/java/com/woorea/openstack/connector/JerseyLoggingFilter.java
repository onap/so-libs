/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import com.sun.jersey.api.client.AbstractClientRequestAdapter;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientRequestAdapter;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.core.util.ReaderWriter;

/**
 * A Jersey client filter that writes the request and response to a specified logger.
 */
public class JerseyLoggingFilter extends ClientFilter {

    private final AtomicLong counter = new AtomicLong(0);
    private final Logger logger;

    /**
     * Constructor
     * @param logger the logger to which the request and response are written.
     */
    public JerseyLoggingFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
        long id = counter.incrementAndGet();
        logRequest(id, request);
        ClientResponse response = getNext().handle(request);
        logResponse(id, response);
        return response;
    }

    /**
     * Logs a request.
     * @param id the request id (counter)
     * @param request the request
     */
    private void logRequest(long id, ClientRequest request) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(" * Client out-bound request\n");

        builder.append(String.valueOf(id));
        builder.append(" > ");
        builder.append(request.getMethod());
        builder.append(" ");
        builder.append(request.getURI().toASCIIString());
        builder.append("\n");

        // Request headers

        for (Map.Entry<String, List<Object>> entry : request.getHeaders().entrySet()) {
            String header = entry.getKey();
            List<Object> values = entry.getValue();

            if (values.size() == 1) {
                builder.append(String.valueOf(id));
                builder.append(" > ");
                builder.append(header);
                builder.append(": ");
                builder.append(ClientRequest.getHeaderValue(values.get(0)));
                builder.append("\n");
            } else {
                StringBuilder buf = new StringBuilder();
                boolean first = true;

                for(Object value : values) {
                    if (first) {
                        first = false;
                    } else {
                        buf.append(",");
                    }

                    buf.append(ClientRequest.getHeaderValue(value));
                }

                builder.append(String.valueOf(id));
                builder.append(" > ");
                builder.append(header);
                builder.append(": ");
                builder.append(buf.toString());
                builder.append("\n");
            }
        }

        // Request body

        if (request.getEntity() != null) {
            request.setAdapter(new JerseyLoggingAdapter(request.getAdapter(), builder));
        } else {
            logger.info(builder.toString());
        }
    }

    /**
     * Logs a response.
     * @param id the request id (counter)
     * @param response the response
     */
    private void logResponse(long id, ClientResponse response) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(" * Client in-bound response\n");

        builder.append(String.valueOf(id));
        builder.append(" < ");
        builder.append(String.valueOf(response.getStatus()));
        builder.append("\n");

        // Response headers

        for (Map.Entry<String, List<String>> entry : response.getHeaders().entrySet()) {
            String header = entry.getKey();
            for (String value : entry.getValue()) {
                builder.append(String.valueOf(id));
                builder.append(" < ");
                builder.append(header);
                builder.append(": ");
                builder.append(value).append("\n");
            }
        }

        // Response body

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = response.getEntityInputStream();
        try {
            ReaderWriter.writeTo(in, out);

            byte[] requestEntity = out.toByteArray();
            appendToBuffer(builder, requestEntity);
            response.setEntityInputStream(new ByteArrayInputStream(requestEntity));
        } catch (IOException ex) {
            throw new ClientHandlerException(ex);
        }

        logger.info(builder.toString());
    }

    /**
     * Appends bytes to the builder. If the bytes contain the password pattern,
     * the password is obliterated.
     * @param builder the builder
     * @param bytes the bytes to append
     */
    private void appendToBuffer(StringBuilder builder, byte[] bytes) {
        if (bytes.length != 0) {
            String s = new String(bytes);
            builder.append(s.replaceAll("\"password\".*:.*\"(.*)\"", "\"password\" : \"******\""));
            builder.append("\n");
        }
    }

    private class JerseyLoggingAdapter extends AbstractClientRequestAdapter {
        private final StringBuilder builder;

        JerseyLoggingAdapter(ClientRequestAdapter adapter, StringBuilder builder) {
            super(adapter);
            this.builder = builder;
        }

        @Override
        public OutputStream adapt(ClientRequest request, OutputStream out) throws IOException {
            return new JerseyLoggingOutputStream(getAdapter().adapt(request, out), builder);
        }
    }

    private class JerseyLoggingOutputStream extends OutputStream {
        private final OutputStream stream;
        private final StringBuilder builder;
        private final ByteArrayOutputStream logStream = new ByteArrayOutputStream();

        JerseyLoggingOutputStream(OutputStream stream, StringBuilder builder) {
            this.stream = stream;
            this.builder = builder;
        }

        @Override
        public void write(int value) throws IOException {
            logStream.write(value);
            stream.write(value);
        }

        @Override
        public void close() throws IOException {
            appendToBuffer(builder, logStream.toByteArray());
            logger.info(builder.toString());
            stream.close();
        }
    }
}