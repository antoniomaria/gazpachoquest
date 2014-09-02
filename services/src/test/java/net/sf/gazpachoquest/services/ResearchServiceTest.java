package net.sf.gazpachoquest.services;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.repository.QuestionnaireRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
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
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("ResearchService-dataset.xml")
@DatabaseTearDown("ResearchService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class ResearchServiceTest extends AbstractShiroTest {

    @Autowired
    @Qualifier("researchServiceImpl")
    private ResearchService researchService;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Test
    public void findOneTest() {
        Research research = researchService.findOne(57);
        assertThat(research.isNew()).isFalse();
    }

    @Test
    public void saveTest() {
        Set<QuestionnaireDefinition> questionnaireDefinitions = new HashSet<>();
        questionnaireDefinitions.add(QuestionnaireDefinition.with().id(7).build());

        Set<User> respondents = new HashSet<>();
        respondents.add(User.with().id(6).build());

        Research research = Research.with().type(ResearchAccessType.BY_INVITATION).name("New Research")
                .startDate(new DateTime()).expirationDate(new DateTime().plusDays(30)).build();
        research = researchService.save(research, questionnaireDefinitions, respondents);
        assertThat(research.isNew()).isFalse();
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

    @Before
    public void activeAllAnswers() {
        questionnaireAnswersRepository.activeAllAnswers();
    }

    @After
    public void tearDownSubject() {
        // 3. Unbind the subject from the current thread:
        clearSubject();
    }
}
