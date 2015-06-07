package com.lufax.front.spi.impl;

import com.lufax.front.spi.ServiceProvider;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by frank on 15/6/7.
 */
public class JerseyServiceProvider implements ServiceProvider {
    private String appHost = null;

    public JerseyServiceProvider(String appHost){
        this.appHost = appHost;
    }

    @Override
    public Object service(String method, String url, Map<String, String[]> parameters) {
        ClientConfig cf = new ClientConfig();
        Client client = ClientBuilder.newClient(cf);
        String res = client.target(appHost).path(url).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        return res;
    }

    @Override
    public Object get(String url, Map<String, String[]> parameters) {
        return service(ServiceProvider.METHOD_GET,url,parameters);
    }

    @Override
    public boolean post(String url, Map<String, String[]> parameters) {
        return false;
    }

    @Override
    public boolean delete(String url, Map<String, String[]> parameters) {
        return false;
    }

    @Override
    public boolean put(String url, Map<String, String[]> parameters) {
        return false;
    }
}
