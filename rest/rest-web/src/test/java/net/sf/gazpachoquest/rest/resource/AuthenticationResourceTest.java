package net.sf.gazpachoquest.rest.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.security.auth.login.LoginException;

import net.sf.gazpachoquest.api.AuthenticationResource;
import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import static org.fest.assertions.api.Assertions.*;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/datasource-test-context.xml", "classpath:/jpa-test-context.xml",
        "classpath:/services-context.xml", "classpath:/facades-context.xml", "classpath:/components-context.xml",
        "classpath:/questionnaire-context.xml", "classpath:/rest-security-context.xml",
        "classpath:/rest-test-context.xml", "classpath:/client-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("AuthenticationResourceTest-dataset.xml")
@DatabaseTearDown("AuthenticationResourceTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class AuthenticationResourceTest {

    @Value("#{systemProperties['basePath'] ?: \"http://localhost:9080/api/\"}")
    private String basePath;

    @Autowired
    private JAXRSServerFactoryBean serverFactory;

    private Server server;

    @Autowired
    private AuthenticationResource authenticationResource;

    @Before
    public void beforeMethod() {
        serverFactory.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
        serverFactory.setAddress(basePath);
        server = serverFactory.create();
        server.start();
    }

    @Test
    public void authenticateTest() throws LoginException, IOException {
        String invitation = "NHAZXA4UK9";
        Account account = authenticationResource.authenticate(invitation);
        assertThat(account.getApiKey()).isEqualTo("PCN1SYW4X977UE7");
    }

    @After
    public void afterMethod() {
        server.stop();
        server.destroy();
    }

}
