package net.sf.gazpachosurvey.rest.resources.runtime;

import java.util.HashMap;
import java.util.Map;

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
import org.junit.Test;

public class QuestionnairResourceTest extends JerseyTest {

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
    protected void configureClient(ClientConfig config) {
        // config.register(new
        // JacksonFeature()).register(MyObjectMapperProvider.class);
        config.register(new JacksonFeature());
    }

    @Test
    public void testHelloWorld() {
        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, "0GCQ58P6DR"));

        String output = client().target(getBaseUri() + "questionnair/definition").request("application/json")
                .get(String.class);
        System.out.println(output);
    }

    @Test
    public void getDefinitionTest() {
        client().register(new HttpBasicAuthFilter(LoginService.RESPONDENT_USER_NAME, "VBZ5MA6F0U"));
        QuestionnairDefinitionBean definition = client().target(getBaseUri() + "questionnair/definition").request()
                .accept(MediaType.APPLICATION_JSON).get(QuestionnairDefinitionBean.class);
        System.out.println(definition);
    }
}
