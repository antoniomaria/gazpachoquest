package net.sf.gazpachoquest.cxf.interceptor;

import java.util.Collections;

import net.sf.gazpachoquest.api.AuthenticationResource;
import net.sf.gazpachoquest.api.QuestionnaireResource;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Ignore
public class ClientInterceptorTest {
    // public static final String BASE_URI =
    // "http://gazpachoquest.rest.antoniomaria.eu.cloudbees.net/api";
    public static final String BASE_URI = "http://localhost:8080/gazpachoquest-rest-web/api";

    @Test
    public void authenticateTest() {
        AuthenticationResource authenticationResource = JAXRSClientFactory.create(BASE_URI,
                AuthenticationResource.class, Collections.singletonList(new JacksonJsonProvider()), null);
        Client client = WebClient.client(authenticationResource);
        Account account = authenticationResource.authenticate("YAS5ICHRBE");
    }

    @Test
    public void getDefinitionTest() {
        QuestionnaireResource questionnaireResource = getQuestionnaireResource();
        Integer questionnaireId = 61;
        QuestionnaireDefinitionDTO definition = questionnaireResource.getDefinition(questionnaireId);
    }

    @Test
    public void getPageTest() {
        QuestionnaireResource questionnaireResource = getQuestionnaireResource();
        Integer questionnaireId = 103;
        QuestionnairePageDTO definition = questionnaireResource.getPage(questionnaireId, RenderingMode.ALL_IN_ONE,
                Language.EN, NavigationAction.ENTERING);
    }

    @Test
    public void saveAnswerTest() {
        QuestionnaireResource questionnaireResource = getQuestionnaireResource();
        Answer answer = new TextAnswer("Antonio Maria");
        Integer questionnaireId = 11;
        String questionCode = "Q1";
        questionnaireResource.saveAnswer(answer, questionnaireId, questionCode);
    }

    private QuestionnaireResource getQuestionnaireResource() {
        QuestionnaireResource questionnaireResource = JAXRSClientFactory.create(BASE_URI, QuestionnaireResource.class,
                Collections.singletonList(getJacksonProvider()), null);

        Client client = WebClient.client(questionnaireResource);
        ClientConfiguration config = WebClient.getConfig(client);

        String apiKey = "FGFQM8T6YPVSW4Q";
        String secret = "39JYOYPWYR46R38OAOTVRZJMEXNJ46HL";
        config.getOutInterceptors().add(new HmacAuthInterceptor(apiKey, secret));
        return questionnaireResource;
    }

    private JacksonJsonProvider getJacksonProvider() {
        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        jacksonProvider.setMapper(mapper);
        return jacksonProvider;
    }
}
