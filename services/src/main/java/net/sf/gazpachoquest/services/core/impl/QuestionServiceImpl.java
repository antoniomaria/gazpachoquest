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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.repository.QuestionGroupRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.repository.i18.QuestionTranslationRepository;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.types.Language;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.CopyGroup;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public QuestionServiceImpl(final QuestionRepository repository,
            final QuestionTranslationRepository translationRepository) {
        super(repository, translationRepository, new QuestionTranslation.Builder());
    }

    @Override
    @Transactional
    public Question findOneByPositionInQuestionGroup(final Integer questionGroupId, final Integer position) {
        return ((QuestionRepository) repository).findOneByPositionInQuestionGroup(questionGroupId, position);
    }

    @Override
    @Transactional
    public Integer findPositionInQuestionGroup(final Integer questionId) {
        return ((QuestionRepository) repository).findPositionInQuestionGroup(questionId);
    }

    @Override
    @Transactional
    public List<Question> findByQuestionGroupId(Integer questionGroupId) {
        return ((QuestionRepository) repository).findByQuestionGroupId(questionGroupId);
    }

    @Override
    public List<Question> findInList(List<Integer> questionIds) {
        return ((QuestionRepository) repository).findInList(questionIds);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Question> findInList(List<Integer> questionIds, Language language) {
        List<Question> questions = ((QuestionRepository) repository).findInList(questionIds);
        if (questionIds.isEmpty()) {
            return questions;
        }

        Question sampleQuestion = questions.iterator().next();
        // It's assumed that all the question are in the same language
        boolean isPreferredLanguage = language == null || sampleQuestion.getLanguage().equals(language);

        CopyGroup group = new CopyGroup();

        group.addAttribute("questionOptions");
        group.addAttribute("languageSettings");
        group.addAttribute("language");
        group.addAttribute("type");
        group.addAttribute("code");

        group.addAttribute("subquestions.subquestions");
        group.addAttribute("subquestions.questionOptions");
        group.addAttribute("subquestions.language");
        group.addAttribute("subquestions.type");
        group.addAttribute("subquestions.code");
        group.addAttribute("subquestions.languageSettings");

        group.addAttribute("questionOptions.languageSettings");
        group.addAttribute("questionOptions.language");
        group.addAttribute("questionOptions.code");
        // Only load translations is question language is different from
        // preferred
        // language
        if (!isPreferredLanguage) {
            group.addAttribute("translations");
            group.addAttribute("subquestions.translations");
            group.addAttribute("questionOptions.translations");
        }

        List<Question> detatchedQuestions = new ArrayList<>();
        for (Question question : questions) {
            Question detatchedQuestion = (Question) entityManager.unwrap(JpaEntityManager.class).copy(question, group);
            if (!isPreferredLanguage) {
                detatchedQuestion.translateTo(language);
            }
            detatchedQuestions.add(detatchedQuestion);
        }
        return detatchedQuestions;
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
