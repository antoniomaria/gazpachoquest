package net.sf.gazpachosurvey.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.domain.support.AbstractLocalizable;
import net.sf.gazpachosurvey.types.EntityStatus;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;

@Entity
public class Survey extends
        AbstractLocalizable<SurveyTranslation, SurveyLanguageSettings> {

    private static final long serialVersionUID = 2560468772707058412L;

    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Embedded
    private SurveyLanguageSettings languageSettings;

    @Enumerated(EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SurveyInstance> surveysRunning;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, SurveyTranslation> translations;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "order_in_survey")
    private List<QuestionGroup> questionGroups;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "type", insertable = false, updatable = false)
    private Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates;

    public Survey() {
        super();
    }

    public Set<SurveyInstance> getSurveysRunning() {
        if (surveysRunning == null) {
            surveysRunning = new HashSet<>();
        }
        return surveysRunning;
    }

    public void setSurveysRunning(Set<SurveyInstance> surveysRunning) {
        this.surveysRunning = surveysRunning;
    }

    @Override
    public Map<Language, SurveyTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, SurveyTranslation> translations) {
        this.translations = translations;
    }

    public void addSurveyInstance(SurveyInstance surveyInstance) {
        getSurveysRunning().add(surveyInstance);
        surveyInstance.setSurvey(this);
    }

    public void removeSurveyInstance(SurveyInstance surveyInstance) {
        getSurveysRunning().remove(surveyInstance);
        surveyInstance.setSurvey(null);
    }

    public List<QuestionGroup> getQuestionGroups() {
        if (questionGroups == null) {
            questionGroups = new ArrayList<>();
        }
        return questionGroups;
    }

    public void setQuestionGroups(List<QuestionGroup> questionGroups) {
        this.questionGroups = questionGroups;
    }

    public void addQuestionGroup(QuestionGroup questionGroup) {
        questionGroup.setSurvey(this);
        getQuestionGroups().add(questionGroup);
    }

    @Override
    public SurveyLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(SurveyLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Map<MailMessageTemplateType, MailMessageTemplate> getMailTemplates() {
        if (mailTemplates == null){
            mailTemplates = new HashMap<>();
        }
        return mailTemplates;
    }

    public void setMailTemplates(
            Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates) {
        this.mailTemplates = mailTemplates;
    }

    @Override
    public void addTranslation(Language language, SurveyTranslation translation) {
        translation.setSurvey(this);
        getTranslations().put(language, translation);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private SurveyLanguageSettings languageSettings;
        private Language language;
        private Set<SurveyInstance> surveysRunning;
        private Map<Language, SurveyTranslation> translations;
        private List<QuestionGroup> questionGroups;
        private Set<Question> questions;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder languageSettings(SurveyLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public Builder surveysRunning(Set<SurveyInstance> surveysRunning) {
            this.surveysRunning = surveysRunning;
            return this;
        }

        public Builder translations(
                Map<Language, SurveyTranslation> translations) {
            this.translations = translations;
            return this;
        }

        public Builder questionGroups(List<QuestionGroup> questionGroups) {
            this.questionGroups = questionGroups;
            return this;
        }

        public Builder questions(Set<Question> questions) {
            this.questions = questions;
            return this;
        }

        public Survey build() {
            Survey survey = new Survey();
            survey.setId(id);
            survey.status = status;
            survey.languageSettings = languageSettings;
            survey.language = language;
            survey.surveysRunning = surveysRunning;
            survey.translations = translations;
            survey.questionGroups = questionGroups;
            return survey;
        }
    }
}
