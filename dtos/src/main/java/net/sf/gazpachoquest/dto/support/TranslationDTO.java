package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.types.Language;

public class TranslationDTO<L extends IdentifiableLocalizable<LSD>, LSD extends LanguageSettingsDTO> extends
        AbstractIdentifiableDTO implements IdentifiableLocalizable<LSD> {

    private static final long serialVersionUID = -6647673888485425997L;

    private Language language;

    private LSD languageSettings;

    private L translatedEntity;

    public TranslationDTO() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public LSD getLanguageSettings() {
        return languageSettings;
    }

    public L getTranslatedEntity() {
        return translatedEntity;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final LSD languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setTranslatedEntity(final L translatedEntity) {
        this.translatedEntity = translatedEntity;
    }

}
