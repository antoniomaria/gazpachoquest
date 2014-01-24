package net.sf.gazpachosurvey.rest.resources.runtime;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDTO;
import net.sf.gazpachosurvey.rest.ApplicationConfig;
import net.sf.gazpachosurvey.security.LoginService;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.RenderingMode;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairResource-dataset.xml")
public class QuestionnairResourceTest {

    private JerseyTestImpl jerseyTest;

    class JerseyTestImpl extends JerseyTest {
        @Override
        public URI getBaseUri() {
            return super.getBaseUri();
        }

        @Override
        protected ResourceConfig configure() {
            enable(TestProperties.LOG_TRAFFIC);
            enable(TestProperties.DUMP_ENTITY);
            ResourceConfig config = new ApplicationConfig();
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("contextConfigLocation", "root-test-context.xml");
            config.setProperties(properties);
            return config;
        }

        @Override
        protected void configureClient(final ClientConfig config) {
            config.register(new JacksonFeature());
        }
    }

    @Before
    public void beforeMethod() throws Exception {
        jerseyTest = new JerseyTestImpl();
        jerseyTest.setUp();
    }

    @Test
    public void getQuestionnairsTestXX() throws JsonParseException, JsonMappingException, IOException {
        String invitationToken = "PF8UCQP36D";

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, QuestionnairDTO.class);

        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, invitationToken));
        String response = client().target(getBaseUri() + "runtime/questionnairs").request()
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);

        List<QuestionnairDTO> questionnairDTOs = mapper.readValue(response, type);

        //
        // Response response = client().target(getBaseUri() +
        // "runtime/questionnairs").request()
        // .accept(MediaType.APPLICATION_JSON).get();
        System.out.println(questionnairDTOs);
        assertThat(questionnairDTOs).hasSize(1);
        System.out.println("fin serafin!");
    }

    @Test
    public void questionnairsListTest() {
        String invitationToken = "PF8UCQP36D";
        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, invitationToken));
        List<QuestionnairDTO> questionnairDTOs = client().target(getBaseUri() + "runtime/questionnairs").request()
                .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<QuestionnairDTO>>() {
                });
        //
        // Response response = client().target(getBaseUri() +
        // "runtime/questionnairs").request()
        // .accept(MediaType.APPLICATION_JSON).get();
        System.out.println(questionnairDTOs);
        assertThat(questionnairDTOs).hasSize(1);
        System.out.println("fin serafin!");
    }

    @Test
    public void pageTest() {
        String invitationToken = "PF8UCQP36D";
        Integer questionnairId = 63;
        RenderingMode mode = RenderingMode.QUESTION_BY_QUESTION;
        BrowsingAction action = BrowsingAction.ENTERING;

        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, invitationToken));
        PageDTO page = client()
                .target(String.format("%sruntime/questionnairs/%d?mode=%s&action=%s", getBaseUri(), questionnairId,
                        mode, action)).request().accept(MediaType.APPLICATION_JSON).get(PageDTO.class);

        System.out.println("de winner is !" + page.getQuestions());
    }

    @After
    public void tearDown() throws Exception {
        jerseyTest.tearDown();
    }

    protected Client client() {
        return jerseyTest.client();
    }

    protected URI getBaseUri() {
        return jerseyTest.getBaseUri();
    }

}
