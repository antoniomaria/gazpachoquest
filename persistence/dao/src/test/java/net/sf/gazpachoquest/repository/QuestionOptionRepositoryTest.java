package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionOptionRepository-dataset.xml")
@DatabaseTearDown("QuestionOptionRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionOptionRepositoryTest {

    @Autowired
    private QuestionOptionRepository repository;

    @Test
    public void findInListAndLanguageTest() {
        List<Integer> questionOptionIds = Arrays.asList(51, 52, 53, 54, 55);
        List<Object[]> questionsAndTranslations = repository.findInList(questionOptionIds, Language.ES);
        assertThat(questionsAndTranslations).hasSameSizeAs(questionOptionIds);
        for (Object[] questionOptionAndTranslation : questionsAndTranslations) {
            QuestionOption questionOption = (QuestionOption) questionOptionAndTranslation[0];
            QuestionOptionTranslation questionOptionTranslation = (QuestionOptionTranslation) questionOptionAndTranslation[1];
            if (questionOption.getId() == 51) {
                assertThat(questionOptionTranslation.getId()).isEqualTo(60);
            }
        }

    }
}
