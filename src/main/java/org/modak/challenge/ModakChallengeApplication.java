package org.modak.challenge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.modak.challenge.config.Config;
import org.modak.challenge.config.RepositoryModule;
import org.modak.challenge.config.ServiceModule;
import org.modak.challenge.config.SqlModule;
import org.modak.challenge.config.ValidatorModule;
import org.modak.challenge.notification.NotificationService;
import org.modak.challenge.ratelimitservice.model.enums.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModakChallengeApplication extends Config {
    public static final Injector APP = injectDependencies();

    private static final Logger LOGGER = LoggerFactory.getLogger(ModakChallengeApplication.class);

    private static Injector injectDependencies() {
        return Guice.createInjector(
                new ServiceModule(),
                new RepositoryModule(),
                new SqlModule(),
                new ValidatorModule()
        );
    }

    public static void main(String[] args) {
        NotificationService service = APP.getInstance(NotificationService.class);

        service.send(NotificationType.NEWS, 1, "news 1");

        service.send(NotificationType.NEWS, 1, "news 2");

        service.send(NotificationType.NEWS, 1, "news 3");

        service.send(NotificationType.STATUS, 2, "news 1");

        service.send(NotificationType.NEWS, 1, "update 1");
    }
}
