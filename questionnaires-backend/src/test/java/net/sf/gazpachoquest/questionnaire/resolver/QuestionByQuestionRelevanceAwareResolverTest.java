package net.sf.gazpachoquest.questionnaire.resolver;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnaireService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.NavigationAction;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnaire-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
@DatabaseSetup("QuestionnaireDefinitionRelevanceEnabled-dataset.xml")
@DatabaseTearDown("QuestionnaireDefinitionRelevanceEnabled-dataset.xml")
public class QuestionByQuestionRelevanceAwareResolverTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    @Qualifier("QuestionByQuestionRelevanceAwareResolver")
    private PageResolver resolver;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final int answersId = 52;

    @Before
    public void setUp() {
        questionnaireAnswersRepository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnaire_answers_12 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void resolveNextPageNoRandomizationTest() {
        Integer questionnaireId = 106;
        int questionNumberCounter = 1;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);

        System.out.println(pageStructure.getSections().get(0).getQuestions().get(0));

        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(15);
        assertThat(pageStructure.getSections().get(0).getQuestions().get(0).getNumber()).isEqualTo(
                questionNumberCounter);

        // Testing out of range
        boolean exceptionThrown = false;
        try {
            pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertThat(exceptionThrown);
        // Answer Yes to 1st question
        String updateSql = "UPDATE questionnaire_answers_12 SET q1 = ? where id = ?";
        jdbcTemplate.update(updateSql, "yes", answersId);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        System.out.println(pageStructure.getSections().get(0).getQuestions().get(0));
        assertThat(questionIds).containsExactly(20);
        assertThat(pageStructure.getSections().get(0).getQuestions().get(0).getNumber()).isEqualTo(
                ++questionNumberCounter);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);

        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(15);
        assertThat(pageStructure.getSections().get(0).getQuestions().get(0).getNumber()).isEqualTo(
                --questionNumberCounter);

        // Answer No to 1st question
        updateSql = "UPDATE questionnaire_answers_12 SET q1 = ? where id = ?";
        jdbcTemplate.update(updateSql, "no", answersId);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(88);
        assertThat(pageStructure.getSections().get(0).getQuestions().get(0).getNumber()).isEqualTo(
                ++questionNumberCounter);
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
