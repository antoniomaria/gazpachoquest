package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;

public interface QuestionGroupService extends
        LocalizedPersistenceService<QuestionGroup, QuestionGroupLanguageSettings> {
}
