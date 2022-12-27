package org.framework.less.notification.impl;

import org.framework.less.gateway.GatewayService;
import org.framework.less.notification.NotificationService;
import org.framework.less.ratelimitservice.RateLimitService;
import org.framework.less.ratelimitservice.model.enums.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final GatewayService gatewayService;
    private final RateLimitService rateLimitService;

    @Inject
    public NotificationServiceImpl(GatewayService gatewayService, RateLimitService rateLimitService) {
        this.gatewayService = gatewayService;
        this.rateLimitService = rateLimitService;
    }

    @Override
    public void send(NotificationType type, Integer userId, String message) {
        this.rateLimitService.checkRateLimit(userId, type);

        this.gatewayService.send(userId, message);
    }
}
