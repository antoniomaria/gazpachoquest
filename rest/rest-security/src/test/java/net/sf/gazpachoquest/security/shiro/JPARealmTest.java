package net.sf.gazpachoquest.security.shiro;

import static org.fest.assertions.api.Assertions.assertThat;

import java.security.SignatureException;
import java.util.Date;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.security.support.HMACSignature;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/rest-security-context.xml", })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("JPARealm-dataset.xml")
@DatabaseTearDown("JPARealm-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class JPARealmTest {

    @Autowired
    private JPARealm apiKeyRealm;

    @Test
    public void loginTest() throws SignatureException {
        Subject subject = SecurityUtils.getSubject();

        String date = DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date());

        String resource = "/questionnaires/58";
        String method = "GET";
        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        String apiKey = "B868UOHUTKUDWXM";
        String secret = "IQO27YUZO8NJ7RADIK6SJ9BQZNYP4EMO";
        String signature = HMACSignature.calculateRFC2104HMAC(stringToSign, secret);

        AuthenticationToken token = new HmacAuthToken.Builder().apiKey(apiKey).signature(signature).dateUTC(date)
                .message(stringToSign).build();
        subject.login(token);

        assertThat(subject.getPrincipal()).isInstanceOf(User.class);
        assertThat(subject.getPrincipal()).isEqualTo(User.with().id(3).build());

        boolean isPermitted = subject.isPermitted("questionnaire:read:58");
        assertThat(isPermitted).isTrue();
    }

}
