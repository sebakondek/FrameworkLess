package org.modak.challenge.ratelimitservice;

import org.modak.challenge.ratelimitservice.model.enums.NotificationType;

public interface RateLimitService {
    void checkRateLimit(Integer userId, NotificationType type);
}
