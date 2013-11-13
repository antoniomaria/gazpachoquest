package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.PageLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.PageTranslation;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.PageLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.PageTranslationRepository;
import net.sf.gazpachosurvey.services.PageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PageServiceImpl extends AbstractLocalizedPersistenceService<Page, PageDTO, PageTranslation, PageLanguageSettings, PageLanguageSettingsDTO> implements PageService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    public PageServiceImpl(PageRepository repository, PageTranslationRepository translationRepository) {
        super(repository, translationRepository, Page.class, PageDTO.class,PageTranslation.class, PageLanguageSettings.class, PageLanguageSettingsDTO.class, new PageTranslation.Builder() );
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
