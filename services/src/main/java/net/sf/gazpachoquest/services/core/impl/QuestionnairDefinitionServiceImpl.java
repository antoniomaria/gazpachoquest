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
package net.sf.gazpachoquest.services.core.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.gazpachoquest.domain.core.MailMessageTemplate;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.MailMessageTemplateTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.repository.i18.QuestionnairDefinitionTranslationRepository;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnairDefinitionServiceImpl
        extends
        AbstractLocalizedPersistenceService<QuestionnairDefinition, QuestionnairDefinitionTranslation, QuestionnairDefinitionLanguageSettings>
        implements QuestionnairDefinitionService {

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private QuestionnairAnswersRepository questionnairAnswersRepository;

    @Autowired
    private QuestionnairDefinitionTranslationRepository questionnairDefinitionTranslationRepository;

    @Autowired
    public QuestionnairDefinitionServiceImpl(final QuestionnairDefinitionRepository questionnairDefinitionRepository,
            final QuestionnairDefinitionTranslationRepository translationRepository) {
        super(questionnairDefinitionRepository, translationRepository, new QuestionnairDefinitionTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnairDefinition confirm(final QuestionnairDefinition questionnairDefinition) {
        QuestionnairDefinition entity = repository.findOne(questionnairDefinition.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            questionnairAnswersRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return questionnairDefinition;
    }

    @Override
    @Transactional(readOnly = true)
    public int questionGroupsCount(final Integer questionnairDefinitionId) {
        return (int) questionGroupRepository.countByExample(
                QuestionGroup.with()
                        .questionnairDefinition(QuestionnairDefinition.with().id(questionnairDefinitionId).build())
                        .build(), new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnairDefinition save(final QuestionnairDefinition questionnairDefinition) {
        QuestionnairDefinition existing = null;
        if (questionnairDefinition.isNew()) {
            questionnairDefinition.setStatus(EntityStatus.DRAFT);
            existing = repository.save(questionnairDefinition);
        } else {
            existing = repository.findOne(questionnairDefinition.getId());
            existing.setLanguage(questionnairDefinition.getLanguage());
            existing.setLanguageSettings(questionnairDefinition.getLanguageSettings());
            for (QuestionGroup questionGroup : questionnairDefinition.getQuestionGroups()) {
                if (!questionGroup.isNew()) {
                    continue;
                }
                existing.addQuestionGroup(questionGroup);
            }
        }
        return existing;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer questionsCount(final Integer questionnairDefinitionId) {
        return ((QuestionnairDefinitionRepository) repository).questionsCount(questionnairDefinitionId);
    }

    @Override
    public List<Object[]> questionsCountGroupByQuestionGroups(final Integer questionnairDefinitionId) {
        return ((QuestionnairDefinitionRepository) repository)
                .questionsCountGroupByQuestionGroups(questionnairDefinitionId);
    }

    @Override
    public List<Question> getQuestions(final Integer questionnairDefinitionId) {
        return ((QuestionnairDefinitionRepository) repository).getQuestions(questionnairDefinitionId);
    }

    @Override
    public void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException {
        QuestionnairDefinition questionnairDefinition = repository.findOne(questionnairDefinitionId);
        marshaller.marshal(questionnairDefinition, new StreamResult(outputStream));
    }

    @Override
    public QuestionnairDefinition importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException,
            IOException {
        QuestionnairDefinition questionnairDefinition = (QuestionnairDefinition) unmarshaller
                .unmarshal(new StreamSource(inputStream));
        questionnairDefinition.setStatus(EntityStatus.CONFIRMED);
        questionnairDefinition.updateInverseRelationships();
        return repository.save(questionnairDefinition);
    }

    private void defineInverseRelationship(QuestionnairDefinition questionnairDefinition) {
        Map<Language, QuestionnairDefinitionTranslation> questionnairDefinitionTranslations = questionnairDefinition
                .getTranslations();
        for (Entry<Language, QuestionnairDefinitionTranslation> entry : questionnairDefinitionTranslations.entrySet()) {
            QuestionnairDefinitionTranslation translation = entry.getValue();
            translation.setQuestionnairDefinition(questionnairDefinition);
            translation.setLanguage(entry.getKey());
        }

        Map<MailMessageTemplateType, MailMessageTemplate> mailTemplates = questionnairDefinition.getMailTemplates();
        for (Entry<MailMessageTemplateType, MailMessageTemplate> entry : mailTemplates.entrySet()) {
            MailMessageTemplate mailMessageTemplate = entry.getValue();
            mailMessageTemplate.setQuestionnairDefinition(questionnairDefinition);

            for (Entry<Language, MailMessageTemplateTranslation> translationEntry : mailMessageTemplate
                    .getTranslations().entrySet()) {
                MailMessageTemplateTranslation mailMessageTemplateTranslation = translationEntry.getValue();
                mailMessageTemplateTranslation.setMailMessageTemplate(mailMessageTemplate);
                mailMessageTemplateTranslation.setLanguage(translationEntry.getKey());
            }
        }
        List<QuestionGroup> questionGroups = questionnairDefinition.getQuestionGroups();
        for (QuestionGroup questionGroup : questionGroups) {
            questionGroup.setQuestionnairDefinition(questionnairDefinition);

            for (Entry<Language, QuestionGroupTranslation> questionGroupTranslationEntry : questionGroup
                    .getTranslations().entrySet()) {
                QuestionGroupTranslation questionGroupTranslation = questionGroupTranslationEntry.getValue();
                questionGroupTranslation.setQuestionGroup(questionGroup);
                questionGroupTranslation.setLanguage(questionGroupTranslationEntry.getKey());
            }

            List<Question> questions = questionGroup.getQuestions();
            for (Question question : questions) {
                question.setQuestionGroup(questionGroup);

                for (Entry<Language, QuestionTranslation> entry : question.getTranslations().entrySet()) {
                    QuestionTranslation questionTranslation = entry.getValue();
                    questionTranslation.setQuestion(question);
                    questionTranslation.setLanguage(entry.getKey());
                }

                List<Question> subquestions = question.getSubquestions();
                for (Question subquestion : subquestions) {
                    subquestion.setParent(question);

                    for (Entry<Language, QuestionTranslation> entry : subquestion.getTranslations().entrySet()) {
                        QuestionTranslation questionTranslation = entry.getValue();
                        questionTranslation.setQuestion(subquestion);
                        questionTranslation.setLanguage(entry.getKey());
                    }
                }

                List<QuestionOption> questionOptions = question.getQuestionOptions();
                for (QuestionOption questionOption : questionOptions) {
                    questionOption.setQuestion(question);

                    for (Entry<Language, QuestionOptionTranslation> entry : questionOption.getTranslations().entrySet()) {
                        QuestionOptionTranslation questionTranslation = entry.getValue();
                        questionTranslation.setQuestionOption(questionOption);
                        questionTranslation.setLanguage(entry.getKey());
                    }

                }
            }
        }
    }
}
