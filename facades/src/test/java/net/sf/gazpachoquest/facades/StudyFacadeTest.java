package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.StudyDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.StudyAccessType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("StudyFacade-dataset.xml")
@Transactional
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class StudyFacadeTest {

    @Autowired
    private UserFacade respondentFacade;

    @Autowired
    private StudyFacade studyFacade;

    @Test
    public void saveTest() {
        QuestionnairDefinitionDTO questionnairDefinition = QuestionnairDefinitionDTO.with().id(6).build();
        Set<UserDTO> respondents = new HashSet<>();
        UserDTO respondent = respondentFacade.findOne(2);
        respondents.add(respondent);

        Set<QuestionnairDefinitionDTO> questionnairDefinitions = new HashSet<QuestionnairDefinitionDTO>();
        questionnairDefinitions.add(questionnairDefinition);

        StudyDTO study = StudyDTO.with().type(StudyAccessType.BY_INVITATION).respondents(respondents)
                .questionnairDefinitions(questionnairDefinitions).build();
        study = studyFacade.save(study);
        assertThat(study.isNew()).isFalse();
    }
}
