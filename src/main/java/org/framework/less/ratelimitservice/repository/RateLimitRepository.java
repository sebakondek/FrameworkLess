package org.framework.less.ratelimitservice.repository;

import org.framework.less.ratelimitservice.model.Notification;

import java.util.List;

public interface RateLimitRepository {
    List<Notification> getEntity(Integer userId);
}
