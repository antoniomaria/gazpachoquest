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

import net.sf.gazpachoquest.dto.support.AbstractQuestionDTO;
import net.sf.gazpachoquest.dto.support.LanguageSettingsContainerBuilder;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

public class QuestionDTO extends AbstractQuestionDTO {
    private static final long serialVersionUID = 2663159055152157679L;

    private final List<SubquestionDTO> subquestions = new ArrayList<>();

    public QuestionDTO() {
        super();
    }

    public void addSubquestion(final SubquestionDTO subQuestion) {
        subquestions.add(subQuestion);
    }

    public List<SubquestionDTO> getSubquestions() {
        return Collections.unmodifiableList(subquestions);
    }

    public static class BuilderImpl implements LanguageSettingsContainerBuilder<BuilderImpl> {
        private String code;
        private Integer id;
        private boolean required;
        private boolean otherAllowed;
        private Language language;
        private QuestionLanguageSettingsDTO languageSettings;
        private QuestionType type;

        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(id);
            questionDTO.code = code;
            questionDTO.required = required;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.languageSettings = languageSettings;
            questionDTO.setOtherAllowed(otherAllowed);
            return questionDTO;
        }

        public BuilderImpl id(final Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl required(final boolean required) {
            this.required = required;
            return this;
        }

        public BuilderImpl otherAllowed(final boolean otherAllowed) {
            this.otherAllowed = otherAllowed;
            return this;
        }

        public BuilderImpl language(final Language language) {
            this.language = language;
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

        @Override
        public BuilderImpl languageSettings(QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

    }

    public static BuilderImpl with() {
        return new BuilderImpl();
    }

}
