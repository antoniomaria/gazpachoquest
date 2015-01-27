package net.sf.gazpachoquest.rest.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.security.auth.login.LoginException;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/root-test-context.xml", "classpath:/rest-test-context.xml" })
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

    @Before
    public void beforeMethod() {
        serverFactory.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
        serverFactory.setAddress(basePath);
        server = serverFactory.create();
        server.start();
    }

    @After
    public void afterMethod() {
        server.stop();
        server.destroy();
    }

    @Test
    public void authenticateTest() throws LoginException, IOException {
        doLogin(basePath, "NHAZXA4UK9");
    }

    public void doLogin(String endpoint, String invitation) throws IOException, LoginException {
        String query = String.format("invitation=%s", URLEncoder.encode(invitation, "UTF-8"));
        URL url = new URL(endpoint + "/auth?" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream is = connection.getInputStream();) {
            String line;
            // read it with BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
