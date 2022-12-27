package org.framework.less.config;

import com.google.inject.AbstractModule;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class SqlModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initializing Database");

        bind(DataSource.class).toInstance(this.getDataSource());

        LOGGER.info("Successfully initialized Database");
    }

    private DataSource getDataSource() {
        String driver = Config.get().getString("db.conn.driver", null);
        String userName = Config.get().getString("db.conn.username", null);
        String jdbcUrl = Config.get().getString("db.conn.url", null);
        String password = Config.get().getString("db.conn.password", null);

        int maxPoolSize = Config.get().getInt("db.pool.maxPoolSize", 10);
        int idlePoolSize = Config.get().getInt("db.pool.idlePoolSize", 5);
        int connectionTimeout = Config.get().getInt("db.pool.connectionTimeout", 10000);
        int idleTimeout = Config.get().getInt("db.pool.connectionIdleTimeout", 30000);
        Boolean autoCommit = Config.get().getBoolean("db.pool.autocommit", Boolean.FALSE);

        HikariConfig config = new HikariConfig();

        if (StringUtils.isNotEmpty(driver)) {
            config.setDriverClassName(driver);
        }

        config.setJdbcUrl(jdbcUrl);
        config.setUsername(userName);
        config.setPassword(password);
        config.setMinimumIdle(idlePoolSize);
        config.setMaximumPoolSize(maxPoolSize);
        config.setConnectionTimeout(connectionTimeout);
        config.setIdleTimeout(idleTimeout);
        config.setAutoCommit(autoCommit);

        config.addDataSourceProperty("serverTimezone", "GMT-3");
        config.addDataSourceProperty("cachePrepStmts", Boolean.TRUE);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", Boolean.TRUE);
        config.addDataSourceProperty("useLocalSessionState", Boolean.TRUE);
        config.addDataSourceProperty("useLocalTransactionState", Boolean.TRUE);
        config.addDataSourceProperty("rewriteBatchedStatements", Boolean.TRUE);
        config.addDataSourceProperty("cacheResultSetMetadata", Boolean.TRUE);
        config.addDataSourceProperty("cacheServerConfiguration", Boolean.TRUE);
        config.addDataSourceProperty("elideSetAutoCommits", Boolean.TRUE);
        config.addDataSourceProperty("maintainTimeStats", Boolean.FALSE);

        return new HikariDataSource(config);
    }
}
