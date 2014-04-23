package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.ResearchAccessType;

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
public class ResearchFacadeTest {

    @Autowired
    private UserFacade respondentFacade;

    @Autowired
    private ResearchFacade researchFacade;

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        questionnairAnswersRepository.activeAllAnswers();
    }

    @Test
    public void saveTest() {
        QuestionnairDefinitionDTO questionnairDefinition = QuestionnairDefinitionDTO.with().id(7).build();
        Set<UserDTO> respondents = new HashSet<>();
        UserDTO respondent = respondentFacade.findOne(6);
        respondents.add(respondent);

        Set<QuestionnairDefinitionDTO> questionnairDefinitions = new HashSet<QuestionnairDefinitionDTO>();
        questionnairDefinitions.add(questionnairDefinition);

        ResearchDTO research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION).respondents(respondents)
                .questionnairDefinitions(questionnairDefinitions).build();
        research = researchFacade.save(research);
        assertThat(research.isNew()).isFalse();
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("delete from questionnair_answers_7");
    }
}
