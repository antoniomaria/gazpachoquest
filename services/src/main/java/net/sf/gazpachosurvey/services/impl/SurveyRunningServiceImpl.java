package net.sf.gazpachosurvey.services.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;
import net.sf.gazpachosurvey.services.SurveyRunningService;
import net.sf.gazpachosurvey.services.SurveyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyRunningServiceImpl extends
        AbstractPersistenceService<SurveyRunning, SurveyRunningDTO, Integer> implements SurveyRunningService{

    @Autowired
    private SurveyRepository surveyRepository;
    
    @Autowired
    private ParticipantRepository participantRepository;
    
    @Autowired
    public SurveyRunningServiceImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }
    
    public Integer addSurveyRunning(Integer surveyId, Set<ParticipantDTO> participants){
        
        Survey survey = surveyRepository.findOne(surveyId);
        SurveyRunning running = new SurveyRunning();
        running.setName("mi run");
        running.setSurvey(survey);
        running = repository.save(running);
        
        
        for (ParticipantDTO participantDTO : participants) {
            Participant participant = null;
            if (participantDTO.isNew()){
                participant = mapper.map(participantDTO, Participant.class);
                participant = participantRepository.save(participant);     
            }else{
                participant = participantRepository.findOne(participantDTO.getId());
            }
            running.addParticipant(participant);
        }
        
        
        return running.getId();
    }

}
