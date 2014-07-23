package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionService-dataset.xml")
@DatabaseTearDown("QuestionService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void findInListByLanguageTest() {
        List<Integer> questionIds = Arrays.asList(12, 39, 29, 30, 50);
        Language preferedLanguage = Language.ES;
        List<Question> questions = questionService.findInList(questionIds, preferedLanguage);

        for (Question question : questions) {
            assertThat(question.getLanguage()).isEqualTo(preferedLanguage);
            for (QuestionOption questionOption : question.getQuestionOptions()) {
                assertThat(questionOption.getLanguage()).isEqualTo(preferedLanguage);
            }
            for (Question subquestion : question.getSubquestions()) {
                assertThat(subquestion.getLanguage()).isEqualTo(preferedLanguage);
            }
        }
        assertThat(questions).hasSameSizeAs(questionIds);
    }
}
