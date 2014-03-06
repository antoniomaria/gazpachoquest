package net.sf.gazpachoquest.questionnaires;

import java.util.Collections;

import javax.enterprise.inject.Produces;
import javax.jms.JMSException;

import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class WebClientProducer {

    private final String baseURI = "http://gazpacho.antoniomaria.cloudbees.net/";

    // http://www.byteslounge.com/tutorials/java-ee-cdi-producer-methods-tutorial
    @Produces
    public WebClient createWebClient() throws JMSException {
        WebClient client = WebClient.create(baseURI, Collections.singletonList(new JacksonJsonProvider()),
                "respondent", "12345678", null);
        return client;
    }
}
