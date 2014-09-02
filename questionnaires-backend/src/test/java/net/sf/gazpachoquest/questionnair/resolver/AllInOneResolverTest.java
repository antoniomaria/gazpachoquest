package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
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
public class AllInOneResolverTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    @Qualifier("AllInOneResolver")
    private PageResolver resolver;

    @Test
    @DatabaseSetup("QuestionnairDefinitionNoRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionNoRandomizationEnabled-dataset.xml")
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
    @DatabaseSetup("QuestionnairDefinitionNoRandomizationEnabledGroupByGroupStarted-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionNoRandomizationEnabledGroupByGroupStarted-dataset.xml")
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
    @DatabaseSetup("QuestionnairDefinitionNoRandomizationEnabledAllInOneStarted-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionNoRandomizationEnabledAllInOneStarted-dataset.xml")
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
    @DatabaseSetup("QuestionnairDefinitionGroupRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionGroupRandomizationEnabled-dataset.xml")
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
    @DatabaseSetup("QuestionnairDefinitionQuestionRandomizationEnabled-dataset.xml")
    @DatabaseTearDown("QuestionnairDefinitionQuestionRandomizationEnabled-dataset.xml")
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
}
