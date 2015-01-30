package net.sf.gazpachoquest.rest.resource;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.sf.gazpachoquest.api.AuthenticationResource;
import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.jaxrs.support.JAXRSServerExecutionListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/datasource-test-context.xml", "classpath:/jpa-test-context.xml",
        "classpath:/services-context.xml", "classpath:/facades-context.xml", "classpath:/components-context.xml",
        "classpath:/questionnaire-context.xml", "classpath:/rest-security-context.xml",
        "classpath:/rest-test-context.xml", "classpath:/client-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
        JAXRSServerExecutionListener.class })
@DatabaseSetup("AuthenticationResourceTest-dataset.xml")
@DatabaseTearDown("AuthenticationResourceTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class AuthenticationResourceTest {

    @Autowired
    private AuthenticationResource authenticationResource;

    @Test
    public void authenticateTest() throws LoginException, IOException {
        String invitation = "NHAZXA4UK9";
        Account account = authenticationResource.authenticate(invitation);
        assertThat(account.getApiKey()).isEqualTo("PCN1SYW4X977UE7");
    }

}
