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

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.StudyDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.facades.StudyFacade;
import net.sf.gazpachoquest.services.StudyService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudyFacadeImpl implements StudyFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private StudyService studyService;

    @Override
    public void delete(final Integer id) {
        studyService.delete(id);
    }

    @Override
    public StudyDTO findOne(final Integer id) {
        Study entity = studyService.findOne(id);
        return mapper.map(entity, StudyDTO.class);
    }

    @Override
    public StudyDTO save(final StudyDTO study) {
        Study entity = mapper.map(study, Study.class);
        Set<User> participants = new HashSet<User>();
        for (UserDTO participantDTO : study.getParticipants()) {
            User participant = mapper.map(participantDTO, User.class);
            participants.add(participant);
        }

        Set<QuestionnairDefinition> questionnairDefinitions = new HashSet<QuestionnairDefinition>();
        for (QuestionnairDefinitionDTO questionnairDefinitionDTO : study.getQuestionnairDefinitions()) {
            QuestionnairDefinition participant = mapper.map(questionnairDefinitionDTO, QuestionnairDefinition.class);
            questionnairDefinitions.add(participant);
        }
        entity = studyService.save(entity, questionnairDefinitions, participants);
        return mapper.map(entity, StudyDTO.class);
    }
}
