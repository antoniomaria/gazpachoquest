package net.sf.gazpachosurvey.security;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;

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
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Test
    public void loginTest() {
        Participant respondent = (Participant) loginService.login("", "PF8UCQP36D");
        System.out.println(respondent.getQuestionnairs());
    }

    @Before
    public void setUp() {
        questionnairAnswersRepository.collectAnswers(QuestionnairDefinition.with().id(62).build());
        questionnairAnswersRepository.activeAllAnswers();

    }
}
