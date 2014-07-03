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

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;

public class QuestionGroupDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<QuestionGroupLanguageSettingsDTO> {
    private static final long serialVersionUID = 4668205160387380803L;

    private Language language;

    private QuestionGroupLanguageSettingsDTO languageSettings;

    private final List<QuestionDTO> questions = new ArrayList<>();

    private Boolean randomizationEnabled;

    public QuestionGroupDTO() {
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
    public QuestionGroupLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

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
    public void setLanguageSettings(final QuestionGroupLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Boolean isRandomizationEnabled() {
        return randomizationEnabled;
    }

    public void setRandomizationEnabled(Boolean randomizationEnabled) {
        this.randomizationEnabled = randomizationEnabled;
    }

    public static interface Builder {

        QuestionGroupDTO build();

        Builder language(Language language);

        Builder randomizationEnabled(Boolean randomizationEnabled);

        Builder languageSettings(QuestionGroupLanguageSettingsDTO languageSettings);

        QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private Boolean randomizationEnabled;

        private QuestionGroupLanguageSettingsDTO languageSettings;

        @Override
        public QuestionGroupDTO build() {
            QuestionGroupDTO questionGroupDTO = new QuestionGroupDTO();
            questionGroupDTO.languageSettings = languageSettings;
            questionGroupDTO.language = language;
            questionGroupDTO.randomizationEnabled = randomizationEnabled;
            return questionGroupDTO;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionGroupLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return QuestionGroupLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }

        @Override
        public Builder randomizationEnabled(Boolean randomizationEnabled) {
            this.randomizationEnabled = randomizationEnabled;
            return this;
        }
    }

    public static Builder with() {
        return new BuilderImpl();
    }

}
