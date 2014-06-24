package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.NavigationAction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
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
// @ActiveProfiles(profiles = { "standalone", "postgres" })
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class GroupByGroupResolverTest {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private QuestionnairElementResolver resolver;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void resolveForNoRandomizationTest() {
        Integer questionnairId = 58;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);
        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.ENTERING);

        List<Question> questions = questionGroup.getQuestions();
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 1");
        assertThat(questions).containsExactly(Question.with().id(13).build(), Question.with().id(12).build(),
                Question.with().id(29).build());
        // Testing out of range
        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.PREVIOUS);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 1");
        assertThat(questions).containsExactly(Question.with().id(13).build(), Question.with().id(12).build(),
                Question.with().id(29).build());

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.NEXT);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 2");
        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(30).build(), Question.with().id(31).build(),
                Question.with().id(35).build());

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.NEXT);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 3");
        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(39).build(), Question.with().id(50).build());

        // Testing out of range
        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.NEXT);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 3");
        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(39).build(), Question.with().id(50).build());

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.PREVIOUS);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 2");
        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(30).build(), Question.with().id(31).build(),
                Question.with().id(35).build());

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.PREVIOUS);
        assertThat(questionGroup.getLanguageSettings().getTitle()).isEqualTo("QuestionGroup 1");
        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(13).build(), Question.with().id(12).build(),
                Question.with().id(29).build());
    }

    @Test
    public void resolveForGroupsRandomizationTest() {
        jdbcTemplate.update("update questionnair_definition set randomization_strategy = ? where id = ?", "G", 7);

        Integer questionnairId = 58;
        List<QuestionGroup> visitedQuestionGroups = new ArrayList<QuestionGroup>();
        List<QuestionGroup> allQuestionGroups = Arrays.asList(QuestionGroup.with().id(9).build(), QuestionGroup.with()
                .id(10).build(), QuestionGroup.with().id(11).build());

        Questionnair questionnair = questionnairRepository.findOne(questionnairId);

        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.ENTERING);
        assertThat(questionGroup.getQuestions()).isNotEmpty();
        visitedQuestionGroups.add(questionGroup);

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.NEXT);
        assertThat(questionGroup.getQuestions()).isNotEmpty();
        visitedQuestionGroups.add(questionGroup);

        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.NEXT);
        assertThat(questionGroup.getQuestions()).isNotEmpty();
        visitedQuestionGroups.add(questionGroup);

        assertThat(visitedQuestionGroups).containsAll(allQuestionGroups);
    }

    @Test
    public void resolveForQuestionRandomizationTest() {
        int questionsPerPpage = 4;
        jdbcTemplate.update(
                "update questionnair_definition set randomization_strategy = ?, questions_per_page = ? where id = ?",
                "Q", questionsPerPpage, 7);

        Integer questionnairId = 58;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);

        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, NavigationAction.ENTERING);
        assertThat(questionGroup.getId()).isNull();
        assertThat(questionGroup.getQuestions()).hasSize(questionsPerPpage);

    }
}
