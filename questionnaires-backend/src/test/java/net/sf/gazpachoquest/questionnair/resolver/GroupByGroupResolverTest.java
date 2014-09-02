package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.QuestionnaireService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.NavigationAction;

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
public class GroupByGroupResolverTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private PageResolver resolver;

    @Test
    @DatabaseSetup("QuestionnairDefinitionNoRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionNoRandomizationEnabled-dataset.xml")
    public void resolveNextPageNoRandomizationTest() {

        Integer questionnaireId = 58;
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.ENTERING);

        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);

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
    }

    @Test
    @DatabaseSetup("QuestionnairDefinitionQuestionRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionQuestionRandomizationEnabled-dataset.xml")
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
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(2); // There are not enough questions to fit a 3 question
                                                               // size page.
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(2);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnaire, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);
    }

    @Test
    @DatabaseSetup("QuestionnairDefinitionGroupRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionGroupRandomizationEnabled-dataset.xml")
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

}
