package net.sf.gazpachoquest.facades;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.support.PageDTO;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
@DatabaseSetup("ResearchFacade-dataset.xml")
@DatabaseTearDown("ResearchFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class ResearchFacadeTest extends AbstractShiroTest {

    @Autowired
    private UserFacade respondentFacade;

    @Autowired
    private ResearchFacade researchFacade;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        questionnaireAnswersRepository.activeAllAnswers();
    }


    @Test
    public void findPaginatedTest() {
        PageDTO<ResearchDTO> page = researchFacade.findPaginated(1, 5);
        assertThat(page.getTotalPages()).isEqualTo(1);
        assertThat(page.getTotalElements()).isEqualTo(1);
        ResearchDTO research = page.getElements().get(0);
        assertThat(research).isEqualTo(ResearchDTO.with().id(57).build());
        assertThat(research.getName()).isNotEmpty();
        assertThat(research.getCreatedBy()).isNotNull();
        assertThat(research.getQuestionnaireDefinition().getId()).isEqualTo(7);
        assertThat(research.getQuestionnaireDefinition().getCreatedBy()).isNull();
        assertThat(research.getQuestionnaireDefinition().getSections()).isEmpty();
    }
    
    @Test
    public void saveTest() {
        QuestionnaireDefinitionDTO questionnaireDefinition = QuestionnaireDefinitionDTO.with().id(7).build();
        ResearchDTO research = ResearchDTO.with().name("My research").type(ResearchAccessType.BY_INVITATION).build();
        research.setQuestionnaireDefinition(questionnaireDefinition);
        research = researchFacade.save(research);
        assertThat(research.isNew()).isFalse();
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnaire_answers_7");
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
