package org.framework.less.config;

import com.google.inject.AbstractModule;

import org.framework.less.gateway.impl.GatewayServiceImpl;
import org.framework.less.gateway.GatewayService;
import org.framework.less.notification.NotificationService;
import org.framework.less.notification.impl.NotificationServiceImpl;
import org.framework.less.ratelimitservice.RateLimitService;
import org.framework.less.ratelimitservice.impl.RateLimitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class ServiceModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initializing Services");

        bind(NotificationService.class).to(NotificationServiceImpl.class);
        bind(GatewayService.class).to(GatewayServiceImpl.class);
        bind(RateLimitService.class).to(RateLimitServiceImpl.class);

        LOGGER.info("Successfully initialized Services");

    }
}
