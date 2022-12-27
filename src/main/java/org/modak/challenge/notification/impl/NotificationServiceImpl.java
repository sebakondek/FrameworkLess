package org.modak.challenge.notification.impl;

import org.modak.challenge.gateway.GatewayService;
import org.modak.challenge.notification.NotificationService;
import org.modak.challenge.ratelimitservice.RateLimitService;
import org.modak.challenge.ratelimitservice.impl.RateLimitServiceImpl;
import org.modak.challenge.ratelimitservice.model.enums.NotificationType;
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
