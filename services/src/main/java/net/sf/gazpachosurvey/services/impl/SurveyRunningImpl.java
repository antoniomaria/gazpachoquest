package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.SurveyRunning;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.repository.SurveyRunningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyRunningImpl extends
        AbstractPersistenceService<SurveyRunning, SurveyRunningDTO, Integer> {

    @Autowired
    public SurveyRunningImpl(SurveyRunningRepository repository) {
        super(repository, SurveyRunning.class, SurveyRunningDTO.class);
    }
    
    public Integer addSurveyRunning(Integer surveyId){
        return null;
    }

}
