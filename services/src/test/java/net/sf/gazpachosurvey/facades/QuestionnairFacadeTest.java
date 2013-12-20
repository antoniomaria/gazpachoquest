package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.repository.RespondentRepository;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.Language;

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
@DatabaseSetup("QuestionnairFacade-dataset.xml")
public class QuestionnairFacadeTest {

    @Rule
    public DbUnitRule dbUnit = new DbUnitRule();

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
        Respondent respondent = respondentRepository.findOne(127);
        QuestionnairDefinitionDTO definition = questionnairFacade.findQuestionnairDefinitionFor(respondent);
        assertThat(definition.getLanguageSettings().getTitle()).contains("Food Quality Modified");
    }
}
