package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;
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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
		"classpath:/datasource-test-context.xml",
		"classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("InvitationService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class InvitationServiceTest {

	@Autowired
	private ResearchService researchService;

	@Autowired
	private InvitationService invitationService;

	@Test
	public void findAllTest() {
		assertThat(invitationService.findAll()).hasSize(5);
	}

	@Test
	public void saveTest() {
		Research research = researchService.findOne(57);
		Invitation invitation = Invitation.with().research(research)
				.status(InvitationStatus.ACTIVE).token("1234").build();
		Invitation saved = invitationService.save(invitation);

		Integer invitationId = saved.getId();

		Invitation existing = Invitation.with().id(invitationId)
				.status(InvitationStatus.ACCEPTED).token("4321").build();

		Invitation updated = invitationService.save(existing);

		assertThat(updated.getResearch()).isNotNull();
	}

}
