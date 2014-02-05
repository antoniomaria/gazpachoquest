package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairAnswersService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairAnswersServiceTest {

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Before
    public void setUp() {
        questionnairAnswersRepository.activeAllAnswers();
    }

    @Test
    public void save() {
        Questionnair questionnair = Questionnair.with().id(63).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnairAnswersService.save(questionnair, questionCode, answer);
        System.out.println("fin");
        questionnairAnswersService.save(questionnair, questionCode, answer);

    }

}
