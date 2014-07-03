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

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnairDefinitionTranslation;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.repository.i18.QuestionnairDefinitionTranslationRepository;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.RandomizationStrategy;

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
        defineDefaultValues(questionnairDefinition);
        return repository.save(questionnairDefinition);
    }

    private void defineDefaultValues(QuestionnairDefinition questionnairDefinition) {
        questionnairDefinition.setProgressVisible(Boolean.TRUE);
        questionnairDefinition.setWelcomeVisible(Boolean.TRUE);
        questionnairDefinition.setQuestionGroupInfoVisible(Boolean.TRUE);
        questionnairDefinition.setRandomizationStrategy(RandomizationStrategy.NONE);

        List<QuestionGroup> questionGroups = questionnairDefinition.getQuestionGroups();
        for (QuestionGroup questionGroup : questionGroups) {
            questionGroup.setRandomizationEnabled(Boolean.FALSE);

            List<Question> questions = questionGroup.getQuestions();
            for (Question question : questions) {
                question.setOtherAllowed(Boolean.FALSE);
                List<Question> subquestions = question.getSubquestions();
                for (Question subquestion : subquestions) {
                    subquestion.setOtherAllowed(Boolean.FALSE);
                }
            }
        }
    }
}
