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

import net.sf.gazpachoquest.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.LanguageSettingsContainerBuilder;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

@SuppressWarnings("serial")
public class SubquestionDTO extends AbstractQuestionDTO {

    public SubquestionDTO() {
        super();
    }

    public static class BuilderImpl implements LanguageSettingsContainerBuilder<BuilderImpl> {
        private String code;
        private Integer id;
        private Boolean required = Boolean.FALSE;
        private Language language;
        private QuestionLanguageSettingsDTO languageSettings;
        private QuestionType type;
        private final String relevance = "";

        public SubquestionDTO build() {
            SubquestionDTO questionDTO = new SubquestionDTO();
            questionDTO.setId(id);
            questionDTO.code = code;
            questionDTO.required = required;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.languageSettings = languageSettings;
            questionDTO.setRelevance(relevance);
            return questionDTO;
        }

        public BuilderImpl id(final Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl required(final Boolean required) {
            this.required = required;
            return this;
        }

        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public QuestionLanguageSettingsDTO.BuilderImpl<BuilderImpl> languageSettingsStart() {
            return new QuestionLanguageSettingsDTO.BuilderImpl<BuilderImpl>(this);
        }

        public BuilderImpl type(final QuestionType type) {
            this.type = type;
            return this;
        }

        public BuilderImpl code(String code) {
            this.code = code;
            return this;
        }
    }

    public static BuilderImpl with() {
        return new BuilderImpl();
    }

}
