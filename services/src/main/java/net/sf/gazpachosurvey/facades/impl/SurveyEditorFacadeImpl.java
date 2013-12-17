package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.SurveyLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.LabelTranslation;
import net.sf.gazpachosurvey.domain.i18.QuestionGroupTranslation;
import net.sf.gazpachosurvey.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.domain.i18.SurveyTranslation;
import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.facades.SurveyEditorFacade;
import net.sf.gazpachosurvey.services.LabelService;
import net.sf.gazpachosurvey.services.LabelSetService;
import net.sf.gazpachosurvey.services.QuestionGroupService;
import net.sf.gazpachosurvey.services.QuestionOptionService;
import net.sf.gazpachosurvey.services.QuestionService;
import net.sf.gazpachosurvey.services.SurveyService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class SurveyEditorFacadeImpl implements SurveyEditorFacade {

    @Autowired
    private Mapper mapper;

    @Autowired
    private LabelSetService labelSetService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionOptionService questionOptionService;

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private QuestionGroupService questionGroupService;

    public SurveyEditorFacadeImpl() {
        super();
    }

    @Override
    public LabelSetDTO save(LabelSetDTO labelSet) {
        LabelSet entity = mapper.map(labelSet, LabelSet.class);
        entity = labelSetService.save(entity);
        return mapper.map(entity, LabelSetDTO.class);
    }

    @Override
    public LabelDTO save(LabelDTO label) {
        Label entity = mapper.map(label, Label.class);
        entity = labelService.save(entity);
        return mapper.map(entity, LabelDTO.class);
    }

    @Override
    public SurveyDTO save(SurveyDTO survey) {
        Survey entity = mapper.map(survey, Survey.class);
        entity = surveyService.save(entity);

        if (survey.getQuestionGroups().isEmpty()) {
            return mapper.map(entity, SurveyDTO.class);
        } else {
            return mapper.map(entity, SurveyDTO.class, "survey2surveyDTOWithQuestionGroups");
        }
    }

    @Override
    public void confirm(SurveyDTO survey) {
        Survey entity = mapper.map(survey, Survey.class);
        surveyService.confirm(entity);
    }

    @Override
    public QuestionGroupDTO save(QuestionGroupDTO questionGroup) {
        QuestionGroup entity = mapper.map(questionGroup, QuestionGroup.class);
        entity = questionGroupService.save(entity);
        return mapper.map(entity, QuestionGroupDTO.class);
    }

    @Override
    public QuestionDTO save(QuestionDTO question) {
        Question entity = mapper.map(question, Question.class);
        entity = questionService.save(entity);
        return mapper.map(entity, QuestionDTO.class);
    }

    @Override
    public QuestionOptionDTO save(QuestionOptionDTO questionOption) {
        QuestionOption entity = mapper.map(questionOption, QuestionOption.class);
        entity = questionOptionService.save(entity);
        return mapper.map(entity, QuestionOptionDTO.class);
    }

    @Override
    public TranslationDTO<SurveyDTO, SurveyLanguageSettingsDTO> saveSurveyTranslation(
            TranslationDTO<SurveyDTO, SurveyLanguageSettingsDTO> translation) {

        SurveyLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                SurveyLanguageSettings.class);
        Survey entity = mapper.map(translation.getTranslatedEntity(), Survey.class);
        SurveyTranslation translationEntity = SurveyTranslation.with().language(translation.getLanguage())
                .languageSettings(languageSettings).survey(entity).build();
        SurveyTranslation tr = surveyService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> saveLabelTranslation(
            TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> translation) {
        LabelLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                LabelLanguageSettings.class);

        Label entity = mapper.map(translation.getTranslatedEntity(), Label.class);
        LabelTranslation translationEntity = LabelTranslation.with().language(translation.getLanguage())
                .languageSettings(languageSettings).label(entity).build();
        LabelTranslation tr = labelService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> saveQuestionTranslation(
            TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation) {

        QuestionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionLanguageSettings.class);
        Question entity = mapper.map(translation.getTranslatedEntity(), Question.class);
        QuestionTranslation translationEntity = QuestionTranslation.with().language(translation.getLanguage())
                .languageSettings(languageSettings).question(entity).build();
        QuestionTranslation tr = questionService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> saveQuestionGroupTranslation(
            TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> translation) {

        QuestionGroupLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionGroupLanguageSettings.class);
        QuestionGroup entity = mapper.map(translation.getTranslatedEntity(), QuestionGroup.class);
        QuestionGroupTranslation translationEntity = QuestionGroupTranslation.with()
                .language(translation.getLanguage()).languageSettings(languageSettings).questionGroup(entity).build();
        QuestionGroupTranslation tr = questionGroupService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> saveQuestionOptionTranslation(
            TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> translation) {

        QuestionOptionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionOptionLanguageSettings.class);
        QuestionOption entity = mapper.map(translation.getTranslatedEntity(), QuestionOption.class);
        QuestionOptionTranslation translationEntity = QuestionOptionTranslation.with()
                .language(translation.getLanguage()).languageSettings(languageSettings).questionOption(entity).build();
        QuestionOptionTranslation tr = questionOptionService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

}
