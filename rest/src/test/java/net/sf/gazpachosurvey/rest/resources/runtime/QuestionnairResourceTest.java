package net.sf.gazpachosurvey.rest.resources.runtime;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachosurvey.rest.ApplicationConfig;
import net.sf.gazpachosurvey.rest.beans.QuestionnairDefinitionBean;
import net.sf.gazpachosurvey.security.LoginService;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitRule;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@DatabaseSetup("QuestionnairResource-dataset.xml")
public class QuestionnairResourceTest {

    @Rule
    public DbUnitRule dbUnit = new DbUnitRule();

    @Autowired
    private DataSource datasource;

    private JerseyTestImpl jerseyTest;

    @Before
    public void beforeMethod() throws Exception {
        jerseyTest = new JerseyTestImpl();
        jerseyTest.setUp();
    }

    @After
    public void tearDown() throws Exception {
        jerseyTest.tearDown();
    }

    class JerseyTestImpl extends JerseyTest {
        @Override
        protected void configureClient(ClientConfig config) {
            config.register(new JacksonFeature());
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
        public URI getBaseUri() {
            return super.getBaseUri();
        }
    }

    @Test
    public void getDefinitionTest() {
        String invitationToken = "QWZZO02USJ";
        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, invitationToken));
        QuestionnairDefinitionBean definition = client().target(getBaseUri() + "questionnair/definition").request()
                .accept(MediaType.APPLICATION_JSON).get(QuestionnairDefinitionBean.class);
        System.out.println(definition);
    }

    protected Client client() {
        return jerseyTest.client();
    }

    protected URI getBaseUri() {
        return jerseyTest.getBaseUri();
    }

}
