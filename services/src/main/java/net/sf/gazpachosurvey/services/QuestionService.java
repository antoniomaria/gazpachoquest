package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;

public interface QuestionService extends LocalizedPersistenceService<Question, QuestionLanguageSettings> {

}
