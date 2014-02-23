package net.sf.gazpachoquest.services;

import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionnairDefinitionTranslation;

public interface QuestionnairDefinitionService extends LocalizedPersistenceService<QuestionnairDefinition, QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {

    QuestionnairDefinition confirm(QuestionnairDefinition questionnairDefinition);

    long questionGroupsCount(Integer surveyId);

}
