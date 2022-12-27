package org.modak.challenge.notification;

import org.modak.challenge.ratelimitservice.model.enums.NotificationType;

public interface NotificationService {
    void send(NotificationType type, Integer userId, String message);
}
