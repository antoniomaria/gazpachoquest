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
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.permission.QuestionnaireDefinitionPermission;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.repository.i18.QuestionnaireDefinitionTranslationRepository;
import net.sf.gazpachoquest.repository.permission.QuestionnaireDefinitionPermissionRepository;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Perm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionnaireDefinitionServiceImpl
        extends
        AbstractLocalizedPersistenceService<QuestionnaireDefinition, QuestionnaireDefinitionTranslation, QuestionnaireDefinitionLanguageSettings>
        implements QuestionnaireDefinitionService {

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    private QuestionnaireDefinitionTranslationRepository questionnaireDefinitionTranslationRepository;

    @Autowired
    private QuestionnaireDefinitionPermissionRepository questionnaireDefinitionPermissionRepository;
    
    @Autowired
    public QuestionnaireDefinitionServiceImpl(final QuestionnaireDefinitionRepository questionnaireDefinitionRepository,
            final QuestionnaireDefinitionTranslationRepository translationRepository) {
        super(questionnaireDefinitionRepository, translationRepository, new QuestionnaireDefinitionTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnaireDefinition confirm(final QuestionnaireDefinition questionnaireDefinition) {
        QuestionnaireDefinition entity = repository.findOne(questionnaireDefinition.getId());
        if (entity.getStatus() == EntityStatus.DRAFT) {
            questionnaireAnswersRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return questionnaireDefinition;
    }

    @Override
    @Transactional(readOnly = true)
    public int questionGroupsCount(final Integer questionnairDefinitionId) {
        return (int) questionGroupRepository.countByExample(
                QuestionGroup.with()
                        .questionnaireDefinition(QuestionnaireDefinition.with().id(questionnairDefinitionId).build())
                        .build(), new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnaireDefinition save(final QuestionnaireDefinition questionnaireDefinition) {
        QuestionnaireDefinition existing = null;
        if (questionnaireDefinition.isNew()) {
            questionnaireDefinition.setStatus(EntityStatus.DRAFT);
            existing = repository.save(questionnaireDefinition);
            
            QuestionnaireDefinitionPermission permission = QuestionnaireDefinitionPermission.with().addPerm(Perm.READ).addPerm(Perm.UPDATE).addPerm(Perm.UPDATE).target(existing).user(getAuthenticatedUser()).build();
            questionnaireDefinitionPermissionRepository.save(permission);
        } else {
            existing = repository.findOne(questionnaireDefinition.getId());
            existing.setLanguage(questionnaireDefinition.getLanguage());
            existing.setRandomizationStrategy(questionnaireDefinition.getRandomizationStrategy());
            existing.setLanguageSettings(questionnaireDefinition.getLanguageSettings());
            for (QuestionGroup questionGroup : questionnaireDefinition.getQuestionGroups()) {
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
        return ((QuestionnaireDefinitionRepository) repository).questionsCount(questionnairDefinitionId);
    }

    @Override
    public List<Object[]> questionsCountGroupByQuestionGroups(final Integer questionnairDefinitionId) {
        return ((QuestionnaireDefinitionRepository) repository)
                .questionsCountGroupByQuestionGroups(questionnairDefinitionId);
    }

    @Override
    public List<Question> getQuestions(final Integer questionnairDefinitionId) {
        return ((QuestionnaireDefinitionRepository) repository).getQuestions(questionnairDefinitionId);
    }

    @Override
    public void exportQuestionnairDefinition(Integer questionnairDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException {
        QuestionnaireDefinition questionnaireDefinition = repository.findOne(questionnairDefinitionId);
        marshaller.marshal(questionnaireDefinition, new StreamResult(outputStream));
    }

    @Override
    public QuestionnaireDefinition importQuestionnairDefinition(InputStream inputStream) throws XmlMappingException,
            IOException {
        QuestionnaireDefinition questionnaireDefinition = (QuestionnaireDefinition) unmarshaller
                .unmarshal(new StreamSource(inputStream));
        questionnaireDefinition.setStatus(EntityStatus.CONFIRMED);
        questionnaireDefinition.updateInverseRelationships();
        return repository.save(questionnaireDefinition);
    }

}
