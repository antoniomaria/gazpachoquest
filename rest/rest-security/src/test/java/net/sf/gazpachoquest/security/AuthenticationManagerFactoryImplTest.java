package net.sf.gazpachoquest.security;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/rest-security-context.xml" })
public class AuthenticationManagerFactoryImplTest {

    @Autowired
    private AuthenticationManagerFactory authenticationManagerFactory;

    @Test
    public void getObjectTest() {
        AuthenticationManager authManager = authenticationManagerFactory.getObject(AccountType.RESPONDENT);
        assertThat(authManager).isNotNull();
        assertThat(authManager.toString()).contains("RespondentAuthenticationManagerImpl");
    }

}
