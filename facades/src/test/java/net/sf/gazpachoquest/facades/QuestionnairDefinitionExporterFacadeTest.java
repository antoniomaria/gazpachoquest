package net.sf.gazpachoquest.facades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.XmlMappingException;
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
@DatabaseSetup("QuestionnairDefinitionExporterFacade-dataset.xml")
@DatabaseTearDown("QuestionnairDefinitionExporterFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionExporterFacadeTest {

    @Autowired
    private QuestionnairDefinitionExporterFacade questionnairDefinitionExporterFacade;

    @Test
    public void exportTest() {
        Integer questionnairDefinition = 7;
        try {
            questionnairDefinitionExporterFacade.exportQuestionnairDefinition(questionnairDefinition, System.out);
        } catch (XmlMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void importTest() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(
                "src/test/resources/net/sf/gazpachoquest/facades/MyQuestionnairDefinition.xml");
        try {
            questionnairDefinitionExporterFacade.importQuestionnairDefinition(fis);
        } catch (XmlMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
