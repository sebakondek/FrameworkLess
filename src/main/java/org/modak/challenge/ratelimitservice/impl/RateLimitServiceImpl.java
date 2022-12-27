package org.modak.challenge.ratelimitservice.impl;

import org.modak.challenge.exception.ValidatorNotImplementedException;
import org.modak.challenge.ratelimitservice.RateLimitService;
import org.modak.challenge.ratelimitservice.model.enums.NotificationType;
import org.modak.challenge.ratelimitservice.validator.Validator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class RateLimitServiceImpl implements RateLimitService {

    private static final Map<NotificationType, Validator> VALIDATORS_MAP = new HashMap<>();

    @Inject
    public RateLimitServiceImpl(@Named("newsValidator") Validator newsValidator) {
        VALIDATORS_MAP.put(NotificationType.NEWS, newsValidator);
    }

    @Override
    public void checkRateLimit(Integer userId, NotificationType type) {
        if (VALIDATORS_MAP.containsKey(type)) {
            VALIDATORS_MAP.get(type).validate();
        } else {
            throw new ValidatorNotImplementedException(
                    String.format("%s validator not yet implemented.", type.toString().toLowerCase())
            );
        }
    }
}
