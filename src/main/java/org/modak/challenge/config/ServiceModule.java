package org.modak.challenge.config;

import com.google.inject.AbstractModule;

import org.modak.challenge.gateway.GatewayService;
import org.modak.challenge.gateway.impl.GatewayServiceImpl;
import org.modak.challenge.notification.NotificationService;
import org.modak.challenge.notification.impl.NotificationServiceImpl;
import org.modak.challenge.ratelimitservice.RateLimitService;
import org.modak.challenge.ratelimitservice.impl.RateLimitServiceImpl;
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
