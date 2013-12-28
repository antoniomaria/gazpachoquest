package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairPageDTO;
import net.sf.gazpachosurvey.repository.RespondentRepository;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.RenderingMode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitRule;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairFacade-dataset.xml")
public class QuestionnairFacadeTest {

    @Autowired
    private DataSource datasource;

    @Autowired
    private QuestionnairFacade questionnairFacade;

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private RespondentRepository respondentRepository;

    @Test
    public void findQuestionnairDefinitionForTest() {
        Respondent respondent = respondentRepository.findOne(114);
        QuestionnairDefinitionDTO definition = questionnairFacade.findQuestionnairDefinitionFor(respondent);
        assertThat(definition.getLanguageSettings().getTitle()).contains("Food Quality");
    }

    @Test
    public void composeQuestionnairPageTest() {
        Respondent respondent = respondentRepository.findOne(113);
        RenderingMode mode = RenderingMode.GROUP_BY_GROUP;
        BrowsingAction action = null;
        StringBuilder out = new StringBuilder();

        QuestionnairPageDTO page = questionnairFacade.composeQuestionnairPage(respondent, mode, action, Language.EN);
        QuestionGroupDTO questionGroup = page.getQuestionGroup();
        out.append(questionGroup.getLanguageSettings().getTitle());
        out.append("\n");
        
        action = BrowsingAction.FORWARD;
        page = questionnairFacade.composeQuestionnairPage(respondent, mode, action, Language.EN);
        questionGroup = page.getQuestionGroup();
        out.append(questionGroup.getLanguageSettings().getTitle());
        out.append("\n");
        
        action = BrowsingAction.BACKWARD;
        page = questionnairFacade.composeQuestionnairPage(respondent, mode, action, Language.EN);
        questionGroup = page.getQuestionGroup();
        out.append(questionGroup.getLanguageSettings().getTitle());
        out.append("\n");
       
        action = BrowsingAction.FORWARD;
        page = questionnairFacade.composeQuestionnairPage(respondent, mode, action, Language.EN);
        questionGroup = page.getQuestionGroup();
        out.append(questionGroup.getLanguageSettings().getTitle());
        out.append("\n");
       
       
        action = BrowsingAction.FORWARD;
        page = questionnairFacade.composeQuestionnairPage(respondent, mode, action, Language.EN);
        questionGroup = page.getQuestionGroup();
        out.append(questionGroup.getLanguageSettings().getTitle());
        out.append("\n");
       
        System.out.println(out);

    }
}
