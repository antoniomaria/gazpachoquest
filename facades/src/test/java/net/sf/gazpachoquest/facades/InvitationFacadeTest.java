package net.sf.gazpachoquest.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.dto.AnonymousInvitationDTO;
import net.sf.gazpachoquest.dto.InvitationDTO;
import net.sf.gazpachoquest.dto.PersonalInvitationDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("InvitationFacadeTest-dataset.xml")
@DatabaseTearDown("InvitationFacadeTest-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class InvitationFacadeTest {
    
    @Autowired
    private InvitationFacade invitationFacade;
    
    @Test
    public void findByExampleTest(){
       InvitationDTO invitationDTO = new InvitationDTO();
       invitationDTO.setResearch(ResearchDTO.with().id(57).build());
        
       List<InvitationDTO> invitations = invitationFacade.findByExample(invitationDTO);
       assertThat(invitations).isNotEmpty();
       assertThat(invitations.get(0)).isExactlyInstanceOf(PersonalInvitationDTO.class);
       assertThat(invitations.get(1)).isExactlyInstanceOf(AnonymousInvitationDTO.class);
       
       PersonalInvitationDTO personalInvitation = new PersonalInvitationDTO();
       personalInvitation.setRespondent(UserDTO.with().id(6).build());
       invitations = invitationFacade.findByExample(invitationDTO);
       assertThat(invitations).isNotEmpty();
       assertThat(invitations.get(0)).isExactlyInstanceOf(PersonalInvitationDTO.class);
       assertThat(invitations.get(0).getId()).isEqualTo(1);
    }

}
