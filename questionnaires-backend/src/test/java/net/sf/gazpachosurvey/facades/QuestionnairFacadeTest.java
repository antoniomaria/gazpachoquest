package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDTO;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.services.QuestionnairAnswersService;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.RenderingMode;

import org.junit.Before;
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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairFacade-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairFacadeTest {

    @Autowired
    private QuestionnairFacade questionnairFacade;

    @Autowired
    private QuestionnairAnswersRepository repository;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Before
    public void setUp() {
        repository.activeAllAnswers();
    }

    @Test
    public void findByOneTest() {
        Integer questionnairId = 63;
        QuestionnairDTO questionnair = questionnairFacade.findOne(questionnairId);
        assertThat(questionnair).isNotNull();
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

    @Test
    public void resolveFirstPageTest() {
        Questionnair questionnair = Questionnair.with().id(63).build();
        String answer = "Antonio Maria";
        String questionCode = "Q1";
        questionnairAnswersService.save(questionnair, questionCode, answer);
        PageDTO page = questionnairFacade.resolvePage(questionnair.getId(), RenderingMode.QUESTION_BY_QUESTION,
                BrowsingAction.ENTERING);

        for (QuestionDTO questionDTO : page.getQuestions()) {
            System.out.println(questionDTO + " " + questionDTO.getAnswer());
        }
    }

}
