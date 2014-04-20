package net.sf.gazpachoquest.security.shiro;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
		"classpath:/datasource-test-context.xml",
		"classpath:/services-context.xml", "classpath:/components-context.xml",
		"classpath:/rest-security-context.xml", })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("JPARealm-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class JPARealmTest {

	@Autowired
	private JPARealm apiKeyRealm;

	@Autowired
	private SecurityManager securityManager;
	
	@Test
	public void loginTest() {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new APIKeyToken.Builder().apiKey(
				"59HBD014UN9L8NM").build();
		subject.login(token);

		assertThat(subject.getPrincipal()).isInstanceOf(User.class);
		assertThat(subject.getPrincipal()).isEqualTo(User.with().id(3).build());
		
		boolean isRespondent = subject.hasRole("respondent");
		System.out.println("is respondent ?" + isRespondent);
		boolean isPermitted = subject.isPermitted("questionnair:read:73");
		assertThat(isPermitted).isTrue();
	}

}
