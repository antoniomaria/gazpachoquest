package net.sf.gazpachoquest.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

// ConfigurableWebApplicationContext
public class EnviromentDiscovery implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(EnviromentDiscovery.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String GAZPACHO_APP_KEY = "GAZPACHO_APP";

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        logger.info("Application running local");
        ConfigurableEnvironment environment = ctx.getEnvironment();
        String instanceInfoString = environment.getProperty(GAZPACHO_APP_KEY);

        PropertySourcesPlaceholderConfigurer propertyHolder = new PropertySourcesPlaceholderConfigurer();

        Map<String, String> environmentProperties = parseInstanceInfo(instanceInfoString);
        if (environment.acceptsProfiles("postgres")) {
            try {
                environment.getPropertySources().addLast(
                        new ResourcePropertySource("classpath:/database/postgres.properties"));
            } catch (IOException e) {
                throw new IllegalStateException("postgres.properties not found in classpath", e);
            }
        } else if (environment.acceptsProfiles("mysql")) {
            try {
                environment.getPropertySources().addLast(
                        new ResourcePropertySource("classpath:/database/mysql.properties"));
            } catch (IOException e) {
                throw new IllegalStateException("postgres.properties not found in classpath", e);
            }
        } else {
            try {
                environment.getPropertySources().addLast(
                        new ResourcePropertySource("classpath:/database/hsql.properties"));
            } catch (IOException e) {
                throw new IllegalStateException("postgres.properties not found in classpath", e);
            }
            environment.setActiveProfiles("test", "standalone");
        }
        propertyHolder.setEnvironment(environment);
        ctx.addBeanFactoryPostProcessor(propertyHolder);
        ctx.refresh();
        /*-
        if (environment.acceptsProfiles("standalone")) {
            String driverClass = environmentProperties.get("jdbc.driver.class");
            Properties properties = new Properties();
            properties.put("hostname", "localhost");
            try {
                environment.getPropertySources().addFirst(
                        new ResourcePropertySource("classpath:/database/postgres.properties"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            environment.getPropertySources().addFirst(new PropertiesPropertySource("properties", properties));
        }*/

    }

    private Map<String, String> parseInstanceInfo(String instanceInfoString) {
        Map<String, String> properties = new HashMap<String, String>();
        if (StringUtils.isNotBlank(instanceInfoString)) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                properties = mapper.readValue(instanceInfoString, new TypeReference<HashMap<String, String>>() {
                });
            } catch (Exception e) {
                logger.error("Errors found parsing GAZPACHO_APP json string", e);
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

}
