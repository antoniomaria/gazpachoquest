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

import javax.annotation.Resource;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.i18.QuestionTranslationRepository;
import net.sf.gazpachoquest.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionServiceImpl extends
        AbstractLocalizedPersistenceService<Question, QuestionTranslation, QuestionLanguageSettings> implements
        QuestionService {

    @Resource
    private QuestionGroupRepository questionGroupRepository;

    @Resource
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Autowired
    public QuestionServiceImpl(final QuestionRepository repository,
            final QuestionTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionTranslation.Builder());
    }

    @Override
    @Transactional(readOnly = true)
    public Question findOneByPositionInQuestionGroup(final Integer questionGroupId, final Integer position) {
        return ((QuestionRepository) repository).findOneByPositionInQuestionGroup(questionGroupId, position);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findPositionInQuestionGroup(final Integer questionId) {
        return ((QuestionRepository) repository).findPositionInQuestionGroup(questionId);
    }

    @Override
    public List<Question> findByQuestionGroupId(Integer questionGroupId) {
        return ((QuestionRepository) repository).findByQuestionGroupId(questionGroupId);
    }

    @Override
    @Transactional(readOnly = false)
    public Question save(final Question question) {
        Assert.state(!question.isNew(),
                "Question must be already persisted. Try by adding to QuestionGroup or as added as subquestion first.");
        Question existing = repository.save(question);
        for (Question subquestion : question.getSubquestions()) {
            if (!subquestion.isNew()) { // Skip created subquestions
                continue;
            }
            existing.addSubquestion(subquestion);
        }

        for (QuestionOption questionOption : question.getQuestionOptions()) {
            if (!questionOption.isNew()) { // Skip created questionOptions
                continue;
            }
            existing.addQuestionOption(questionOption);
        }
        return existing;
    }

}
