package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.services.SurveyService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    protected Mapper mapper;

    public SurveyDTO save(SurveyDTO survey) {
        Survey entity = mapper.map(survey, Survey.class);
        entity = surveyService.save(entity);
        return mapper.map(entity, SurveyDTO.class);
    }

}
