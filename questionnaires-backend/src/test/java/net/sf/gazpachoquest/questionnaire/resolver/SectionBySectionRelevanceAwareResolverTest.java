package net.sf.gazpachoquest.questionnaire.resolver;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.SectionBreadcrumb;
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
public class SectionBySectionRelevanceAwareResolverTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    @Qualifier("SectionBySectionRelevanceAwareResolver")
    private PageResolver resolver;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final int answersId = 51;

    @Before
    public void setUp() {
        questionnaireAnswersRepository.activeAllAnswers();
        String insertSql = "INSERT INTO questionnaire_answers_12 (id) values(?)";
        jdbcTemplate.update(insertSql, answersId);
    }

    @Test
    public void f(){
        
        Questionnaire q = Questionnaire.with().id(11).build();
        SectionBreadcrumb b1 = SectionBreadcrumb.with().id(1).build();
        SectionBreadcrumb b2 = SectionBreadcrumb.with().id(1).build();
        q.addBreadcrumb(b1);
        q.addBreadcrumb(b2);
        System.out.println(q.getBreadcrumbs());
        
        
    }
    @Test
    public void resolveNextPageTest() {
        Integer questionnaireId = 103;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);

        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(15);

        int questionNumberCount = 1;
        Section section = pageStructure.getSections().get(0);
        List<Question> questions = section.getQuestions();
        for (Question question : questions) {
            assertThat(question.getNumber()).isEqualTo(questionNumberCount++);
        }
        // Answer Yes to 1st question
        String updateSql = "UPDATE questionnaire_answers_12 SET q1 = ? where id = ?";
        jdbcTemplate.update(updateSql, "yes", answersId);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).isEmpty();

        section = pageStructure.getSections().get(0);
        assertThat(section).isEqualTo(Section.with().id(18).build());

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        section = pageStructure.getSections().get(0);
        assertThat(section).isEqualTo(Section.with().id(19).build());
        
        questionIds = pageStructure.getQuestionsId();
        questions = section.getQuestions();
        for (Question question : questions) {
            assertThat(question.getNumber()).isEqualTo(questionNumberCount++);
        }
        System.out.println("SectionId = " + section.getId() + " questions: --->" + questionIds);
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        section = pageStructure.getSections().get(0);
        questions = section.getQuestions();
        questionIds = pageStructure.getQuestionsId();
        System.out.println("SectionId = " + section.getId() + " questions: --->" + questionIds);
        
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        section = pageStructure.getSections().get(0);
        questions = section.getQuestions();
        questionIds = pageStructure.getQuestionsId();
        System.out.println("SectionId = " + section.getId() + " questions: --->" + questionIds);
        
        // Answer No to 1st question
        updateSql = "UPDATE questionnaire_answers_12 SET q1 = ? where id = ?";
        jdbcTemplate.update(updateSql, "no", answersId);
        
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        section = pageStructure.getSections().get(0);
        questions = section.getQuestions();
        questionIds = pageStructure.getQuestionsId();
        System.out.println("SectionId = " + section.getId() + " questions: --->" + questionIds);
        
        // assertThat(questionIds).containsExactly(13, 12, 29);

        /*-
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(39, 50);

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(39, 50);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);
         */
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
