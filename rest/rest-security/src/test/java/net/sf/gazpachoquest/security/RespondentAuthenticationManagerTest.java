package net.sf.gazpachoquest.security;

import static org.fest.assertions.api.Assertions.assertThat;

import java.security.SignatureException;
import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.security.shiro.HmacAuthToken;
import net.sf.gazpachoquest.security.shiro.JPARealm;
import net.sf.gazpachoquest.security.support.HMACSignature;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/rest-security-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentAuthenticationManager-dataset.xml")
@DatabaseTearDown("RespondentAuthenticationManager-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class RespondentAuthenticationManagerTest {

    @Autowired
    @Qualifier("respondentAuthManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private JPARealm apiKeyRealm;

    @Test
    public void authenticateTest() throws AccountNotFoundException, SignatureException {
        Account account = authenticationManager.authenticate("respondent", "90POKHJE16");
        assertThat(account).isInstanceOf(RespondentAccount.class);
        RespondentAccount respondentAccount = (RespondentAccount) account;

        assertThat(respondentAccount.getGivenNames()).isEqualTo("Tyrion");
        assertThat(respondentAccount.getGrantedQuestionnairIds()).contains(73);

        account = authenticationManager.authenticate("respondent", "SYZPVHYMLK");
        assertThat(account).isInstanceOf(RespondentAccount.class);
        respondentAccount = (RespondentAccount) account;
        assertThat(respondentAccount.getGivenNames()).isEqualTo("anonymous");
        String secret = account.getSecret();
        assertThat(secret).isNotNull();

        int grantedQuestionnair = respondentAccount.getGrantedQuestionnairIds().iterator().next();
        String date = DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date());
        String resource = "/questionnairs/" + grantedQuestionnair;
        String method = "GET";
        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        String apiKey = respondentAccount.getApiKey();

        String signature = HMACSignature.calculateRFC2104HMAC(stringToSign, secret);

        AuthenticationToken token = new HmacAuthToken.Builder().apiKey(apiKey).signature(signature).dateUTC(date)
                .message(stringToSign).build();

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        boolean isPermitted = subject.isPermitted("questionnair:read:" + grantedQuestionnair);
        assertThat(isPermitted);
    }
}
