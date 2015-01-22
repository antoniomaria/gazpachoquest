/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class SectionTranslation extends AbstractPersistable implements Translation<SectionLanguageSettings> {

    private static final long serialVersionUID = -2719163699375812306L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Section section;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Language language;

    @Embedded
    private SectionLanguageSettings languageSettings;

    public SectionTranslation() {
        super();
    }

    public Section getSection() {
        if (section == null) {
            return new Section();
        }
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public SectionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(SectionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder implements TranslationBuilder<SectionTranslation, SectionLanguageSettings> {
        private Section section;
        private Language language;
        private SectionLanguageSettings languageSettings;

        public Builder section(Section section) {
            this.section = section;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(SectionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public SectionTranslation build() {
            SectionTranslation sectionTranslation = new SectionTranslation();
            sectionTranslation.section = section;
            sectionTranslation.language = language;
            sectionTranslation.languageSettings = languageSettings;
            return sectionTranslation;
        }

        @Override
        public Builder translatedEntityId(Integer entityId) {
            Section section = new Section();
            section.setId(entityId);
            return section(section);
        }
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getSection().getId();
    }
}
