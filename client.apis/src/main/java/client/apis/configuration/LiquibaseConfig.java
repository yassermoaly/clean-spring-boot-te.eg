package client.apis.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfig {

    @Bean(name = "mainDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource mainDataSource() {
    	  return DataSourceBuilder.create().type(DataSource.class).build();
    }

    @Bean(name = "loggingDataSource")
    @ConfigurationProperties(prefix = "logging.datasource")
    DataSource loggingDataSource() {
    	return DataSourceBuilder.create().type(DataSource.class).build();
    }

    @Bean(name = "liquibaseMain")
    SpringLiquibase liquibaseMain(@Qualifier("mainDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/db/changelog/main/db.changelog-master.xml");
        liquibase.setContexts("mainDataSource");
        return liquibase;
    }

    @Bean(name = "liquibaseLogging")
    SpringLiquibase liquibaseLogging(@Qualifier("loggingDataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/db/changelog/logs/db.changelog-master.xml");
        liquibase.setContexts("loggingDataSource");
        return liquibase;
    }
}
