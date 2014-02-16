package net.sf.gazpachosurvey.dto.support;

import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;

public interface LanguageSettingsContainerBuilder<C extends LanguageSettingsContainerBuilder<C>> {

    C languageSettings(QuestionLanguageSettingsDTO languageSettings);
}
