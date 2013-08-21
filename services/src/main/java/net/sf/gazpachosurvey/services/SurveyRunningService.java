package net.sf.gazpachosurvey.services;

import java.util.Set;

import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;

public interface SurveyRunningService extends PersistenceService<SurveyRunningDTO, Integer>{

    public Integer addSurveyRunning(Integer surveyId, Set<ParticipantDTO> participants);
        
}
