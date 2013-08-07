package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.support.GenericRepository;
import net.sf.gazpachosurvey.services.SurveyService;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
    
    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private Mapper mapper;

    public Integer addSurvey(SurveyDTO survey) {
        Survey entity = mapper.map(survey, Survey.class);
        Survey created = surveyRepository.save(entity);
        return created.getId();
    }
    
    public Integer addPage(Integer surveyId, PageDTO page){
        Page entity = mapper.map(page, Page.class);
        
        Survey survey = surveyRepository.findOne(surveyId);
        
        entity.setSurvey(survey);
        entity.setLanguage(survey.getLanguage());
        
        survey.addPage(entity);
        
        surveyRepository.save(survey);
        
        int numberOfPages = survey.getPages().size();
        Integer newPageId = survey.getPages().get(numberOfPages -1 ).getId();
       
        return newPageId;
    }

}
