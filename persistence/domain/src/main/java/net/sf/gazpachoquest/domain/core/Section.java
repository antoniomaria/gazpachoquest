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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.SectionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.Language;

@Entity
@XmlType(propOrder = { "language", "languageSettings", "questions", "translations", "randomizationEnabled" })
public class Section extends AbstractLocalizable<SectionTranslation, SectionLanguageSettings> {

    private static final long serialVersionUID = 5849288763708940985L;

    @ManyToOne(fetch = FetchType.LAZY)
    @XmlTransient
    private QuestionnaireDefinition questionnaireDefinition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Embedded
    private SectionLanguageSettings languageSettings;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private final Map<Language, SectionTranslation> translations = new HashMap<Language, SectionTranslation>();

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderColumn(name = "order_in_section")
    @XmlElementWrapper(name = "questions")
    @XmlElement(name = "question")
    private final List<Question> questions = new ArrayList<Question>();

    @Column(nullable = false)
    private Boolean randomizationEnabled;

    public Section() {
        super();
    }

    public Integer getQuestionnairDefinitionId() {
        return questionnaireDefinition.getId();
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public List<Integer> getQuestionsId() {
        List<Integer> questionsId = new ArrayList<>();
        for (Question question : questions) {
            questionsId.add(question.getId());
        }
        return Collections.unmodifiableList(questionsId);
    }

    public QuestionnaireDefinition getQuestionnairDefinition() {
        return questionnaireDefinition;
    }

    public void setQuestionnairDefinition(QuestionnaireDefinition questionnaireDefinition) {
        this.questionnaireDefinition = questionnaireDefinition;
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

    @Override
    public Map<Language, SectionTranslation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setSection(this);
    }

    public Boolean isRandomizationEnabled() {
        return randomizationEnabled;
    }

    public void setRandomizationEnabled(Boolean randomizationEnabled) {
        this.randomizationEnabled = randomizationEnabled;
    }

    public void updateInverseRelationships() {
        for (Entry<Language, SectionTranslation> entry : translations.entrySet()) {
            SectionTranslation sectionTranslation = entry.getValue();
            sectionTranslation.setSection(this);
            sectionTranslation.setLanguage(entry.getKey());
        }
        for (Question question : questions) {
            question.setSection(this);
            question.updateInverseRelationships();
        }
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private QuestionnaireDefinition questionnaireDefinition;
        private Language language;
        private SectionLanguageSettings languageSettings;
        private Boolean randomizationEnabled;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder questionnaireDefinition(QuestionnaireDefinition questionnaireDefinition) {
            this.questionnaireDefinition = questionnaireDefinition;
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

        public Builder languageSettings(SectionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Section build() {
            Section section = new Section();
            section.setId(id);
            section.questionnaireDefinition = questionnaireDefinition;
            section.language = language;
            section.languageSettings = languageSettings;
            section.randomizationEnabled = randomizationEnabled;
            return section;
        }
    }

}
