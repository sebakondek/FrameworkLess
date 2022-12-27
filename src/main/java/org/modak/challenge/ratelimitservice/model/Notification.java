package org.modak.challenge.ratelimitservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modak.challenge.ratelimitservice.model.enums.NotificationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    private Integer userId;
    private NotificationType type;
}
