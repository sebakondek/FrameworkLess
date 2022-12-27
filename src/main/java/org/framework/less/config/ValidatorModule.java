package org.framework.less.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.framework.less.ratelimitservice.validator.NewsValidator;
import org.framework.less.ratelimitservice.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class ValidatorModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initializing Validators");

        bind(Validator.class).annotatedWith(Names.named("newsValidator")).to(NewsValidator.class);

        LOGGER.info("Successfully initialized Validators");
    }
}
