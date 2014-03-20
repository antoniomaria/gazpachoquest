package net.sf.gazpachoquest.questionnaires.resource;

import java.util.Collections;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;

import net.sf.gazpachoquest.api.QuestionnairResource;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ResourceProducer {

    private static Logger logger = LoggerFactory.getLogger(ResourceProducer.class);

    public static final String BASE_URI = "http://gazpacho.antoniomaria.cloudbees.net/";

    @Produces
    @GazpachoResource
    @RequestScoped
    public QuestionnairResource createQuestionnairResource(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        String password = (String) request.getSession().getAttribute("password");

        logger.info("Getting QuestionnairResource using credentials {}/{}: ", username, password);
        QuestionnairResource proxy = JAXRSClientFactory.create(BASE_URI, QuestionnairResource.class,
                Collections.singletonList(new JacksonJsonProvider()), username, password, null);
        return proxy;
    }

    public void closeQuestionnairResource(@Disposes
    @GazpachoResource
    QuestionnairResource client) {
        logger.info("Closing QuestionnairResource ");
        WebClient.client(client).reset();
    }

}
