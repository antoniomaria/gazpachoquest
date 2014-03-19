package net.sf.gazpachoquest.questionnaires.resource;

import java.util.Collections;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import net.sf.gazpachoquest.api.QuestionnairResource;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ResourceProducer {

    private static Logger logger = LoggerFactory.getLogger(ResourceProducer.class);

    private final String baseURI = "http://gazpacho.antoniomaria.cloudbees.net/";

    @Produces
    @GazpachoResource
    @RequestScoped
    public QuestionnairResource createQuestionnairResource() {
        String userName = "respondent";
        String password = "12345678";
        QuestionnairResource proxy = JAXRSClientFactory.create(baseURI, QuestionnairResource.class,
                Collections.singletonList(new JacksonJsonProvider()), userName, password, null);
        return proxy;
    }

    public void closeQuestionnairResource(@Disposes
    @GazpachoResource
    QuestionnairResource client) {
        logger.info("Closing QuestionnairResource ");
        WebClient.client(client).reset();
    }

}
