package org.modak.challenge.config;

import com.google.inject.AbstractModule;
import org.modak.challenge.gateway.GatewayService;
import org.modak.challenge.gateway.impl.GatewayServiceImpl;
import org.modak.challenge.notification.NotificationService;
import org.modak.challenge.notification.impl.NotificationServiceImpl;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NotificationService.class).to(NotificationServiceImpl.class);
        bind(GatewayService.class).to(GatewayServiceImpl.class);
    }
}
