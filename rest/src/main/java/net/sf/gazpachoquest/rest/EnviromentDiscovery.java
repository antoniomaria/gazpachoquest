package net.sf.gazpachoquest.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

public class EnviromentDiscovery implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(EnviromentDiscovery.class);

    private final String GAZPACHO_APP_KEY = "GAZPACHO_APP";

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        ConfigurableEnvironment environment = ctx.getEnvironment();
        String activeProfiles[] = environment.getActiveProfiles();

        if (activeProfiles.length == 0) {
            environment.setActiveProfiles("test");
        }

        logger.info("Application running using profiles: {}", Arrays.toString(environment.getActiveProfiles()));

        String instanceInfoString = environment.getProperty(GAZPACHO_APP_KEY);

        PropertySourcesPlaceholderConfigurer propertyHolder = new PropertySourcesPlaceholderConfigurer();

        Map<String, String> environmentProperties = parseInstanceInfo(instanceInfoString);
        if (!environmentProperties.isEmpty()) {
            logger.info("Overriding default properties with {}", instanceInfoString);
            Properties properties = new Properties();
            for (String key : environmentProperties.keySet()) {
                String value = environmentProperties.get(key);
                properties.put(key, value);
            }
            environment.getPropertySources().addLast(new PropertiesPropertySource("properties", properties));

            propertyHolder.setEnvironment(environment);
            // ctx.addBeanFactoryPostProcessor(propertyHolder);
            // ctx.refresh();
        }
    }

    private Map<String, String> parseInstanceInfo(String instanceInfoString) {
        Map<String, String> properties = new HashMap<String, String>();
        if (StringUtils.isNotBlank(instanceInfoString)) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                properties = mapper.readValue(instanceInfoString, new TypeReference<HashMap<String, String>>() {
                });
            } catch (Exception e) {
                logger.warn("Errors found parsing GAZPACHO_APP json string. Using default settings", e);
            }
        }
        return properties;
    }

}
