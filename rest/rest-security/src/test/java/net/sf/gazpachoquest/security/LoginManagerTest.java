package net.sf.gazpachoquest.security;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/rest-security-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LoginManager-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class LoginManagerTest {

    @Autowired
    private LoginManager loginManager;

    @Test
    public void loginTest() throws AccountNotFoundException {
        Account account = loginManager.login("ES619O31DPD8DYJ");
        assertThat(account).isNotNull();
        assertThat(account).isInstanceOf(RespondentAccount.class);
        assertThat(account.getGivenNames()).isEqualTo("Tyrion");

        account = loginManager.login("TUQOC51ZMG9CAU4");
        assertThat(account).isNotNull();
        assertThat(account).isInstanceOf(Account.class);
        assertThat(account.getGivenNames()).isEqualTo("support");

    }
}
