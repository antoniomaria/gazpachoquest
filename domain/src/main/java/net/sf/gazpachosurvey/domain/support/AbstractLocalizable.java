package net.sf.gazpachosurvey.domain.support;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import net.sf.gazpachosurvey.types.Language;

@MappedSuperclass
public abstract class AbstractLocalizable<TR extends Translation<LS>, LS extends LanguageSettings> extends
        AbstractAuditable implements Localizable<LS, TR> {

    private static final long serialVersionUID = 7865009425435975791L;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Language language;

    protected AbstractLocalizable() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public abstract LS getLanguageSettings();

    @Override
    public abstract Map<Language, TR> getTranslations();

}
