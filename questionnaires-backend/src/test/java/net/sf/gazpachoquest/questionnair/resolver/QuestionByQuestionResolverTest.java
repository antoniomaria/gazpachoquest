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
@DatabaseSetup("QuestionByQuestionResolver-dataset.xml")
@DatabaseTearDown("QuestionByQuestionResolver-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionByQuestionResolverTest {

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    private PageResolver resolver;

    @Test
    public void resolveNextPageNoRandomizationTest() {
        jdbcTemplate.update("update questionnair_definition set randomization_strategy = ? where id = ?", "N", 7);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);

        List<Integer> questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13);

        // Testing out of range
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(13);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(12);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(29);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(30);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(31);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        questionIds = pageStructure.getQuestionsId();
        assertThat(questionIds).containsExactly(35);

    }

    @Test
    public void resolveNextPageQuestionRandomizationStrategyTest() {
        Integer questionsPerPage = 1;

        jdbcTemplate.update(
                "update questionnair_definition set randomization_strategy = ?, questions_per_page = ? where id = ?",
                "Q", 7, questionsPerPage);

        List<Integer> visitedQuestionIds = new ArrayList<Integer>();

        List<Integer> allQuestionIds = Arrays.asList(13, 12, 29, 30, 31, 35, 39, 50);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        Integer firstQuestionId = pageStructure.getQuestionsId().get(0);
        
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());
        
        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.NEXT);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage); 
        visitedQuestionIds.addAll(pageStructure.getQuestionsId());

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);


        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);


        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);


        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);


        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);
        

        pageStructure = resolver.resolveNextPage(questionnair, NavigationAction.PREVIOUS);
        assertThat(pageStructure.getQuestionsId()).hasSize(questionsPerPage);

        assertThat(visitedQuestionIds).containsAll(allQuestionIds);
        assertThat(pageStructure.getQuestionsId().get(0)).isEqualTo(firstQuestionId);
    }

}
