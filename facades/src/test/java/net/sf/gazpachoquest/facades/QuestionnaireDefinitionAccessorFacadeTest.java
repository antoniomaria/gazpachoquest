package net.sf.gazpachoquest.facades;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
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
@DatabaseSetup("QuestionnaireDefinitionAccessorFacade-dataset.xml")
@DatabaseTearDown("QuestionnaireDefinitionAccessorFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireDefinitionAccessorFacadeTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireDefinitionAccessorFacade questionnaireDefinitionAccessorFacade;

    @Test
    public void findOneSurveyTest() {
        int questionnairDefinitionId = 7;
        QuestionnaireDefinitionDTO questionnairDefinition = questionnaireDefinitionAccessorFacade
                .findOneQuestionnaireDefinition(questionnairDefinitionId);
        assertThat(questionnairDefinition).isNotNull();
    }

    @Test
    public void exportTest() throws XmlMappingException, IOException {
        Integer questionnairDefinition = 7;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        questionnaireDefinitionAccessorFacade.exportQuestionnaireDefinition(questionnairDefinition, baos);
        assertThat(baos.toString()).contains("questionnaire-definition");
    }

    @Test
    public void importTest() throws XmlMappingException, IOException {
        FileInputStream fis = new FileInputStream(
                "src/test/resources/net/sf/gazpachoquest/facades/QuestionnaireDefinition_12.xml");
        try {
            QuestionnaireDefinitionDTO imported = questionnaireDefinitionAccessorFacade
                    .importQuestionnaireDefinition(fis);
            assertThat(imported.isNew()).isFalse();
        } finally {
            fis.close();
        }
    }

    @Before
    public void setUpSubject() {
        Subject subjectUnderTest = createNiceMock(Subject.class);
        User support = User.with().id(1).build();
        expect(subjectUnderTest.getPrincipal()).andReturn(support).anyTimes();
        replay(subjectUnderTest);
        // 2. Bind the subject to the current thread:
        setSubject(subjectUnderTest);
    }

    @After
    public void tearDownSubject() {
        // 3. Unbind the subject from the current thread:
        clearSubject();
    }
}
