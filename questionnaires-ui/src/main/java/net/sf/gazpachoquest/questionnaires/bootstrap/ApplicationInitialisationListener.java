package net.sf.gazpachoquest.questionnaires.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ApplicationInitialisationListener implements
		ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationInitialisationListener.class);

	private static final String CONFIG_FILE_NAME = "config.properties";

	private static final String GAZPACHO_QUEST_ENGINE_NAME = "gazpachoQuestEngineName";

	private static boolean INITIALIZED;

	private volatile static Properties configProperties;


    @Inject
    private BeanManager beanManager;
    
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		String contextPath = servletContext.getContextPath();
		// This variable has the same meaning as host, but i can be redefined in
		// case of cluster deployment.
		String engineName = resolveEngineName();
		logger.info("Application deployed int host {} using context path: {}",
				engineName, contextPath);

		InputStream configurationSource = getResourceAsStream(servletContext,
				engineName, contextPath, CONFIG_FILE_NAME);
		configProperties = new Properties();
		try {
			configProperties.load(configurationSource);
			INITIALIZED = true;
		} catch (IOException | NullPointerException | IllegalArgumentException e) {
			throw new IllegalStateException(
					"Initilizatition Error. Couldn't load " + CONFIG_FILE_NAME);
		}

		if (beanManager != null) {
			beanManager.fireEvent(StartUpEvent.with()
					.properties(configProperties).build());
			logger.info("beanManager fired StartUp Event.");
		} else {
			logger.error("beanManager is null.  Cannot fire StartUp Event.");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		configProperties = null;
	}

	/*-
	 @InjectedConfiguration
	 @Produces
	 public String injectConfiguration(InjectionPoint ip, ServletContext servletContext)
	 throws IllegalStateException {
	 if (!INITIALIZED) {
	 throw new IllegalStateException(
	 "Initialization Error. Class not iniatilialized by a j2ee container");
	 }
	 InjectedConfiguration param = ip.getAnnotated().getAnnotation(
	 InjectedConfiguration.class);
	 String resourceKey = param.key().getKey();
	 return configProperties.getProperty(resourceKey);
	 }*/

	private String resolveEngineName() {
		String engineName = System.getProperty(GAZPACHO_QUEST_ENGINE_NAME);
		if (StringUtils.isNotBlank(engineName)) {
			return engineName;
		}
		try {
			engineName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e1) {
			logger.warn("Impossible to get host name.");
		}
		return engineName;
	}

	private InputStream getResourceAsStream(ServletContext servletContext,
			String host, String contextPath, String fileName) {
		String paths[] = {
				String.format("/WEB-INF/config/%s/%s", host, fileName),
				String.format("/WEB-INF/config/%s%s/%s", host, contextPath,
						fileName),
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

	public BeanManager lookUpBeanManager() {
		try {
			// See reference below about how I came up with this
			InitialContext iniCtx = new InitialContext();
			BeanManager result = (BeanManager) iniCtx
					.lookup("java:comp/env/BeanManager");
			return result;
		} catch (NamingException e) {
			logger.error("Could not construct BeanManager.", e);
			return null;
		}
	}

}
