package net.sf.gazpachosurvey.security;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.dynamic.RespondentAnswersRepository;

import org.junit.Before;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("RespondentLoginService-dataset.xml")
public class RespondentLoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RespondentAnswersRepository respondentAnswersRepository;

    @Before
    public void setUp() {
        respondentAnswersRepository.collectAnswers(Survey.with().id(56).build());
        respondentAnswersRepository.activeAllAnswers();

    }

    @Test
    public void loginTest() {
        loginService.login("", "PZXDUNZKK2");
    }
}
