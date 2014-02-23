package net.sf.gazpachosurvey.domain.support;

import net.sf.gazpachoquest.types.Language;

public interface TranslationBuilder<TR extends Translation<LS>, LS extends LanguageSettings> {
    TranslationBuilder<TR, LS> language(Language language);

    TranslationBuilder<TR, LS> languageSettings(LS languageSettings);

    TranslationBuilder<TR, LS> translatedEntityId(Integer entityId);

    TR build();
}
