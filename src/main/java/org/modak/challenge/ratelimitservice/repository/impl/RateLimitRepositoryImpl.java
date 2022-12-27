package org.modak.challenge.ratelimitservice.repository.impl;

import org.modak.challenge.ratelimitservice.model.Notification;
import org.modak.challenge.ratelimitservice.repository.RateLimitRepository;

import java.util.List;

public class RateLimitRepositoryImpl implements RateLimitRepository {
    @Override
    public List<Notification> getEntity(Integer userId) {
        return null;
    }
}
