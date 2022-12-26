package org.modak.challenge.notification;

public interface NotificationService {
    void send(String type, Integer userId, String message);
}
