package net.sf.gazpachoquest.rest;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

// ConfigurableWebApplicationContext
public class EnviromentDiscovery implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(EnviromentDiscovery.class);

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        logger.info("Application running local");
        ConfigurableEnvironment environment = ctx.getEnvironment();

        if (environment.acceptsProfiles("development")) {
            Properties properties = new Properties();
            // Create mongo service properties for development environment
            properties.put("hostname", "localhost");
            environment.getPropertySources().addFirst(new PropertiesPropertySource("properties", properties));
        }
    }

}
