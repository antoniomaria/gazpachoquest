package net.sf.gazpachoquest.services;

import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.i18.LabelTranslation;

public interface LabelService extends LocalizedPersistenceService<Label, LabelTranslation, LabelLanguageSettings> {

}
