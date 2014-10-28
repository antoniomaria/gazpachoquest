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
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.Section_;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.permission.QuestionnaireDefinitionPermission;
import net.sf.gazpachoquest.qbe.support.PropertySelector;
import net.sf.gazpachoquest.qbe.support.SearchMode;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.MailMessageRepository;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.repository.SectionRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.repository.i18.QuestionnaireDefinitionTranslationRepository;
import net.sf.gazpachoquest.repository.permission.QuestionnaireDefinitionPermissionRepository;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Perm;
import net.sf.gazpachoquest.types.Topology;

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
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionnaireAnswersRepository questionnaireAnswersRepository;

    @Autowired
    private QuestionnaireDefinitionTranslationRepository questionnaireDefinitionTranslationRepository;

    @Autowired
    private QuestionnaireDefinitionPermissionRepository questionnaireDefinitionPermissionRepository;

    @Autowired
    public QuestionnaireDefinitionServiceImpl(
            final QuestionnaireDefinitionRepository questionnaireDefinitionRepository,
            final QuestionnaireDefinitionTranslationRepository translationRepository) {
        super(questionnaireDefinitionRepository, translationRepository,
                new QuestionnaireDefinitionTranslation.Builder());
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
    public int sectionsCount(final Integer questionnaireDefinitionId) {
        return (int) sectionRepository.countByExample(
                Section.with()
                        .questionnaireDefinition(QuestionnaireDefinition.with().id(questionnaireDefinitionId).build())
                        .build(), new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionnaireDefinition save(final QuestionnaireDefinition questionnaireDefinition) {
        QuestionnaireDefinition existing = null;
        if (questionnaireDefinition.isNew()) {
            questionnaireDefinition.setStatus(EntityStatus.DRAFT);
            existing = repository.save(questionnaireDefinition);

            QuestionnaireDefinitionPermission permission = QuestionnaireDefinitionPermission.with().addPerm(Perm.READ)
                    .addPerm(Perm.UPDATE).addPerm(Perm.UPDATE).target(existing).user(getAuthenticatedUser()).build();
            questionnaireDefinitionPermissionRepository.save(permission);
        } else {
            existing = repository.findOne(questionnaireDefinition.getId());
            existing.setLanguage(questionnaireDefinition.getLanguage());
            existing.setQuestionsPerPage(questionnaireDefinition.getQuestionsPerPage());
            existing.setRandomizationStrategy(questionnaireDefinition.getRandomizationStrategy());
            existing.setLanguageSettings(questionnaireDefinition.getLanguageSettings());
            existing.setProgressVisible(questionnaireDefinition.isProgressVisible());
            existing.setRenderingMode(questionnaireDefinition.getRenderingMode());
            existing.setSectionInfoVisible(questionnaireDefinition.isSectionInfoVisible());

            for (Section section : questionnaireDefinition.getSections()) {
                if (!section.isNew()) {
                    continue;
                }
                existing.addSection(section);
            }
        }
        return existing;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer questionsCount(final Integer questionnaireDefinitionId) {
        return ((QuestionnaireDefinitionRepository) repository).questionsCount(questionnaireDefinitionId);
    }

    @Override
    public List<Object[]> questionsCountGroupBySections(final Integer questionnaireDefinitionId) {
        return ((QuestionnaireDefinitionRepository) repository)
                .questionsCountGroupBySections(questionnaireDefinitionId);
    }

    @Override
    public List<Question> getQuestions(final Integer questionnaireDefinitionId) {
        return ((QuestionnaireDefinitionRepository) repository).getQuestions(questionnaireDefinitionId);
    }

    @Override
    public void exportQuestionnaireDefinition(Integer questionnaireDefinitionId, OutputStream outputStream)
            throws XmlMappingException, IOException {
        QuestionnaireDefinition questionnaireDefinition = repository.findOne(questionnaireDefinitionId);
        marshaller.marshal(questionnaireDefinition, new StreamResult(outputStream));
    }

    @Override
    public QuestionnaireDefinition importQuestionnaireDefinition(InputStream inputStream) throws XmlMappingException,
            IOException {
        QuestionnaireDefinition questionnaireDefinition = (QuestionnaireDefinition) unmarshaller
                .unmarshal(new StreamSource(inputStream));
        questionnaireDefinition.setStatus(EntityStatus.CONFIRMED);
        questionnaireDefinition.updateInverseRelationships();
        return repository.save(questionnaireDefinition);
    }

    @Override
    public Topology getTopology(Integer questionnaireDefinitionId) {
        Section entity = Section.with()
                .questionnaireDefinition(QuestionnaireDefinition.with().id(questionnaireDefinitionId).build()).build();
        PropertySelector<Section, String> propertySelector = PropertySelector.newPropertySelector(Section_.relevance);
        propertySelector.setSelected("");
        propertySelector.setSearchMode(SearchMode.NOT_EQUALS);
        SearchParameters sp = new SearchParameters();
        sp.addProperty(propertySelector);
        sp.setCaseSensitive(true);
        long count = sectionRepository.countByExample(entity, sp);
        if (count > 0){
            return Topology.SKIP_PATTERN;
        }
        return Topology.LINEAR;
    }

}
