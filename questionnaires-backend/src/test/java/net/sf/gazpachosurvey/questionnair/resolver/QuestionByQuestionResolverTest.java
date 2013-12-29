package net.sf.gazpachosurvey.questionnair.resolver;

import net.sf.gazpachosurvey.domain.core.Question;
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
@DatabaseSetup("QuestionByQuestionResolver-dataset.xml")
public class QuestionByQuestionResolverTest {

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    QuestionnairElementResolver resolver;

    @Autowired
    private RespondentRepository respondentRepository;

    @Test
    public void resolveForTest() {
        Integer respondentId = 113;
        Respondent respondent = respondentRepository.findOne(respondentId);
        Question question = (Question) resolver.resolveFor(respondent, BrowsingAction.ENTERING);
        StringBuilder out = new StringBuilder();
        out.append("1: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("2: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("3: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("4: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("5: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("6: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.FORWARD);
        out.append("7: " + question.getLanguageSettings().getTitle() + "\n");

        System.out.println(out);
        System.out.println("************");
        out = new StringBuilder();

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.BACKWARD);
        out.append("6?: " + question.getLanguageSettings().getTitle() + "\n");

        question = (Question) resolver.resolveFor(respondent, BrowsingAction.BACKWARD);
        out.append("5?: " + question.getLanguageSettings().getTitle() + "\n");
        System.out.println(out);

    }
}
