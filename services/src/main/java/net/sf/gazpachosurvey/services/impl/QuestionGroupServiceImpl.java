package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachosurvey.repository.PageRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.i18.PageTranslationRepository;
import net.sf.gazpachosurvey.services.QuestionGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class QuestionGroupServiceImpl extends AbstractLocalizedPersistenceService<QuestionGroup, QuestionGroupDTO, QuestionGroupTranslation, QuestionGroupLanguageSettings, QuestionGroupLanguageSettingsDTO> implements QuestionGroupService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    public QuestionGroupServiceImpl(PageRepository repository, PageTranslationRepository translationRepository) {
        super(repository, translationRepository, QuestionGroup.class, QuestionGroupDTO.class,QuestionGroupTranslation.class, QuestionGroupLanguageSettings.class, QuestionGroupLanguageSettingsDTO.class, new QuestionGroupTranslation.Builder() );
    }

    @Override
    public QuestionGroupDTO addQuestionGroup(Integer surveyId, QuestionGroupDTO page) {
        QuestionGroup entity = mapper.map(page, QuestionGroup.class);

        Survey survey = surveyRepository.findOne(surveyId);
        Assert.notNull(survey, "Survey " + surveyId + " not exist");
        entity.setSurvey(survey);
        entity.setLanguage(survey.getLanguage());

        survey.addQuestionGroup(entity);
        surveyRepository.save(survey);

        int numberOfPages = survey.getQuestionGroups().size();
        return mapper.map(survey.getQuestionGroups().get(numberOfPages - 1), QuestionGroupDTO.class);
    }

}
