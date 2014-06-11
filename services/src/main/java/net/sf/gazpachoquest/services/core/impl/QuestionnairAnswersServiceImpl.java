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

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionnairAnswersServiceImpl implements QuestionnairAnswersService {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    private QuestionnairAnswersRepository repository;

    public QuestionnairAnswersServiceImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Questionnair questionnair, String questionCode, Object answer) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        Assert.state(!fetched.isDraft(), "Confirm the questionnair before saving answers");

        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        QuestionnairAnswers questionnairAnswers = repository
                .findByOne(questionnairDefinitionId, fetched.getAnswersId());
        questionnairAnswers.setAnswer(questionCode, answer);
        questionnairAnswers = repository.save(questionnairDefinitionId, questionnairAnswers);
    }

    @Override
    @Transactional
    public Object findByQuestionCode(Questionnair questionnair, String questionCode) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnairAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswer(questionCode);
    }

    @Transactional
    @Override
    public Map<String, Object> findByQuestionnair(Questionnair questionnair) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnairAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswers();
    }

}
