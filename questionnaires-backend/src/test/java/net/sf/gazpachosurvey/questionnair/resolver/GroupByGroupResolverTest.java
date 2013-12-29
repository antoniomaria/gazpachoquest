package net.sf.gazpachosurvey.questionnair.resolver;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.repository.RespondentRepository;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("GroupByGroupResolver-dataset.xml")
public class GroupByGroupResolverTest {

    @Autowired
    private RespondentRepository respondentRepository;

    @Autowired
    @Qualifier("GroupByGroupResolver")
    QuestionnairElementResolver resolver;

    @Test
    public void resolveForTest() {
        Integer respondentId = 113;
        Respondent respondent = respondentRepository.findOne(respondentId);
        QuestionGroup questionGroup = (QuestionGroup) resolver.resolveFor(respondent, BrowsingAction.ENTERING);
        new StringBuilder();

        List<Question> questions = questionGroup.getQuestions();
        int pos = 1;
        for (Question question : questions) {

            System.out.println(pos + ". " + question.getLanguageSettings().getTitle());
            pos++;
        }
        System.out.println("*******************");
        questionGroup = (QuestionGroup) resolver.resolveFor(respondent, BrowsingAction.FORWARD);

        questions = questionGroup.getQuestions();
        pos = 1;
        for (Question question : questions) {

            System.out.println(pos + ". " + question.getLanguageSettings().getTitle());
            pos++;
        }

    }
}
