package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.LongTextAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

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
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml",
        "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "QuestionnairFacade-dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown("QuestionnairFacade-dataset.xml")
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
        jdbcTemplate.update("INSERT INTO questionnair_answers_7 (id) values(?)", 5);
        jdbcTemplate.update("INSERT INTO questionnair_answers_7 (id) values(?)", 10);
    }

    @Test
    public void findByOneTest() {
        Integer questionnairId = 70;
        QuestionnairDTO questionnair = questionnairFacade.findOne(questionnairId);
        assertThat(questionnair).isNotNull();
    }

    @Test
    public void resolvePageTest() {
        Integer questionnairId = 70;
        PageDTO page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP,
                BrowsingAction.ENTERING);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.NEXT);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(30).build(),
                QuestionDTO.with().id(31).build(), QuestionDTO.with().id(35).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.PREVIOUS);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());
    }

    @Test
    public void resolveFirstPageTest() {
        Questionnair questionnair = Questionnair.with().id(70).build();
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
        Questionnair questionnair = Questionnair.with().id(75).build();
        String questionCode = "Q1";
        Answer answer = TextAnswer.fromValue("Antonio Maria");
        Integer questionDefinitionId = jdbcTemplate.queryForObject(
                "select questionnairdefinition_id from questionnair where id = ?", Integer.class, questionnair.getId());
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        Integer answersId = jdbcTemplate.queryForObject("select answers_id from questionnair where id = ?",
                Integer.class, questionnair.getId());
        assertThat(answersId).isNotNull();
        Object value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase()
                + " from questionnair_answers_" + questionDefinitionId + " where id = ?", new Object[] { answersId },
                String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q2";
        answer = TextAnswer.fromValue("O5");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q3";
        answer = NumericAnswer.fromValue(33);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", Integer.class, answersId);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q4";
        answer = LongTextAnswer.fromValue("I started to work in IECISA, 10 years ago");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        questionCode = "Q5";
        answer = TextAnswer.fromValue("O2");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q6";
        answer = TextAnswer.fromValue("O2");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_1";
        answer = TextAnswer.fromValue("O1");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnair_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_2";
        answer = TextAnswer.fromValue("O1");
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        // Checkbox list
        questionCode = "Q8";
        answer = BooleanAnswer.valueOf("O1", Boolean.TRUE);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        questionCode = "Q8";
        String questionOption = "O2";
        answer = BooleanAnswer.valueOf(questionOption, Boolean.TRUE);
        questionnairFacade.saveAnswer(questionnair.getId(), questionCode, answer);

        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + "_" + questionOption
                + " from questionnair_answers_" + questionDefinitionId + " where id = ?", new Object[] { answersId },
                Boolean.class);
        assertThat(value).isEqualTo(answer.getValue());

    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnair_answers_7");
    }
}
