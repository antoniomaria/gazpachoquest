package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDTO;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.RenderingMode;

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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairFacade-dataset.xml")
public class QuestionnairFacadeTest {

    @Autowired
    private QuestionnairFacade questionnairFacade;

    @Test
    public void findByOneTest() {
        Integer questionnairId = 63;
        QuestionnairDTO questionnair = questionnairFacade.findOne(questionnairId);
        System.out.println("de winner is: " + questionnair);
    }

    @Test
    public void resolvePageTest() {
        Integer questionnairId = 63;
        PageDTO page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP,
                BrowsingAction.ENTERING);
        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(17).build(),
                QuestionDTO.with().id(18).build(), QuestionDTO.with().id(34).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.FORWARD);

        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(35).build(),
                QuestionDTO.with().id(36).build(), QuestionDTO.with().id(40).build());

        page = questionnairFacade.resolvePage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.BACKWARD);
        assertThat(page.getQuestions()).containsSequence(QuestionDTO.with().id(17).build(),
                QuestionDTO.with().id(18).build(), QuestionDTO.with().id(34).build());

    }
}
