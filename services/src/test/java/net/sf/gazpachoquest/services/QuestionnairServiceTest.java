package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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
@DatabaseSetup("QuestionnairService-dataset.xml")
@DatabaseTearDown("QuestionnairService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairServiceTest {

    @Autowired
    private QuestionnairService questionnairService;

    @Test
    public void findOneByExampleTest() {
        User respondent = User.with().id(6).build();
        Research research = Research.with().id(57).build();
        Questionnair example = Questionnair.with().respondent(respondent).research(research).build();
        Questionnair questionnair = questionnairService.findOneByExample(example, new SearchParameters());
        assertThat(questionnair).isEqualTo(Questionnair.with().id(58).build());
    }
}
