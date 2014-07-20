package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.NavigationAction;

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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("GroupByGroupResolver-dataset.xml")
@DatabaseTearDown("GroupByGroupResolver-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class GroupByGroupResolverTest {

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private PageResolver resolver;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void resolveNextPageNoRandomizationTest() {
        jdbcTemplate.update("update questionnair_definition set randomization_strategy = ? where id = ?", "N", 7);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);

        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(39, 50);

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(39, 50);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30, 31, 35);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13, 12, 29);
    }

    @Test
    public void resolveNextPageQuestionRandomizationStrategyTest() {
        Integer questionsPerPage = 3;

        jdbcTemplate.update(
                "update questionnair_definition set randomization_strategy = ?, questions_per_page = ? where id = ?",
                "Q", 7, questionsPerPage);

        List<Integer> visitedQuestionIds = new ArrayList<Integer>();

        List<Integer> allQuestionIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(2); // There are not enough questions to fit a 3 question
                                                               // size page.
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(2);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);
    }

    @Test
    public void resolveNextPageGroupsRandomizationTest() {
        jdbcTemplate.update("update questionnair_definition set randomization_strategy = ? where id = ?", "G", 7);

        List<Integer> visitedQuestionIds = new ArrayList<Integer>();

        List<Integer> allQuestionIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);

        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);

    }

}
