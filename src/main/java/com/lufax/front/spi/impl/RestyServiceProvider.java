package com.lufax.front.spi.impl;

import com.lufax.front.spi.ServiceProvider;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import java.util.Map;

/**
 * Created by frank on 15/6/6.
 */
public class RestyServiceProvider implements ServiceProvider{
    private String appHost = null;

    public RestyServiceProvider(String appHost){
        this.appHost = appHost;
    }

    @Override
    public Object service(String method, String url, Map<String, String[]> parameters) {
        Resty resty = new Resty();
        JSONResource content = null;
        try {
            content = resty.json(serviceUrl(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
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


    private String serviceUrl(String url){
        return appHost + url;
    }

}
