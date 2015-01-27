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

import net.sf.gazpachoquest.dto.embeddables.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;

@SuppressWarnings("serial")
public class QuestionOptionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionOptionLanguageSettingsDTO> {

    private String code;

    private Language language;

    private QuestionOptionLanguageSettingsDTO languageSettings;

    public QuestionOptionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionOptionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionOptionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static class Builder {
        private String code;
        private Language language;
        private String title;

        public QuestionOptionDTO build() {
            QuestionOptionDTO questionOptionDTO = new QuestionOptionDTO();
            questionOptionDTO.code = code;
            questionOptionDTO.languageSettings = new QuestionOptionLanguageSettingsDTO();
            questionOptionDTO.languageSettings.setTitle(title);
            questionOptionDTO.language = language;
            return questionOptionDTO;
        }

        public Builder code(final String code) {
            this.code = code;
            return this;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }
}
