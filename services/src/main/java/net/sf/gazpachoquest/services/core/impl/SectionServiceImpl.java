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

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.SectionTranslation;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.repository.SectionRepository;
import net.sf.gazpachoquest.repository.i18.SectionTranslationRepository;
import net.sf.gazpachoquest.services.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class SectionServiceImpl extends
        AbstractLocalizedPersistenceService<Section, SectionTranslation, SectionLanguageSettings> implements
        SectionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnaireDefinitionRepository questionnaireDefinitionRepository;

    @Autowired
    public SectionServiceImpl(final SectionRepository repository,
            final SectionTranslationRepository translationRepository) {
        super(repository, translationRepository, new SectionTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Section> findByQuestionnaireDefinitionId(final Integer surveyId) {
        return ((SectionRepository) repository).findByQuestionnairDefinitionId(surveyId);
    }

    @Override
    @Transactional(readOnly = true)
    public Section findOneByPositionInQuestionnaireDefinition(final Integer surveyId, final Integer position) {
        return ((SectionRepository) repository).findOneByPositionInQuestionnairDefinition(surveyId, position);
    }

    @Override
    @Transactional(readOnly = true)
    public int positionInQuestionnaireDefinition(final Integer sectionId) {
        return ((SectionRepository) repository).positionInQuestionnairDefinition(sectionId);
    }

    @Override
    @Transactional(readOnly = true)
    public long questionsCount(final Integer sectionId) {
        return questionRepository.countByExample(Question.with().section(Section.with().id(sectionId).build()).build(),
                new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public Section save(final Section section) {
        Assert.state(!section.isNew(),
                "Section must be already persisted. Try by adding to QuestionnaireDefinition first.");

        Section existing = repository.findOne(section.getId());
        existing.setLanguageSettings(section.getLanguageSettings());
        existing.setRandomizationEnabled(section.isRandomizationEnabled());

        for (Question question : section.getQuestions()) {
            if (!question.isNew()) {
                continue;
            }
            if (question.getLanguage() == null) {
                question.setLanguage(section.getLanguage());
            }
            for (Question subquestion : question.getSubquestions()) {
                if (subquestion.getLanguage() == null) {
                    subquestion.setLanguage(question.getLanguage());
                }
            }
            existing.addQuestion(question);
        }
        return existing;
    }
}
