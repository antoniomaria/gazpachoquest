package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.NavigationAction;

import org.junit.After;
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
    public void resolveForNoRandomizationTest() {
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

    /*
     * @Test
     * public void resolveForGroupsRandomizationTest() {
     * jdbcTemplate.update(
     * "update questionnair_definition set randomization_strategy = ? where id = ?"
     * , "G", 7);
     * 
     * Integer questionnairId = 58;
     * List<QuestionGroup> visitedQuestionGroups = new
     * ArrayList<QuestionGroup>();
     * List<QuestionGroup> allQuestionGroups =
     * Arrays.asList(QuestionGroup.with().id(9).build(), QuestionGroup.with()
     * .id(10).build(), QuestionGroup.with().id(11).build());
     * 
     * Questionnair questionnair =
     * questionnairRepository.findOne(questionnairId);
     * 
     * QuestionGroup questionGroup = (QuestionGroup)
     * resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);
     * assertThat(questionGroup.getQuestions()).isNotEmpty();
     * visitedQuestionGroups.add(questionGroup);
     * 
     * questionGroup = (QuestionGroup) resolver.resolveNextPage(questionnair,
     * NavigationAction.NEXT);
     * assertThat(questionGroup.getQuestions()).isNotEmpty();
     * visitedQuestionGroups.add(questionGroup);
     * 
     * questionGroup = (QuestionGroup) resolver.resolveNextPage(questionnair,
     * NavigationAction.NEXT);
     * assertThat(questionGroup.getQuestions()).isNotEmpty();
     * visitedQuestionGroups.add(questionGroup);
     * 
     * assertThat(visitedQuestionGroups).containsAll(allQuestionGroups);
     * }
     */
    /*-
    @Test
    public void resolveForQuestionRandomizationTest() {
    int questionsPerPpage = 4;
    jdbcTemplate.update(
    "update questionnair_definition set randomization_strategy = ?, questions_per_page = ? where id = ?",
    "Q", questionsPerPpage, 7);

    Integer questionnairId = 58;
    Questionnair questionnair = questionnairRepository.findOne(questionnairId);

    QuestionGroup questionGroup = (QuestionGroup) resolver.resolveNextPage(questionnair, NavigationAction.ENTERING);
    assertThat(questionGroup.getId()).isNull();
    assertThat(questionGroup.getQuestions()).hasSize(questionsPerPpage);

    }*/

    @After
    public void tearDown() {
        jdbcTemplate.update("truncate table breadcrumb");
    }
}
