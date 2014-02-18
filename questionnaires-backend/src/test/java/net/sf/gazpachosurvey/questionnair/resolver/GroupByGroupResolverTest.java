package net.sf.gazpachosurvey.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachosurvey.types.BrowsingAction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("GroupByGroupResolver-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class GroupByGroupResolverTest {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    private QuestionnairElementResolver resolver;

    @Test
    public void resolveForTest() {
        Integer questionnairId = 58;
        Questionnair questionnair = questionnairRepository.findOne(questionnairId);
        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, BrowsingAction.ENTERING);

        List<Question> questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(12).build(), Question.with().id(13).build(),
                Question.with().id(29).build());
        questionGroup = (QuestionGroup) resolver.resolveFor(questionnair, BrowsingAction.FORWARD);

        questions = questionGroup.getQuestions();
        assertThat(questions).containsExactly(Question.with().id(30).build(), Question.with().id(31).build(),
                Question.with().id(35).build());

    }
}
