package org.framework.less.ratelimitservice;

import org.framework.less.ratelimitservice.model.enums.NotificationType;

public interface RateLimitService {
    void checkRateLimit(Integer userId, NotificationType type);
}
