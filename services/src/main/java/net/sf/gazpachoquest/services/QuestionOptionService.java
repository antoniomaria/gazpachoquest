package net.sf.gazpachoquest.services;

import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionOptionTranslation;

public interface QuestionOptionService extends
        LocalizedPersistenceService<QuestionOption, QuestionOptionTranslation, QuestionOptionLanguageSettings> {
}
