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
package net.sf.gazpachoquest.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.dto.embeddables.SectionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SectionDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<SectionLanguageSettingsDTO> {
    private static final long serialVersionUID = 4668205160387380803L;

    private Language language;

    private SectionLanguageSettingsDTO languageSettings;

    private final List<QuestionDTO> questions = new ArrayList<>();

    private Boolean randomizationEnabled;

    private String relevance;

    public SectionDTO() {
        super();
    }

    public void addQuestion(final QuestionDTO question) {
        questions.add(question);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public SectionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @JsonIgnore
    public QuestionDTO getLastQuestionDTO() {
        int count = questions.size();
        return count > 0 ? questions.get(count - 1) : null;
    }

    public List<QuestionDTO> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final SectionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Boolean isRandomizationEnabled() {
        return randomizationEnabled;
    }

    public void setRandomizationEnabled(Boolean randomizationEnabled) {
        this.randomizationEnabled = randomizationEnabled;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public static interface Builder {

        SectionDTO build();

        Builder language(Language language);

        Builder randomizationEnabled(Boolean randomizationEnabled);

        Builder languageSettings(SectionLanguageSettingsDTO languageSettings);

        Builder relevance(String relevance);
        
        SectionLanguageSettingsDTO.Builder pageLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private Boolean randomizationEnabled = Boolean.FALSE;

        private SectionLanguageSettingsDTO languageSettings;
        
        private String relevance = "";

        @Override
        public SectionDTO build() {
            SectionDTO sectionDTO = new SectionDTO();
            if (languageSettings == null){
                languageSettings = pageLanguageSettingsStart().build();
            }
            sectionDTO.languageSettings = languageSettings;
            sectionDTO.language = language;
            sectionDTO.randomizationEnabled = randomizationEnabled;
            sectionDTO.relevance = relevance;
            return sectionDTO;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final SectionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public SectionLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return SectionLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }

        @Override
        public Builder randomizationEnabled(Boolean randomizationEnabled) {
            this.randomizationEnabled = randomizationEnabled;
            return this;
        }

        @Override
        public Builder relevance(String relevance) {
            this.relevance = relevance;
            return this;
        }
    }

    public static Builder with() {
        return new BuilderImpl();
    }

}
