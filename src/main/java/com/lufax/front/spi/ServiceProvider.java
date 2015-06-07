package com.lufax.front.spi;

import java.util.Map;
import java.util.Objects;

/**
 * Created by frank on 15/6/6.
 * backend app service entrance
 */
public interface ServiceProvider {
    public final static String METHOD_GET = "GET";
    public final static String METHOD_POST = "POST";
    public final static String METHOD_PUT = "PUT";
    public final static String METHOD_DELETE = "DELETE";


    /**
     * app service entrance for web
     * @param method
     * @param url
     * @param parameters
     */
    public Object service(String method, String url, Map<String, String[]> parameters);


    /**
     * http get
     * @param url
     * @param parameters
     * @return json string
     */
    public Object get(String url, Map<String, String[]> parameters);

    /**
     * http post
     * @param url
     * @param parameters
     * @return
     */
    public boolean post(String url,Map<String, String[]> parameters);

    /**
     * http delete
     * @param url
     * @param parameters
     * @return
     */
    public boolean delete(String url,Map<String, String[]> parameters);

    /**
     * http put
     * @param url
     * @param parameters
     * @return
     */
    public boolean put(String url,Map<String, String[]> parameters);
}
