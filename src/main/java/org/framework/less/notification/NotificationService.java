package org.framework.less.notification;

import org.framework.less.ratelimitservice.model.enums.NotificationType;

public interface NotificationService {
    void send(NotificationType type, Integer userId, String message);
}
