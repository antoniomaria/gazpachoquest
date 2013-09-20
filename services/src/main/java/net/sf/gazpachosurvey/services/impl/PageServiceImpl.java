package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.services.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PageServiceImpl extends AbstractPersistenceService<Page, PageDTO, Integer> implements PageService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    public PageServiceImpl(PageRepository repository) {
        super(repository, Page.class, PageDTO.class);
    }

    @Override
    public PageDTO addPage(Integer surveyId, PageDTO page) {
        Page entity = mapper.map(page, Page.class);

        Survey survey = surveyRepository.findOne(surveyId);
        Assert.notNull(survey, "Survey " + surveyId + " not exist");
        entity.setSurvey(survey);
        entity.setLanguage(survey.getLanguage());

        survey.addPage(entity);
        surveyRepository.save(survey);

        int numberOfPages = survey.getPages().size();
        return mapper.map(survey.getPages().get(numberOfPages - 1), PageDTO.class);
    }

}
