package net.sf.gazpachosurvey.facades;

import java.util.Set;

import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.types.Language;

public interface QuestionnairDefinitionAccessorFacade {

    QuestionnairDefinitionDTO findOneSurvey(Integer surveyId);

    Set<Language> findSurveyTranslations(Integer surveyId);

}
