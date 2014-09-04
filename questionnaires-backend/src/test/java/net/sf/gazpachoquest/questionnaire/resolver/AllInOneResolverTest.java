package net.sf.gazpachoquest.questionnaire.resolver;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.Questionnaire;
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
public class AllInOneResolverTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    @Qualifier("AllInOneResolver")
    private PageResolver resolver;

    @Test
    @DatabaseSetup("QuestionnaireDefinitionNoRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionNoRandomizationEnabled-dataset.xml")
    public void resolveNextPageNoRandomizationTest() {
        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();

        assertThat(questionGroups).hasSize(3);

        QuestionGroup firstGroup = questionGroups.get(0);
        assertThat(firstGroup.getId()).isEqualTo(9);
        assertThat(firstGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(13).build(), Question.with().id(12).build(), Question.with().id(29)
                        .build()));

        QuestionGroup secondGroup = questionGroups.get(1);
        assertThat(secondGroup.getId()).isEqualTo(10);
        assertThat(secondGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(30).build(), Question.with().id(31).build(), Question.with().id(35)
                        .build()));

        QuestionGroup thirdGroup = questionGroups.get(2);
        assertThat(thirdGroup.getId()).isEqualTo(11);

        assertThat(thirdGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(39).build(), Question.with().id(50).build()));
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionNoRandomizationEnabledGroupByGroupStarted-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionNoRandomizationEnabledGroupByGroupStarted-dataset.xml")
    public void resolveNextPageNoRandomizationEnabledDirty() {
        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();

        assertThat(questionGroups).hasSize(3);

        QuestionGroup firstGroup = questionGroups.get(0);
        assertThat(firstGroup.getId()).isEqualTo(9);
        assertThat(firstGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(13).build(), Question.with().id(12).build(), Question.with().id(29)
                        .build()));

        QuestionGroup secondGroup = questionGroups.get(1);
        assertThat(secondGroup.getId()).isEqualTo(10);
        assertThat(secondGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(30).build(), Question.with().id(31).build(), Question.with().id(35)
                        .build()));

        QuestionGroup thirdGroup = questionGroups.get(2);
        assertThat(thirdGroup.getId()).isEqualTo(11);

        assertThat(thirdGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(39).build(), Question.with().id(50).build()));
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionNoRandomizationEnabledAllInOneStarted-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionNoRandomizationEnabledAllInOneStarted-dataset.xml")
    public void resolveNextPageNoRandomizationEnabledStarted() {
        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();

        assertThat(questionGroups).hasSize(3);

        QuestionGroup firstGroup = questionGroups.get(0);
        assertThat(firstGroup.getId()).isEqualTo(9);
        assertThat(firstGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(13).build(), Question.with().id(12).build(), Question.with().id(29)
                        .build()));

        QuestionGroup secondGroup = questionGroups.get(1);
        assertThat(secondGroup.getId()).isEqualTo(10);
        assertThat(secondGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(30).build(), Question.with().id(31).build(), Question.with().id(35)
                        .build()));

        QuestionGroup thirdGroup = questionGroups.get(2);
        assertThat(thirdGroup.getId()).isEqualTo(11);

        assertThat(thirdGroup.getQuestions()).isEqualTo(
                Arrays.asList(Question.with().id(39).build(), Question.with().id(50).build()));
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionGroupRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionGroupRandomizationEnabled-dataset.xml")
    public void resolveNextPageGroupsRandomizationTest() {
        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();

        assertThat(questionGroups).hasSize(3);
        List<Question> visitedQuestions = new ArrayList<>();

        List<Question> allQuestions = getAllQuestions();
        QuestionGroup firstGroup = questionGroups.get(0);
        for (Question question : firstGroup.getQuestions()) {
            visitedQuestions.add(question);
        }
        assertThat(allQuestions).containsAll(visitedQuestions);
    }

    @Test
    @DatabaseSetup("QuestionnaireDefinitionQuestionRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnaireDefinitionQuestionRandomizationEnabled-dataset.xml")
    public void resolveNextPageQuestionRandomizationStrategyTest() {
        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();
        assertThat(questionGroups).hasSize(1);

        List<Question> visitedQuestions = new ArrayList<>();

        List<Question> allQuestions = getAllQuestions();

        for (QuestionGroup questionGroup : questionGroups) {
            for (Question question : questionGroup.getQuestions()) {
                visitedQuestions.add(question);
            }
        }
        assertThat(allQuestions).containsAll(visitedQuestions);
    }

    private List<Question> getAllQuestions() {
        List<Integer> allQuestionsIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);
        List<Question> allQuestions = new ArrayList<>();
        for (Integer questionId : allQuestionsIds) {
            allQuestions.add(Question.with().id(questionId).build());
        }
        return allQuestions;
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
