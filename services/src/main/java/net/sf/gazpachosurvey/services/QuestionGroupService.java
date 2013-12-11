package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;

public interface QuestionGroupService extends
        LocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings> {
}
