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
package net.sf.gazpachoquest.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

@Entity
public class Question extends AbstractLocalizable<QuestionTranslation, QuestionLanguageSettings> {

    private static final long serialVersionUID = -4372634574851905803L;

    private static final Logger logger = LoggerFactory.getLogger(Question.class);

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType type;

    @Column(nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Question parent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Section section;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn(name = "order_in_subquestions")
    @XmlElementWrapper(name = "subquestions")
    @XmlElement(name = "subquestion")
    private final List<Question> subquestions = new ArrayList<Question>();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_in_question")
    @XmlElementWrapper(name = "question-options")
    @XmlElement(name = "question-option")
    private final List<QuestionOption> questionOptions = new ArrayList<QuestionOption>();

    @Column(nullable = false)
    private Boolean required;

    @Column(nullable = false)
    private Boolean otherAllowed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private QuestionLanguageSettings languageSettings;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, QuestionTranslation> translations = new HashMap<Language, QuestionTranslation>();

    /**
     * Number of question in order of appearance 
     */
    @Transient
    private Integer number;
    
    @Lob
    private String relevance;
    
    public Question() {
        super();
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Question> getSubquestions() {
        return Collections.unmodifiableList(subquestions);
    }

    public Question getParent() {
        return parent;
    }

    public void setParent(Question parent) {
        this.parent = parent;
    }

    public Section getSection() {
        return section;
    }

    public Integer getSectionId() {
        return section.getId();
    }

    public Integer getQuestionnairDefinitionId() {
        return section.getQuestionnairDefinitionId();
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setRequired(Boolean isRequired) {
        required = isRequired;
    }

    public Boolean isRequired() {
        return required;
    }

    public Boolean isOtherAllowed() {
        return otherAllowed;
    }

    public void setOtherAllowed(Boolean otherAllowed) {
        this.otherAllowed = otherAllowed;
    }

    @Override
    public Map<Language, QuestionTranslation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public void addQuestionOption(QuestionOption questionOption) {
        Assert.notNull(questionOption);
        questionOptions.add(questionOption);
        questionOption.setQuestion(this);

    }

    public void addSubquestion(Question subquestion) {
        Assert.notNull(subquestion);
        subquestion.setLanguage(language);
        subquestions.add(subquestion);
        subquestion.setParent(this);
    }

    @Override
    public QuestionLanguageSettings getLanguageSettings() {
        if (languageSettings == null) {
            languageSettings = new QuestionLanguageSettings();
        }
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void addTranslation(Language language, QuestionTranslation translation) {
        translation.setQuestion(this);
        translations.put(language, translation);
    }

    @Transient
    public Integer getNumber() {
        return number;
    }
    
    @Transient
    public void setNumber(Integer number) {
        this.number = number;
    }

    public void updateInverseRelationships() {
        for (Entry<Language, QuestionTranslation> entry : translations.entrySet()) {
            QuestionTranslation questionTranslation = entry.getValue();
            questionTranslation.setQuestion(this);
            questionTranslation.setLanguage(entry.getKey());
        }

        for (QuestionOption questionOption : questionOptions) {
            questionOption.setQuestion(this);
            questionOption.updateInverseRelationships();
        }

        for (Question subquestion : subquestions) {
            subquestion.setParent(this);
            subquestion.updateInverseRelationships();
        }
    }

    public void translateTo(Language language) {
        if (language.equals(this.language)) {
            logger.debug("Question with id={} is already in {} language", getId(), language);
            return;
        }
        QuestionTranslation translation = translations.get(language);
        if (translation != null) {
            languageSettings = translation.getLanguageSettings();
            this.language = language;
        } else {
            logger.info("Question with id={} no available in {} language. Providing {} language", getId(), language,
                    this.language);
        }

        for (Question subquestion : subquestions) {
            subquestion.translateTo(language);
        }
        for (QuestionOption questionOption : questionOptions) {
            questionOption.translateTo(language);
        }

    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String code;
        private Question parent;
        private Section section;
        private Boolean required;
        private Boolean otherAllowed;
        private QuestionType type;
        private Language language;
        private QuestionLanguageSettings languageSettings;
        private Integer number;
        private String relevance;
        
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        public String getRelevance() {
            return relevance;
        }

        public void setRelevance(String relevance) {
            this.relevance = relevance;
        }
        
        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder parent(Question parent) {
            this.parent = parent;
            return this;
        }

        public Builder section(Section section) {
            this.section = section;
            return this;
        }

        public Builder required(Boolean required) {
            this.required = required;
            return this;
        }

        public Builder otherAllowed(Boolean otherAllowed) {
            this.otherAllowed = otherAllowed;
            return this;
        }

        public Builder type(QuestionType type) {
            this.type = type;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder languageSettings(QuestionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Question build() {
            Question question = new Question();
            question.setId(id);
            question.code = code;
            question.parent = parent;
            question.section = section;
            question.required = required;
            question.otherAllowed = otherAllowed;
            question.type = type;
            question.language = language;
            question.languageSettings = languageSettings;
            question.number = number;
            question.relevance = relevance;
            return question;
        }
    }

}
