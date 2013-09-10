package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.dynamic.RespondentRepository;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl extends AbstractPersistenceService<Survey, SurveyDTO, Integer> implements SurveyService {

    @Autowired
    private PageRepository pageRepository;
    
    @Autowired
    private RespondentRepository respondentRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        super(surveyRepository, Survey.class, SurveyDTO.class);
    }
    
    @Override
    public SurveyDTO save(SurveyDTO survey) {
        Survey entity = mapper.map(survey, entityClazz);
        if (entity.isNew()){
            entity.setStatus(EntityStatus.DRAFT);
        }
        return mapper.map(repository.save(entity), SurveyDTO.class);
    }
    
    public SurveyDTO confirm(SurveyDTO survey) {
        Survey entity = repository.findOne(survey.getId());
        if (entity.getStatus() == EntityStatus.DRAFT){
            respondentRepository.collectAnswers(entity);
            entity.setStatus(EntityStatus.CONFIRMED);
        }
        return survey;
    }
    
}
