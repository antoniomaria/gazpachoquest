package net.sf.gazpachosurvey.dto.support;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.types.Language;

public class TranslationDTO<L extends IdentifiableLocalizable<LSD>, LSD extends LanguageSettings> extends
        AbstractIdentifiableDTO implements IdentifiableLocalizable<LSD> {

    private static final long serialVersionUID = -6647673888485425997L;

    private Language language;

    private LSD languageSettings;

    private L translatedEntity;

    public TranslationDTO() {
        super();
    }

    @Override
    public LSD getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(LSD languageSettings) {
        this.languageSettings = languageSettings;
    }

    public L getTranslatedEntity() {
        return translatedEntity;
    }

    public void setTranslatedEntity(L translatedEntity) {
        this.translatedEntity = translatedEntity;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

}
