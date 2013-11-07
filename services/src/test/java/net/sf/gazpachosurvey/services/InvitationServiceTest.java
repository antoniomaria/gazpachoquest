package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.dto.InvitationDTO;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml", "classpath:/services-context.xml", "classpath:/mail-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("InvitationService-dataset.xml")
public class InvitationServiceTest {

    @Autowired
    private InvitationService surveyService;
    
    @Test
    public void countTest(){
        long count = surveyService.count();
        assertThat(count).isEqualTo(4);
    }
    
    @Test
    public void findByExampleTest(){
        InvitationDTO example = InvitationDTO.with().token("ATRP7DCW2I").build();
      List<InvitationDTO> results = surveyService.findByExample(example, new SearchParameters().caseSensitive(true));
    System.out.println(results);
    }
    
    @Test
    public void findOneByExampleTest(){
        InvitationDTO example = InvitationDTO.with().token("ATRP7DCW2I").build();
       InvitationDTO invitation = surveyService.findOneByExample(example, new SearchParameters().caseSensitive(true));
    System.out.println(invitation);
    }
    
}
