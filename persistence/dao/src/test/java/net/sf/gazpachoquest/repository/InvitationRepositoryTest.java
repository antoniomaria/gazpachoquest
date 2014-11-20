package net.sf.gazpachoquest.repository;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.InvitationStatus;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("InvitationRepository-dataset.xml")
@DatabaseTearDown("InvitationRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class InvitationRepositoryTest extends AbstractShiroTest {

    @Autowired
    private ResearchRepository researchRepository;

    @Autowired
    private QuestionnaireDefinitionRepository questionnaireDefinitionRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Test
    public void findAllTest() {
        assertThat(invitationRepository.findAll()).hasSize(5);
    }

    @Test
    public void findByExampleTest() {
        Invitation personalInvitation = new Invitation();
        personalInvitation.setToken("NHAZXA4UK9");
        List<Invitation> invitations = invitationRepository.findByExample(personalInvitation, new SearchParameters());
        assertThat(invitations).contains(Invitation.with().id(61).build());
    }

    @Test
    public void findOneByExampleTest() {
        Invitation example = Invitation.with().token("NHAZXA4UK9").build();
        Optional<Invitation> invitation = invitationRepository.findOneByExample(example, new SearchParameters());
        assertThat(invitation.isPresent());
        assertThat(invitation.get()).isEqualTo(Invitation.with().id(61).build());
        
        example = Invitation.with().token("9999999").build();
        invitation = invitationRepository.findOneByExample(example, new SearchParameters());
        assertThat(invitation.isPresent()).isFalse();
    }

    @Test
    public void saveTest() {
        Research research = researchRepository.findOne(57);

        AnonymousInvitation invitation = AnonymousInvitation.with().research(research).status(InvitationStatus.ACTIVE)
                .token("1234").build();
        Invitation saved = invitationRepository.save(invitation);
        assertThat(saved.isNew()).isFalse();
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
