package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.LongTextAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;
import net.sf.gazpachosurvey.domain.core.Questionnair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
@DatabaseSetup("QuestionnairFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairFacadeTest {

    @Autowired
    private QuestionnairFacade questionnairFacade;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
    }

    @Test
    public void findByOneTest() {
        Integer questionnairId = 58;
        QuestionnairDTO questionnair = questionnairFacade.findOne(questionnairId);
        assertThat(questionnair).isNotNull();
    }

    @Test
    public void resolvePageTest() {
        Integer questionnairId = 58;
        PageDTO page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP,
                BrowsingAction.ENTERING);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.FORWARD);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(30).build(),
                QuestionDTO.with().id(31).build(), QuestionDTO.with().id(35).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.BACKWARD);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());
    }

    @Test
    public void resolveFirstPageTest() {
        Questionnair questionnair = Questionnair.with().id(58).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnairAnswersService.save(questionnair, questionCode, answer);
        PageDTO page = questionnairFacade.resolvePage(questionnair.getId(), RenderingMode.QUESTION_BY_QUESTION,
                BrowsingAction.ENTERING);

        assertThat(page.getQuestions()).isNotEmpty();
        QuestionDTO questionDTO = page.getQuestions().get(0);
        assertThat(questionDTO.getId()).isEqualTo(12);
        assertThat(questionDTO.getAnswer()).isExactlyInstanceOf(TextAnswer.class);
        assertThat(((TextAnswer) questionDTO.getAnswer()).getValue()).isEqualTo("Antonio Maria");
    }

    @Test
    public void saveAnswerTest() {

        Questionnair questionnair = Questionnair.with().id(58).build();
        String questionCode = "Q1";
        Answer answer = TextAnswer.fromValue("Antonio Maria");
        Integer questionDefinitionId = jdbcTemplate.queryForInt(
                "select questionnairdefinition_id from questionnair where id = ?", questionnair.getId());
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        Integer answersId = jdbcTemplate.queryForInt("select answers_id from questionnair where id = ?",
                questionnair.getId());
        assertThat(answersId).isNotNull();
        Object value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase()
                + " from questionnair_answers_" + questionDefinitionId + " where id = ?", new Object[] { answersId },
                String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q2";
        answer = TextAnswer.fromValue("05");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q3";
        answer = NumericAnswer.fromValue(33);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = this.jdbcTemplate.queryForInt("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", answersId);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q4";
        answer = LongTextAnswer.fromValue("I started to work in IECISA, 10 years ago");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        questionCode = "Q5";
        answer = TextAnswer.fromValue("02");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q6";
        answer = TextAnswer.fromValue("02");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_1";
        answer = TextAnswer.fromValue("01");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_2";
        answer = TextAnswer.fromValue("01");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        // Checkbox list
        questionCode = "Q8_O1";
        answer = BooleanAnswer.valueOf("01", Boolean.TRUE);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        questionCode = "Q8_O2";
        answer = BooleanAnswer.valueOf("02", Boolean.TRUE);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        value = this.jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, Boolean.class);
        assertThat(value).isEqualTo(answer.getValue());

    }

}
