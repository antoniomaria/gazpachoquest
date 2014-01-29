package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionGroupRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionGroupRepositoryTest {

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Test
    public void findOneByPositionInSurveyTest() {
        Integer position = 2;
        Integer surveyId = 2;
        QuestionGroup questionGroup = questionGroupRepository.findOneByPositionInSurvey(surveyId, position);
        assertThat(questionGroup).isEqualTo(QuestionGroup.with().id(6).build());
    }

    @Test
    public void findPositionInSurveyTest() {
        int questionGroupId = 5;
        Integer pos = questionGroupRepository.findPositionInSurvey(questionGroupId);
        assertThat(pos).isEqualTo(1);
    }

    @Test
    public void findQuestionGroupsBySurveyTest() {
        int surveyId = 2;
        List<QuestionGroup> questiongroups = questionGroupRepository.findBySurveyId(surveyId);
        assertThat(questiongroups).hasSize(3);

    }

}
