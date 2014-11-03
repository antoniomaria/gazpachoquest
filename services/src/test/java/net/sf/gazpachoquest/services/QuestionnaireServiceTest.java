package net.sf.gazpachoquest.services;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
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
@DatabaseSetup("QuestionnaireService-dataset.xml")
@DatabaseTearDown("QuestionnaireService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireServiceTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Test
    public void findOneByExampleTest() {
        User respondent = User.with().id(6).build();
        Research research = Research.with().id(57).build();
        Questionnaire example = Questionnaire.with().respondent(respondent).research(research).build();
        Questionnaire questionnaire = questionnaireService.findOneByExample(example, new SearchParameters());
        assertThat(questionnaire).isEqualTo(Questionnaire.with().id(58).build());
    }

    @Test
    public void getDefinitionTest() {
        QuestionnaireDefinition questionnaireDefinition = questionnaireService.getDefinition(58);
        assertThat(questionnaireDefinition).isEqualTo(QuestionnaireDefinition.with().id(7).build());
    }

    @Test
    public void removeBreadcrumbTest() {
        Integer questionnaireId = 58;
        Breadcrumb breadcrumb = Breadcrumb.withProps().id(3).build();
        questionnaireService.removeBreadcrumb(questionnaireId, breadcrumb);
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
