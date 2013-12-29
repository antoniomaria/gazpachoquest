package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.SurveyInstance;
import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.types.InvitationStatus;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitRule;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@DatabaseSetup("InvitationService-dataset.xml")
public class InvitationServiceTest {
    @Rule
    public DbUnitRule dbUnit = new DbUnitRule();

    @Autowired
    private DataSource datasource;

    @Autowired
    private SurveyInstanceService surveyInstanceService;

    @Autowired
    private InvitationService surveyService;

    @Test
    public void findOneByExampleTest() {
        // InvitationDTO example = InvitationDTO.with().type(InvitationType.PERSONAL).token("IQF19ZUVMI").build();
        // InvitationDTO invitation = surveyService.findOneByExample(example, new
        // SearchParameters().caseSensitive(true));
        // assertThat(invitation).isNotNull();
    }

    @Test
    public void saveTest() {
        SurveyInstance surveyInstance = surveyInstanceService.findOne(95);
        Invitation invitation = Invitation.with().surveyInstance(surveyInstance).status(InvitationStatus.ACTIVE)
                .token("1234").build();
        Invitation saved = surveyService.save(invitation);

        Integer invitationId = saved.getId();

        Invitation existing = Invitation.with().id(invitationId).status(InvitationStatus.ACCEPTED).token("4321")
                .build();

        Invitation updated = surveyService.save(existing);

        assertThat(updated.getSurveyInstance()).isNotNull();
    }

}
