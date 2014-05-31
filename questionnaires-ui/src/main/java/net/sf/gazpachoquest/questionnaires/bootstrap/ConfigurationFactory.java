package net.sf.gazpachoquest.questionnaires.bootstrap;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.ServletContext;

@ApplicationScoped
public class ConfigurationFactory {

	private Properties properties;

	public void listen(@Observes StartUpEvent event) {
		this.properties = event.getProperties();
	}

	@InjectedConfiguration
	@Produces
	public String injectConfiguration(InjectionPoint ip)
			throws IllegalStateException {
		InjectedConfiguration param = ip.getAnnotated().getAnnotation(
				InjectedConfiguration.class);
		String resourceKey = param.key().getKey();
		return properties.getProperty(resourceKey);
	}
}
