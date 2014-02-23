package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;

public interface LanguageSettingsContainerBuilder<C extends LanguageSettingsContainerBuilder<C>> {

    C languageSettings(QuestionLanguageSettingsDTO languageSettings);
}
