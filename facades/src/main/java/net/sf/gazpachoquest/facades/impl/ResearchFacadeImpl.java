/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades.impl;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.facades.ResearchFacade;
import net.sf.gazpachoquest.services.ResearchService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResearchFacadeImpl implements ResearchFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    @Qualifier("researchServiceImpl")
    private ResearchService researchService;

    @Override
    public void delete(final Integer id) {
        researchService.delete(id);
    }

    @Override
    public ResearchDTO findOne(final Integer id) {
        Research entity = researchService.findOne(id);
        return mapper.map(entity, ResearchDTO.class);
    }

    @Override
    public ResearchDTO save(final ResearchDTO research) {
        Research entity = mapper.map(research, Research.class);
        Set<User> respondents = new HashSet<User>();
        for (UserDTO respondentDTO : research.getRespondents()) {
            User respondent = mapper.map(respondentDTO, User.class);
            respondents.add(respondent);
        }

        Set<QuestionnaireDefinition> questionnaireDefinitions = new HashSet<QuestionnaireDefinition>();
        for (QuestionnaireDefinitionDTO questionnaireDefinitionDTO : research.getQuestionnaireDefinitions()) {
            QuestionnaireDefinition questionnaireDefinition = mapper.map(questionnaireDefinitionDTO,
                    QuestionnaireDefinition.class);
            questionnaireDefinitions.add(questionnaireDefinition);
        }
        entity = researchService.save(entity, questionnaireDefinitions, respondents);
        return mapper.map(entity, ResearchDTO.class);
    }
}
