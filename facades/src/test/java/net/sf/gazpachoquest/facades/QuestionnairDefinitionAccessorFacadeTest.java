package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionAccessorFacade-dataset.xml")
@DatabaseTearDown("QuestionnairDefinitionAccessorFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionAccessorFacadeTest {

    @Autowired
    private QuestionnairDefinitionAccessorFacade questionnairDefinitionAccessorFacade;

    @Test
    public void findOneSurveyTest() {
        int questionnairDefinitionId = 7;
        QuestionnairDefinitionDTO questionnairDefinition = questionnairDefinitionAccessorFacade
                .findOneQuestionnairDefinition(questionnairDefinitionId);
        assertThat(questionnairDefinition).isNotNull();
    }
}
