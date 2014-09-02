package net.sf.gazpachoquest.jaas;

import java.util.Collections;

import net.sf.gazpachoquest.api.AuthenticationResource;
import net.sf.gazpachoquest.api.QuestionnaireResource;
import net.sf.gazpachoquest.cxf.interceptor.HmacAuthInterceptor;
import net.sf.gazpachoquest.dto.QuestionnaireDTO;
import net.sf.gazpachoquest.dto.QuestionnairePageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Ignore
public class ClientInterceptorTest {
    // public static final String BASE_URI =
    // "http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/api";
    public static final String BASE_URI = "http://localhost:8080/gazpachoquest-rest-web/api";

    @Test
    public void saveAnswerTest() {
        QuestionnaireResource questionnaireResource = JAXRSClientFactory.create(BASE_URI, QuestionnaireResource.class,
                Collections.singletonList(new JacksonJsonProvider()), null);

        Client client = WebClient.client(questionnaireResource);
        ClientConfiguration config = WebClient.getConfig(client);

        // config.getHttpConduit().setAuthSupplier(new MyHttpAuthSupplier());
        Answer answer = new TextAnswer("Antonio Maria");
        Integer questionnaireId = 11;
        String questionCode = "Q1";
        String apiKey = "1234";
        String secret = "123434";
        config.getOutInterceptors().add(new HmacAuthInterceptor(apiKey, secret));
        questionnaireResource.saveAnswer(answer, questionnaireId, questionCode);
    }

    @Test
    public void authenticateTest() {
        AuthenticationResource authenticationResource = JAXRSClientFactory.create(BASE_URI,
                AuthenticationResource.class, Collections.singletonList(new JacksonJsonProvider()), null);
        Client client = WebClient.client(authenticationResource);
        ClientConfiguration config = WebClient.getConfig(client);
        Account account = authenticationResource.authenticate("YAS5ICHRBE");
    }

    @Test
    public void getQuestionnairTest() {
        QuestionnaireResource questionnaireResource = JAXRSClientFactory.create(BASE_URI, QuestionnaireResource.class,
                Collections.singletonList(new JacksonJsonProvider()), null);

        Client client = WebClient.client(questionnaireResource);
        ClientConfiguration config = WebClient.getConfig(client);

        String apiKey = "ES619O31DPD8DYJ";
        String secret = "123434";
        config.getOutInterceptors().add(new HmacAuthInterceptor(apiKey, secret));

        Integer questionnaireId = 61;
        QuestionnaireDTO definition = questionnaireResource.getDefinition(questionnaireId);
    }

    @Test
    public void getPageTest() {
        QuestionnaireResource questionnaireResource = JAXRSClientFactory.create(BASE_URI, QuestionnaireResource.class,
                Collections.singletonList(new JacksonJsonProvider()), null);

        Client client = WebClient.client(questionnaireResource);
        ClientConfiguration config = WebClient.getConfig(client);

        String apiKey = "FGFQM8T6YPVSW4Q";
        String secret = "39JYOYPWYR46R38OAOTVRZJMEXNJ46HL";
        config.getOutInterceptors().add(new HmacAuthInterceptor(apiKey, secret));

        Integer questionnaireId = 103;
        QuestionnairePageDTO definition = questionnaireResource.getPage(questionnaireId, RenderingMode.ALL_IN_ONE,
                Language.EN, NavigationAction.ENTERING);

        // System.out.println(definition.getQuestionGroups().get(0).getQuestions());
        System.out.println(definition.getQuestions());
    }
}
