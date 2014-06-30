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
package net.sf.gazpachoquest.dto.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.answers.AbstractAnswer;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

public abstract class AbstractQuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO> {

    private static final long serialVersionUID = 7798904943703068684L;

    protected String code;

    protected boolean required;

    protected Language language;

    protected QuestionLanguageSettingsDTO languageSettings;

    protected final List<QuestionOptionDTO> questionOptions = new ArrayList<>();

    protected QuestionType type;

    @XmlTransient
    protected Answer answer;

    protected AbstractQuestionDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addQuestionOption(final QuestionOptionDTO questionOption) {
        questionOptions.add(questionOption);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionLanguageSettingsDTO getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettingsDTO();
        }
        return languageSettings;
    }

    public List<QuestionOptionDTO> getQuestionOptions() {
        return Collections.unmodifiableList(questionOptions);
    }

    public QuestionType getType() {
        return type;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setType(final QuestionType type) {
        this.type = type;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(AbstractAnswer answer) {
        this.answer = answer;
    }

}
