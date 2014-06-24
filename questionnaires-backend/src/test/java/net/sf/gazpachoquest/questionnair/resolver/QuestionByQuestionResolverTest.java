package net.sf.gazpachoquest.questionnair.resolver;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionByQuestionResolver-dataset.xml")
@DatabaseTearDown("QuestionByQuestionResolver-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionByQuestionResolverTest {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    @Qualifier("QuestionByQuestionResolver")
    private QuestionnairElementResolver resolver;

    @Test
    public void resolveForTest() {
        Integer questionnairId = 58;
        Questionnair respondent = questionnairRepository.findOne(questionnairId);
        Question question = (Question) resolver.resolveFor(respondent, NavigationAction.ENTERING);
        assertThat(question.getLanguageSettings().getTitle()).contains("What is your name?");

        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);
        assertThat(question.getLanguageSettings().getTitle()).contains("What is your age group?");

        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);

        assertThat(question.getLanguageSettings().getTitle()).contains("And for our records,");
        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);

        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);

        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);

        question = (Question) resolver.resolveFor(respondent, NavigationAction.NEXT);

        assertThat(question.getLanguageSettings().getTitle()).contains("Please have a good look");

        question = (Question) resolver.resolveFor(respondent, NavigationAction.PREVIOUS);

        assertThat(question.getLanguageSettings().getTitle()).contains("Which of these ads make");

        question = (Question) resolver.resolveFor(respondent, NavigationAction.PREVIOUS);

        assertThat(question.getLanguageSettings().getTitle()).contains("Given your extraord");
    }
}
