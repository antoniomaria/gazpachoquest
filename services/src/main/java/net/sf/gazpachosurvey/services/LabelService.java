package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.LabelTranslation;

public interface LabelService extends LocalizedPersistenceService<Label, LabelTranslation, LabelLanguageSettings> {

}
