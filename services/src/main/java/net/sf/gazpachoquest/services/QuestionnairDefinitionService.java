package net.sf.gazpachoquest.services;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;

public interface QuestionnairDefinitionService extends LocalizedPersistenceService<QuestionnairDefinition, QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {

    QuestionnairDefinition confirm(QuestionnairDefinition questionnairDefinition);

    long questionGroupsCount(Integer surveyId);

}
