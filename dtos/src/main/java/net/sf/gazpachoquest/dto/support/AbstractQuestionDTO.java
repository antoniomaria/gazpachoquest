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

import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.answers.AbstractAnswer;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

@SuppressWarnings("serial")

/**
 * @opt inferreltype composed
 */
public abstract class AbstractQuestionDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<QuestionLanguageSettingsDTO>{

    protected String code;

    protected boolean required;

    private boolean otherAllowed;

    protected Language language;

    protected QuestionLanguageSettingsDTO languageSettings;

    protected final List<QuestionOptionDTO> questionOptions = new ArrayList<>();

    protected QuestionType type;

    @XmlTransient
    protected Answer answer;

    private String relevance;

    protected AbstractQuestionDTO() {
        super();
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
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

    public boolean isOtherAllowed() {
        return otherAllowed;
    }

    public void setOtherAllowed(boolean otherAllowed) {
        this.otherAllowed = otherAllowed;
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
