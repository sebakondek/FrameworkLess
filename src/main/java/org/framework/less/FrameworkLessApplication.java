package org.framework.less;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.framework.less.config.Config;
import org.framework.less.config.ServiceModule;
import org.framework.less.config.ValidatorModule;
import org.framework.less.config.RepositoryModule;
import org.framework.less.config.SqlModule;
import org.framework.less.notification.NotificationService;
import org.framework.less.ratelimitservice.model.enums.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameworkLessApplication extends Config {
    public static final Injector APP = injectDependencies();

    private static final Logger LOGGER = LoggerFactory.getLogger(FrameworkLessApplication.class);

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

        service.send(NotificationType.NEWS, 2, "news 1");

        service.send(NotificationType.NEWS, 1, "update 1");
    }
}
