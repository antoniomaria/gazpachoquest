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
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import net.sf.gazpachoquest.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.domain.support.QuestionnairElement;
import net.sf.gazpachoquest.types.Language;

@Entity
@XmlType(propOrder = { "language", "languageSettings", "questions", "translations", "randomizationEnabled" })
public class QuestionGroup extends AbstractLocalizable<QuestionGroupTranslation, QuestionGroupLanguageSettings>
        implements QuestionnairElement {

    private static final long serialVersionUID = 5849288763708940985L;

    @ManyToOne(fetch = FetchType.LAZY)
    @XmlTransient
    private QuestionnairDefinition questionnairDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private QuestionGroupLanguageSettings languageSettings;

    @OneToMany(mappedBy = "questionGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, QuestionGroupTranslation> translations = new HashMap<Language, QuestionGroupTranslation>();

    @OneToMany(mappedBy = "questionGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderColumn(name = "order_in_questiongroup")
    private final List<Question> questions = new ArrayList<Question>();

    @Column(nullable = false)
    private Boolean randomizationEnabled;

    public QuestionGroup() {
        super();
    }

    public Integer getQuestionnairDefinitionId() {
        return questionnairDefinition.getId();
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public QuestionnairDefinition getQuestionnairDefinition() {
        return questionnairDefinition;
    }

    public void setQuestionnairDefinition(QuestionnairDefinition questionnairDefinition) {
        this.questionnairDefinition = questionnairDefinition;
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
    public QuestionGroupLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionGroupLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Map<Language, QuestionGroupTranslation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuestionGroup(this);
    }

    public Boolean isRandomizationEnabled() {
        return randomizationEnabled;
    }

    public void setRandomizationEnabled(Boolean randomizationEnabled) {
        this.randomizationEnabled = randomizationEnabled;
    }

    public void updateInverseRelationships() {
        for (Entry<Language, QuestionGroupTranslation> entry : translations.entrySet()) {
            QuestionGroupTranslation questionGroupTranslation = entry.getValue();
            questionGroupTranslation.setQuestionGroup(this);
            questionGroupTranslation.setLanguage(entry.getKey());
        }
        for (Question question : questions) {
            question.setQuestionGroup(this);
            question.updateInverseRelationships();
        }
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private QuestionnairDefinition questionnairDefinition;
        private Language language;
        private QuestionGroupLanguageSettings languageSettings;
        private Boolean randomizationEnabled;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder questionnairDefinition(QuestionnairDefinition questionnairDefinition) {
            this.questionnairDefinition = questionnairDefinition;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder randomizationEnabled(Boolean randomizationEnabled) {
            this.randomizationEnabled = randomizationEnabled;
            return this;
        }

        public Builder languageSettings(QuestionGroupLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public QuestionGroup build() {
            QuestionGroup questionGroup = new QuestionGroup();
            questionGroup.setId(id);
            questionGroup.questionnairDefinition = questionnairDefinition;
            questionGroup.language = language;
            questionGroup.languageSettings = languageSettings;
            questionGroup.randomizationEnabled = randomizationEnabled;
            return questionGroup;
        }
    }
}
