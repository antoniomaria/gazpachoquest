package net.sf.gazpachoquest.facades;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairePageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.LongTextAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnaire-context.xml",
        "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup(value = "QuestionnaireFacade-dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown("QuestionnaireFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireFacadeTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireFacade questionnaireFacade;

    @Autowired
    private QuestionnaireAnswersRepository repository;

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        jdbcTemplate.update("INSERT INTO questionnaire_answers_7 (id) values(?)", 5);
        jdbcTemplate.update("INSERT INTO questionnaire_answers_7 (id) values(?)", 10);
    }

    @Test
    public void getDefinitionTest() {
        Integer questionnaireId = 70;
        QuestionnaireDefinitionDTO questionnaireDefinitionDTO = questionnaireFacade.getDefinition(questionnaireId);
        assertThat(questionnaireDefinitionDTO).isNotNull();
    }

    @Test
    public void resolvePageTest() {
        Integer questionnaireId = 70;
        QuestionnairePageDTO page = questionnaireFacade.resolvePage(questionnaireId, RenderingMode.SECTION_BY_SECTION,
                Language.EN, NavigationAction.ENTERING);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());

        page = questionnaireFacade.resolvePage(questionnaireId, RenderingMode.SECTION_BY_SECTION, Language.EN,
                NavigationAction.NEXT);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(30).build(),
                QuestionDTO.with().id(31).build(), QuestionDTO.with().id(35).build());

        page = questionnaireFacade.resolvePage(questionnaireId, RenderingMode.SECTION_BY_SECTION, Language.EN,
                NavigationAction.PREVIOUS);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(12).build(),
                QuestionDTO.with().id(13).build(), QuestionDTO.with().id(29).build());
    }

    @Test
    @Ignore
    public void resolveFirstPageTest() {
        Questionnaire questionnaire = Questionnaire.with().id(70).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnaireAnswersService.save(questionnaire, questionCode, answer);
        QuestionnairePageDTO page = questionnaireFacade.resolvePage(questionnaire.getId(),
                RenderingMode.QUESTION_BY_QUESTION, Language.EN, NavigationAction.ENTERING);

        assertThat(page.getQuestions()).isNotEmpty();
        QuestionDTO questionDTO = page.getQuestions().get(0);
        assertThat(questionDTO.getId()).isEqualTo(12);
        assertThat(questionDTO.getAnswer()).isExactlyInstanceOf(TextAnswer.class);
        assertThat(((TextAnswer) questionDTO.getAnswer()).getValue()).isEqualTo("Antonio Maria");
    }

    @Test
    public void saveAnswerTest() {
        Questionnaire questionnaire = Questionnaire.with().id(75).build();
        String questionCode = "Q1";
        Answer answer = TextAnswer.fromValue("Antonio Maria");
        Integer questionDefinitionId = jdbcTemplate.queryForObject(
                "select questionnairedefinition_id from questionnaire where id = ?", Integer.class,
                questionnaire.getId());
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);

        Integer answersId = jdbcTemplate.queryForObject("select answers_id from questionnaire where id = ?",
                Integer.class, questionnaire.getId());
        assertThat(answersId).isNotNull();
        Object value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase()
                + " from questionnaire_answers_" + questionDefinitionId + " where id = ?", new Object[] { answersId },
                String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q2";
        answer = TextAnswer.fromValue("O5");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnaire_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q3";
        answer = NumericAnswer.fromValue(33);
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnaire_answers_"
                + questionDefinitionId + " where id = ?", Integer.class, answersId);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q4";
        answer = LongTextAnswer.fromValue("I started to work in IECISA, 10 years ago");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);

        questionCode = "Q5";
        answer = TextAnswer.fromValue("O2");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnaire_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q6";
        answer = TextAnswer.fromValue("O2");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnaire_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_1";
        answer = TextAnswer.fromValue("O1");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);
        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + " from questionnaire_answers_"
                + questionDefinitionId + " where id = ?", new Object[] { answersId }, String.class);
        assertThat(value).isEqualTo(answer.getValue());

        questionCode = "Q7_2";
        answer = TextAnswer.fromValue("O1");
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);

        // Checkbox list
        questionCode = "Q8";
        answer = BooleanAnswer.valueOf("O1", Boolean.TRUE);
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);

        questionCode = "Q8";
        String questionOption = "O2";
        answer = BooleanAnswer.valueOf(questionOption, Boolean.TRUE);
        questionnaireFacade.saveAnswer(questionnaire.getId(), questionCode, answer);

        value = jdbcTemplate.queryForObject("select " + questionCode.toLowerCase() + "_" + questionOption
                + " from questionnaire_answers_" + questionDefinitionId + " where id = ?", new Object[] { answersId },
                Boolean.class);
        assertThat(value).isEqualTo(answer.getValue());

    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnaire_answers_7");
    }

    @Before
    public void setUpSubject() {
        Subject subjectUnderTest = createNiceMock(Subject.class);
        User support = User.with().id(1).build();
        expect(subjectUnderTest.getPrincipal()).andReturn(support).anyTimes();
        replay(subjectUnderTest);
        // 2. Bind the subject to the current thread:
        setSubject(subjectUnderTest);
    }

    @After
    public void tearDownSubject() {
        // 3. Unbind the subject from the current thread:
        clearSubject();
    }
}
