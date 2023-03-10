package org.framework.less.config;

import com.google.inject.AbstractModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class RepositoryModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initializing Repositories");
        LOGGER.info("Successfully initialized Repositories");
    }
}
