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
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.repository.i18.QuestionGroupTranslationRepository;
import net.sf.gazpachoquest.services.QuestionGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionGroupServiceImpl extends
        AbstractLocalizedPersistenceService<QuestionGroup, QuestionGroupTranslation, QuestionGroupLanguageSettings>
        implements QuestionGroupService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnaireDefinitionRepository questionnaireDefinitionRepository;

    @Autowired
    public QuestionGroupServiceImpl(final QuestionGroupRepository repository,
            final QuestionGroupTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionGroupTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionGroup> findByQuestionnairDefinitionId(final Integer surveyId) {
        return ((QuestionGroupRepository) repository).findByQuestionnairDefinitionId(surveyId);
    }

    @Override
    @Transactional(readOnly = true)
    public QuestionGroup findOneByPositionInQuestionnairDefinition(final Integer surveyId, final Integer position) {
        return ((QuestionGroupRepository) repository).findOneByPositionInQuestionnairDefinition(surveyId, position);
    }

    @Override
    @Transactional(readOnly = true)
    public int positionInQuestionnairDefinition(final Integer questionGroupId) {
        return ((QuestionGroupRepository) repository).positionInQuestionnairDefinition(questionGroupId);
    }

    @Override
    @Transactional(readOnly = true)
    public long questionsCount(final Integer questionGroupId) {
        return questionRepository.countByExample(
                Question.with().questionGroup(QuestionGroup.with().id(questionGroupId).build()).build(),
                new SearchParameters());
    }

    @Override
    @Transactional(readOnly = false)
    public QuestionGroup save(final QuestionGroup questionGroup) {
        Assert.state(!questionGroup.isNew(),
                "QuestionGroup must be already persisted. Try by adding to QuestionnaireDefinition first.");

        QuestionGroup existing = repository.findOne(questionGroup.getId());
        existing.setLanguageSettings(questionGroup.getLanguageSettings());
        existing.setRandomizationEnabled(questionGroup.isRandomizationEnabled());

        for (Question question : questionGroup.getQuestions()) {
            if (!question.isNew()) {
                continue;
            }
            if (question.getLanguage() == null) {
                question.setLanguage(questionGroup.getLanguage());
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
