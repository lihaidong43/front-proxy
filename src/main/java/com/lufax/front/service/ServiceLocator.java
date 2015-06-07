package com.lufax.front.service;

import com.lufax.front.spi.ServiceProvider;
import com.lufax.front.spi.impl.JerseyServiceProvider;
import com.lufax.front.spi.impl.RestyServiceProvider;

/**
 *
 * service locator
 * Created by frank on 15/6/7.
 */
public final class ServiceLocator  {

    public static ServiceProvider restyService(String appHost){
        return new RestyServiceProvider(appHost);
    }

    public static ServiceProvider jerseyService(String appHost){
        return new JerseyServiceProvider(appHost);
    }
}
