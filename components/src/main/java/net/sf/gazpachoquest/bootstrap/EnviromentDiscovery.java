package net.sf.gazpachoquest.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class EnviromentDiscovery implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    private static final Logger logger = LoggerFactory.getLogger(EnviromentDiscovery.class);

    private static final String CONFIG_FILE_NAME = "config.properties";

    @Override
    public void initialize(ConfigurableWebApplicationContext ctx) {
        ConfigurableEnvironment environment = ctx.getEnvironment();
        ServletContext servletContext = ctx.getServletContext();
        String contextPath = servletContext.getContextPath();
        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e1) {
            logger.warn("Impossible to get host name.");
        }
        logger.info("Application deployed int host {} using context path: {}", host, contextPath);

        InputStream configurationSource = getResourceAsStream(servletContext, host, contextPath, CONFIG_FILE_NAME);
        Properties config = new Properties();
        try {
            config.load(configurationSource);
        } catch (IOException | NullPointerException | IllegalArgumentException e) {
            throw new IllegalStateException("Initilizatition Error. Couldn't load " + CONFIG_FILE_NAME);
        }
        InputStream logbackSource = getResourceAsStream(servletContext, host, contextPath, "logback.xml");
        try {
            if (logbackSource != null) {
                reconfigureLogback(logbackSource);
            }
        } catch (JoranException e) {
            // At this point logback has crashed.
            throw new IllegalStateException("Errors when reconfiguring logback", e);
        }
        String dbEngine = config.getProperty("db.engine.name");
        String managedBy = config.getProperty("dbpool.managedBy");
        String port = config.getProperty("http.port");
        String schema = config.getProperty("http.schema");
        // Define baseURI
        String basePath = createBasePath(schema, host, port, contextPath);
        servletContext.setAttribute("basePath", basePath);

        environment.addActiveProfile(managedBy);
        logger.info("Application running using {} profiles: {}", environment.getActiveProfiles().length,
                Arrays.toString(environment.getActiveProfiles()));
        try {
            Map<String, Object> props = new HashMap<>();
            for (String key : config.stringPropertyNames()) {
                props.put(key, config.getProperty(key));
            }
            props.put("basePath", basePath);
            MapPropertySource mapSource = new MapPropertySource("props", props);
            environment.getPropertySources().addLast(mapSource);
            environment.getPropertySources().addLast(
                    new ResourcePropertySource(String.format("classpath:/database/%s.properties", dbEngine)));

        } catch (IOException e) {
            throw new IllegalStateException(dbEngine + ".properties not found in classpath", e);
        }
        // Register hook to close application context on JVM shutdown
        ctx.registerShutdownHook();
    }

    private String createBasePath(String schema, String host, String port, String contextPath) {
        StringBuilder builder = new StringBuilder();
        builder.append(schema).append("://");
        builder.append(host);

        if (!port.equals("80")) {
            builder.append(":").append(port);
        }
        builder.append(contextPath);
        return builder.toString();
    }

    public void reconfigureLogback(InputStream source) throws JoranException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator jc = new JoranConfigurator();
        jc.setContext(context);
        context.reset(); // override default configuration // inject the name of
                         // the current application as "application-name" //
                         // property of the LoggerContext
                         // context.putProperty("application-name",
                         // NAME_OF_CURRENT_APPLICATION);
                         // jc.doConfigure("/path/to/the/above/configuration/file.xml")
        jc.doConfigure(source);
    }

    private InputStream getResourceAsStream(ServletContext servletContext, String host, String contextPath,
            String fileName) {
        String paths[] = { String.format("/WEB-INF/config/%s/%s", host, fileName),
                String.format("/WEB-INF/config/%s%s/%s", host, contextPath, fileName),
                String.format("/WEB-INF/config/default/%s", fileName) };
        InputStream is = null;
        int idx = 0;
        do {
            is = servletContext.getResourceAsStream(paths[idx]);
            idx++;
        } while (is == null && idx < paths.length);

        if (is != null) {
            logger.info("Loading {} file from path {}", fileName, paths[--idx]);
        }
        return is;
    }

}
