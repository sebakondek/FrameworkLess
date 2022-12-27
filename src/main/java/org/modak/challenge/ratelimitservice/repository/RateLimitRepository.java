package org.modak.challenge.ratelimitservice.repository;

import org.modak.challenge.ratelimitservice.model.Notification;

import java.util.List;

public interface RateLimitRepository {
    List<Notification> getEntity(Integer userId);
}
