package net.sf.gazpachosurvey.facades;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("StudyFacade-dataset.xml")
public class SurveyInstanceFacadeTest {

    @Autowired
    private ParticipantFacade participantFacade;

    @Autowired
    private StudyFacade studyFacade;

    @Test
    public void saveTest() {
        QuestionnairDefinitionDTO survey = QuestionnairDefinitionDTO.with().id(58).build();

        Set<ParticipantDTO> participants = new HashSet<>();

        ParticipantDTO participant = participantFacade.findOne(127);

        participants.add(participant);

    }
}
