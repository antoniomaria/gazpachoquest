package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.SurveyInstance;
import net.sf.gazpachosurvey.dto.SurveyInstanceDTO;
import net.sf.gazpachosurvey.facades.SurveyInstanceFacade;
import net.sf.gazpachosurvey.services.SurveyInstanceService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyInstanceFacadeImpl implements SurveyInstanceFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private SurveyInstanceService surveyInstanceService;

    @Override
    public void delete(final Integer id) {
        surveyInstanceService.delete(id);
    }

    @Override
    public SurveyInstanceDTO findOne(final Integer id) {
        SurveyInstance entity = surveyInstanceService.findOne(id);
        return mapper.map(entity, SurveyInstanceDTO.class);
    }

    @Override
    public SurveyInstanceDTO save(final SurveyInstanceDTO surveyInstance) {
        SurveyInstance entity = mapper.map(surveyInstance, SurveyInstance.class);
        entity = surveyInstanceService.save(entity);
        return mapper.map(entity, SurveyInstanceDTO.class);
    }

}
