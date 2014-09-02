package net.sf.gazpachoquest.services;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;

import org.apache.shiro.subject.Subject;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnaireAnswersService-dataset.xml")
@DatabaseTearDown("QuestionnaireAnswersService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireAnswersServiceTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    @Autowired
    private QuestionnaireAnswersRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final int answersId = 5;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnair_answers_7 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void save() {
        Questionnaire questionnaire = Questionnaire.with().id(58).answersId(answersId).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnaireAnswersService.save(questionnaire, questionCode, answer);

        Map<String, Object> answers = jdbcTemplate.queryForMap(
                "select q1,q2,q3,q5,q6,q7_1,q8_o1 from questionnair_answers_7 where id = ?", answersId);
        assertThat(answers).isNotEmpty();
        assertThat(answers.get("q1")).isEqualTo("Antonio Maria");

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
