/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.questionnaires.resource;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.cxf.interceptor.HmacAuthInterceptor;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.questionnaires.bootstrap.ConfigurationKey;
import net.sf.gazpachoquest.questionnaires.bootstrap.InjectedConfiguration;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationScoped
public class ResourceProducer {

    private static Logger logger = LoggerFactory.getLogger(ResourceProducer.class);

    // public static final String BASE_URI =
    // "http://aurora:8080/gazpachoquest-rest-web/api";

    // public static final String BASE_URI =
    // "http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/api";
    @Inject
    @InjectedConfiguration(key = ConfigurationKey.REST_ENDPOINT)
    private String BASE_URI;

    @PostConstruct
    public void init() {
        logger.info("Gazpacho Rest endpoint configured to {}", BASE_URI);
    }

    @Produces
    @GazpachoResource
    @RequestScoped
    public QuestionnairResource createQuestionnairResource(HttpServletRequest request) {
        RespondentAccount principal = (RespondentAccount) request.getUserPrincipal();
        String apiKey = principal.getApiKey();
        String secret = principal.getSecret();

        logger.info("Getting QuestionnairResource using api key {}: ", apiKey);
        QuestionnairResource resource = JAXRSClientFactory.create(BASE_URI, QuestionnairResource.class,
                Collections.singletonList(new JacksonJsonProvider()), null);
        // proxies
        // WebClient.client(resource).header("Authorization", "GZQ " + apiKey);

        Client client = WebClient.client(resource);
        ClientConfiguration config = WebClient.getConfig(client);
        config.getOutInterceptors().add(new HmacAuthInterceptor(apiKey, secret));
        return resource;
    }

    public void closeQuestionnairResource(@Disposes
    @GazpachoResource
    QuestionnairResource client) {
        logger.info("Closing QuestionnairResource ");
        WebClient.client(client).reset();
    }

}
