package net.sf.gazpachosurvey.facades.impl;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.StudyDTO;
import net.sf.gazpachosurvey.facades.StudyFacade;
import net.sf.gazpachosurvey.services.StudyService;

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
        Set<Participant> participants = new HashSet<Participant>();
        for (ParticipantDTO participantDTO : study.getParticipants()) {
            Participant participant = mapper.map(participantDTO, Participant.class);
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
