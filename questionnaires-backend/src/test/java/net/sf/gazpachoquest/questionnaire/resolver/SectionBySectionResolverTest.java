package net.sf.gazpachoquest.questionnaire.resolver;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
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
public class SectionBySectionResolverTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    @Qualifier("SectionBySectionResolver")
    private PageResolver resolver;

    @Test
    @DatabaseSetup("QuestionnaireDefinitionNoRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionNoRandomizationEnabled-dataset.xml")
    public void resolveNextPageNoRandomizationTest() {

        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);

        int questionNumberCounter = 1;
        Section section = pageStructure.getSections().get(0);
        List<Question> questions = section.getQuestions();
        for (Question question : questions) {
            assertThat(question.getNumber()).isEqualTo(questionNumberCounter++);
        }

        // Testing out of range
        boolean exceptionThrown = false;
        try {
            pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        }catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown).isTrue();
        
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);
        
        section = pageStructure.getSections().get(0);
        questions = section.getQuestions();
        for (Question question : questions) {
           assertThat(question.getNumber()).isEqualTo(questionNumberCounter++);
        }

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        
        section = pageStructure.getSections().get(0);
        assertThat(section).isEqualTo(Section.with().id(11).build());
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(39, 50);

        // Testing out of range
        exceptionThrown = false;
        try {
            pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        }catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown).isTrue();

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionQuestionRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionQuestionRandomizationEnabled-dataset.xml")
    public void resolveNextPageQuestionRandomizationStrategyTest() {
        Integer questionsPerPage = 3;

        List<Integer> visitedQuestionIds = new ArrayList<Integer>();

        List<Integer> allQuestionIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);

        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        // Testing out of range
        boolean exceptionThrown = false;
        try {
            pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        }catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown);
        
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(2); // There are not
                                                               // enough
                                                               // questions to
                                                               // fit a 3
                                                               // question
                                                               // size page.
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        // Testing out of range
        exceptionThrown = false;
        try {
            pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        }catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionSectionRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionSectionRandomizationEnabled-dataset.xml")
    public void resolveNextPageGroupsRandomizationTest() {
        List<Integer> visitedQuestionIds = new ArrayList<Integer>();

        List<Integer> allQuestionIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);

        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);

        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);

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
