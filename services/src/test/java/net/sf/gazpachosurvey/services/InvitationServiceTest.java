package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.dto.InvitationDTO;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.types.InvitationType;

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
/*
 * @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
 * TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
 */
@DatabaseSetup("InvitationService-dataset.xml")
public class InvitationServiceTest {
    @Rule
    public DbUnitRule dbUnit = new DbUnitRule();

    @Autowired
    DataSource datasource;

    @Autowired
    private InvitationService surveyService;

    @Test
    public void countTest() {
        long count = surveyService.count();
        assertThat(count).isEqualTo(4);
    }

    @Test
    public void findOneByExampleTest() {
        InvitationDTO example = InvitationDTO.with().type(InvitationType.PERSONAL).token("IQF19ZUVMI").build();
        InvitationDTO invitation = surveyService.findOneByExample(example, new SearchParameters().caseSensitive(true));
        assertThat(invitation).isNotNull();
    }

}
