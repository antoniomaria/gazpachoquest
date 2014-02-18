package net.sf.gazpachosurvey.questionnair.support;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.answers.TextAnswer;
import net.sf.gazpachosurvey.facades.QuestionnairDefinitionAccessorFacade;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.services.QuestionnairAnswersService;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("AnswersPopulatorTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class AnswersPopulatorTest {

    @Autowired
    private AnswersPopulator answersPopulator;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Autowired
    private QuestionnairDefinitionAccessorFacade questionnairDefinitionAccessorFacade;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
    }

    @Test
    public void populateTest() {
        Integer questionnairId = 58;
        Integer firstQuestionId = 12;
        Questionnair questionnair = Questionnair.with().id(questionnairId).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnairAnswersService.save(questionnair, questionCode, answer);
        QuestionDTO question = questionnairDefinitionAccessorFacade.findOneQuestion(firstQuestionId);

        List<QuestionDTO> questions = new ArrayList<>();
        questions.add(question);
        answersPopulator.populate(questionnair, questions);

        assertThat(question.getAnswer()).isExactlyInstanceOf(TextAnswer.class);
        assertThat(((TextAnswer) question.getAnswer()).getValue()).isEqualTo("Antonio Maria");

    }

}
