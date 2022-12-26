package org.modak.challenge.gateway.impl;

import com.google.inject.Singleton;
import org.modak.challenge.gateway.GatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class GatewayServiceImpl implements GatewayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayServiceImpl.class);

    @Override
    public void send(Integer userId, String message) {
        LOGGER.info("Sending message '{}' to user {}", message, userId);
    }
}
