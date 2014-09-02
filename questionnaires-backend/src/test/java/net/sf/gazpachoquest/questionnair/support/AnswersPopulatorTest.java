package net.sf.gazpachoquest.questionnair.support;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.answers.MultipleAnswer;
import net.sf.gazpachoquest.dto.answers.NoAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionAccessorFacade;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnaire-context.xml",
        "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("AnswersPopulatorTest-dataset.xml")
@DatabaseTearDown("AnswersPopulatorTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class AnswersPopulatorTest {

    @Autowired
    private AnswersPopulator answersPopulator;

    @Autowired
    private QuestionnaireAnswersRepository repository;

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    @Autowired
    private QuestionnaireDefinitionAccessorFacade questionnaireDefinitionAccessorFacade;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        jdbcTemplate.update("INSERT INTO questionnair_answers_7 (id) values(?)", 5);
    }

    @Test
    public void populateTest() {
        Integer questionnaireId = 71;

        Questionnaire questionnaire = Questionnaire.with().id(questionnaireId).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnaireAnswersService.save(questionnaire, questionCode, answer);
        QuestionDTO firstQuestion = questionnaireDefinitionAccessorFacade.findOneQuestion(12);
        QuestionDTO secondQuestion = questionnaireDefinitionAccessorFacade.findOneQuestion(13);
        QuestionDTO lastQuestion = questionnaireDefinitionAccessorFacade.findOneQuestion(50);
        List<QuestionDTO> questions = new ArrayList<>();
        questions.add(firstQuestion);
        questions.add(secondQuestion);
        questions.add(lastQuestion);

        answersPopulator.populate(questionnaire, questions);

        assertThat(firstQuestion.getAnswer()).isExactlyInstanceOf(TextAnswer.class);
        assertThat(((TextAnswer) firstQuestion.getAnswer()).getValue()).isEqualTo("Antonio Maria");

        assertThat(secondQuestion.getAnswer()).isExactlyInstanceOf(NoAnswer.class);

        assertThat(lastQuestion.getAnswer()).isExactlyInstanceOf(MultipleAnswer.class);
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnair_answers_7");
    }
}
