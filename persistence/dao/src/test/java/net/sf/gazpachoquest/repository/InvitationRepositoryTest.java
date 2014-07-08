package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.InvitationStatus;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("InvitationRepository-dataset.xml")
@DatabaseTearDown("InvitationRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class InvitationRepositoryTest {

    @Autowired
    private ResearchRepository researchRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Test
    public void findAllTest() {
        assertThat(invitationRepository.findAll()).hasSize(5);
    }

    @Test
    public void saveTest() {
        Research research = researchRepository.findOne(57);
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionRepository.findOne(7);

        AnonymousInvitation invitation = AnonymousInvitation.with().research(research).status(InvitationStatus.ACTIVE)
                .token("1234").questionnairDefinition(questionnairDefinition).build();
        Invitation saved = invitationRepository.save(invitation);
        assertThat(saved.isNew()).isFalse();
    }
}