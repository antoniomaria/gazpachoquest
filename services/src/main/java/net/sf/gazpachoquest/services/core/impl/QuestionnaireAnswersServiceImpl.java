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

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireAnswers;
import net.sf.gazpachoquest.repository.QuestionnaireRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnaireAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionnaireAnswersServiceImpl implements QuestionnaireAnswersService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionnaireAnswersRepository repository;

    public QuestionnaireAnswersServiceImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Questionnaire questionnaire, String questionCode, Object answer) {
        Assert.state(!questionnaire.isNew(), "Persist the questionnaire before saving answers");
        Questionnaire fetched = questionnaireRepository.findOne(questionnaire.getId());
        Assert.state(!fetched.isDraft(), "Confirm the questionnaire before saving answers");

        Integer questionnairDefinitionId = fetched.getQuestionnaireDefinition().getId();
        QuestionnaireAnswers questionnaireAnswers = repository
                .findByOne(questionnairDefinitionId, fetched.getAnswersId());
        questionnaireAnswers.setAnswer(questionCode, answer);
        questionnaireAnswers = repository.save(questionnairDefinitionId, questionnaireAnswers);
    }

    @Override
    @Transactional
    public Object findByQuestionCode(Questionnaire questionnaire, String questionCode) {
        Assert.state(!questionnaire.isNew(), "Persist the questionnaire before saving answers");
        Questionnaire fetched = questionnaireRepository.findOne(questionnaire.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnaireDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnaireAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswer(questionCode);
    }

    @Transactional
    @Override
    public Map<String, Object> findByQuestionnaire(Questionnaire questionnaire) {
        Assert.state(!questionnaire.isNew(), "Persist the questionnaire before saving answers");
        Questionnaire fetched = questionnaireRepository.findOne(questionnaire.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnaireDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnaireAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswers();
    }

}
