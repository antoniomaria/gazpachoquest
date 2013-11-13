package net.sf.gazpachosurvey.domain.i18;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.embeddables.PageLanguageSettings;
import net.sf.gazpachosurvey.domain.support.AbstractPersistable;
import net.sf.gazpachosurvey.domain.support.Translation;
import net.sf.gazpachosurvey.domain.support.TranslationBuilder;
import net.sf.gazpachosurvey.types.Language;

@Entity
public class PageTranslation extends AbstractPersistable implements
        Translation<PageLanguageSettings> {

    private static final long serialVersionUID = -2719163699375812306L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Page page;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private PageLanguageSettings languageSettings;

    public PageTranslation() {
        super();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public PageLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(PageLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static class Builder  implements TranslationBuilder<PageTranslation, PageLanguageSettings> { 
        private Page page;
        private Language language;
        private PageLanguageSettings languageSettings;

        public Builder page(Page page) {
            this.page = page;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(PageLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public PageTranslation build() {
            PageTranslation pageTranslation = new PageTranslation();
            pageTranslation.page = page;
            pageTranslation.language = language;
            pageTranslation.languageSettings = languageSettings;
            return pageTranslation;
        }

        @Override
        public Builder translatedEntityId(
                Integer entityId) {
            Page page = new Page();
            page.setId(entityId);
            return page(page);
        }
    }
}
