package client.apis.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EnableJdbcAppenderAfterStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Configuration config = context.getConfiguration();

        // 🔍 Get the JDBC appender defined in XML
        JdbcAppender jdbcAppender = (JdbcAppender) config.getAppender("DatabaseAppender");

        if (jdbcAppender != null && !jdbcAppender.isStarted()) {
            jdbcAppender.start();
        }

        LoggerConfig rootLoggerConfig = config.getRootLogger();

        // 🧠 Avoid adding the same appender twice
        if (!rootLoggerConfig.getAppenders().containsKey("DatabaseAppender")) {
            rootLoggerConfig.addAppender(jdbcAppender, null, null);
            context.updateLoggers(); // ✅ apply the change
        }
    }
}

