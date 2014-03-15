package net.sf.gazpachoquest.questionnaires.log;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Application Lifecycle Listener implementation class SLF4JBridgeActivator
 * 
 */
@WebListener
public class SLF4JBridgeActivator implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(SLF4JBridgeActivator.class);

    public SLF4JBridgeActivator() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Bridging JUL to SLF4");
        // Jersey uses java.util.logging - bridge to slf4
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
