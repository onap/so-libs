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

package com.woorea.openstack.connector;

import java.io.IOException;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class OpenStack {

    public static Client CLIENT;
    
    public static ObjectMapper DEFAULT_MAPPER;
    
    public static ObjectMapper WRAPPED_MAPPER;
    
    static {
        initialize();
    }
    
    private static void initialize() {
        
        /*
        //class MyX509TrustManager implements X509TrustManager
        TrustManager mytm[] = null;
        KeyManager mykm[] = null;

        try {
            mytm = new TrustManager[]{new MyX509TrustManager("./truststore_client", "asdfgh".toCharArray())};
            mykm = new KeyManager[]{new MyX509KeyManager("./keystore_client", "asdfgh".toCharArray())};
        } catch (Exception ex) {

        }
        
        SSLContext context = null;
        context = SSLContext.getInstance("SSL");
        context.init(mykm, mytm, null);
        
        */
        
        try {
            
            SSLContext context;
            context = SSLContext.getInstance("SSL");
            context.init(null, null, null);
            
            SslConfigurator sslConfig = SslConfigurator.newInstance();
                    /*
                    .trustStoreFile("./truststore_client")
                    .trustStorePassword("asdfgh")

                    .keyStoreFile("./keystore_client")
                    .keyPassword("asdfgh");
                    */
                    //old: CLIENT.property(ClientProperties.SSL_CONFIG, new SslConfig(context));
            
            CLIENT = ClientBuilder.newBuilder().sslContext(sslConfig.createSSLContext()).build();
            
            DEFAULT_MAPPER = new ObjectMapper();

            DEFAULT_MAPPER.setSerializationInclusion(Include.NON_NULL);
            DEFAULT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            DEFAULT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

            WRAPPED_MAPPER = new ObjectMapper();

            WRAPPED_MAPPER.setSerializationInclusion(Include.NON_NULL);
            WRAPPED_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            WRAPPED_MAPPER.enable(SerializationFeature.WRAP_ROOT_VALUE);
            WRAPPED_MAPPER.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            WRAPPED_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            WRAPPED_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            WRAPPED_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

            CLIENT.register(new JacksonFeature()).register(new ContextResolver<ObjectMapper>() {

                @Override
                public ObjectMapper getContext(Class<?> type) {
                    return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
                }
                
            });
            
            CLIENT.register(new ClientRequestFilter() {
                
                @Override
                public void filter(ClientRequestContext requestContext) throws IOException {
                    requestContext.getHeaders().remove("Content-Language");
                    requestContext.getHeaders().remove("Content-Encoding");
                }
            });
            
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
    }

}
