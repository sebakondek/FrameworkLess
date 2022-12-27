package org.modak.challenge.notification.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.modak.challenge.gateway.GatewayService;
import org.modak.challenge.notification.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final GatewayService gatewayService;

    @Inject
    public NotificationServiceImpl( GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @Override
    public void send(String type, Integer userId, String message) {
        this.gatewayService.send(userId, message);
    }
}
