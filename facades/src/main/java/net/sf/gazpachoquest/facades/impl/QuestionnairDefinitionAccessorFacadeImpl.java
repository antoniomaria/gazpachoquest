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
package net.sf.gazpachoquest.facades.impl;

import java.util.Set;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionAccessorFacade;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.types.Language;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairDefinitionAccessorFacadeImpl implements QuestionnairDefinitionAccessorFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private QuestionService questionService;

    @Override
    public QuestionnairDefinitionDTO findOneQuestionnairDefinition(final Integer questionnairDefinitionId) {
        QuestionnairDefinition questionnairDefinition = questionnairDefinitionService.findOne(questionnairDefinitionId);
        return mapper.map(questionnairDefinition, QuestionnairDefinitionDTO.class);
    }

    @Override
    public QuestionDTO findOneQuestion(final Integer questionId) {
        Question question = questionService.findOne(questionId);
        return mapper.map(question, QuestionDTO.class);
    }

    @Override
    public Set<Language> findQuestionnairDefinitionTranslations(final Integer questionnairDefinitionId) {
        return questionnairDefinitionService.translationsSupported(questionnairDefinitionId);
    }

}
