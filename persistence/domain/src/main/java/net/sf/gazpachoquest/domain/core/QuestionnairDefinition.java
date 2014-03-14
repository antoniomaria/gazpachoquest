package net.sf.gazpachoquest.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

@Entity
public class QuestionnairDefinition extends
        AbstractLocalizable<QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings> {

    private static final long serialVersionUID = 2560468772707058412L;

    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Embedded
    private QuestionnairDefinitionLanguageSettings languageSettings;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @OneToMany(mappedBy = "questionnairDefinition", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Questionnair> questionnairs;

    @OneToMany(mappedBy = "questionnairDefinition", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "language", insertable = false, updatable = false)
    private Map<Language, QuestionnairDefinitionTranslation> translations;

    @OneToMany(mappedBy = "questionnairDefinition", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderColumn(name = "order_in_questionnair")
    private List<QuestionGroup> questionGroups;

    @OneToMany(mappedBy = "questionnairDefinition", fetch = FetchType.LAZY)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "type", insertable = false, updatable = false)
    private Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates;

    public QuestionnairDefinition() {
        super();
    }

    @Override
    public Map<Language, QuestionnairDefinitionTranslation> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
        }
        return translations;
    }

    public void setTranslations(Map<Language, QuestionnairDefinitionTranslation> translations) {
        this.translations = translations;
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
        getQuestionGroups().add(questionGroup);
        questionGroup.setSurvey(this);
    }

    @Override
    public QuestionnairDefinitionLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
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
        if (mailTemplates == null) {
            mailTemplates = new HashMap<>();
        }
        return mailTemplates;
    }

    public void setMailTemplates(Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates) {
        this.mailTemplates = mailTemplates;
    }

    public void addTranslation(Language language, QuestionnairDefinitionTranslation translation) {
        translation.setSurvey(this);
        getTranslations().put(language, translation);
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private EntityStatus status;
        private QuestionnairDefinitionLanguageSettings languageSettings;
        private Language language;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder status(EntityStatus status) {
            this.status = status;
            return this;
        }

        public Builder languageSettings(QuestionnairDefinitionLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public QuestionnairDefinition build() {
            QuestionnairDefinition questionnairDefinition = new QuestionnairDefinition();
            questionnairDefinition.setId(id);
            questionnairDefinition.status = status;
            questionnairDefinition.languageSettings = languageSettings;
            questionnairDefinition.language = language;
            return questionnairDefinition;
        }
    }
}
