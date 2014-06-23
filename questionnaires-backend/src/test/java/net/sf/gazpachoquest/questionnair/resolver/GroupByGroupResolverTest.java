package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.BrowsingAction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@ContextConfiguration(locations = { "classpath:/postgres-properties-loader-context.xml", "classpath:/jpa-context.xml", "classpath:/datasource-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
// @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("GroupByGroupResolver-dataset.xml")
@DatabaseTearDown("GroupByGroupResolver-dataset.xml")
@ActiveProfiles(profiles = { "standalone", "postgres" })
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class GroupByGroupResolverTest {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private QuestionnairElementResolver resolver;

    @Test
    @Rollback(value = false) 
    public void resolveForRandomTest() {
        Integer questionnairId = 103;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);
        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, BrowsingAction.ENTERING);
        for (Question question : questionGroup.getQuestions()) {
            System.out.println(question);
        }
    }
    @Test
    public void resolveForTest() {
        Integer questionnairId = 58;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);
        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, BrowsingAction.ENTERING);

        List<Question> questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(12).build(), Question.with().id(13).build(),
                Question.with().id(29).build());
        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, BrowsingAction.NEXT);

        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(30).build(), Question.with().id(31).build(),
                Question.with().id(35).build());
    }

}
