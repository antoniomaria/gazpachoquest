package net.sf.gazpachosurvey.facades.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.facades.QuestionnairFacade;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.Language;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairFacadeImpl implements QuestionnairFacade {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairFacadeImpl.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private SurveyService surveyService;

    @Override
    public QuestionnairDefinitionDTO findQuestionnairDefinitionFor(Respondent respondent) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        logger.debug("Respondent {} retriving QuestionnairDefinition for surveyId = {}", respondent.getId(), surveyId);

        Set<Language> translationsSupported = surveyService.translationsSupported(surveyId);

        SurveyLanguageSettingsDTO languageSettingsDTO = mapper.map(survey.getLanguageSettings(),
                SurveyLanguageSettingsDTO.class);
        QuestionnairDefinitionDTO definition = QuestionnairDefinitionDTO.with().languageSettings(languageSettingsDTO)
                .language(survey.getLanguage()).translationsSupported(translationsSupported).build();
        return definition;
    }

}
