package org.framework.less.gateway.impl;

import org.framework.less.gateway.GatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class GatewayServiceImpl implements GatewayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayServiceImpl.class);

    @Override
    public void send(Integer userId, String message) {
        LOGGER.info("Sending message '{}' to user {}", message, userId);
    }
}
