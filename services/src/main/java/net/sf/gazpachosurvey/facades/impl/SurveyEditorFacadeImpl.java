package net.sf.gazpachosurvey.facades.impl;

import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.i18.QuestionTranslation;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.facades.SurveyEditorFacade;
import net.sf.gazpachosurvey.services.LabelSetService;
import net.sf.gazpachosurvey.services.QuestionService;

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
    private QuestionService questionService;

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
    public TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> saveTranslation(
            TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation) {

        QuestionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionLanguageSettings.class);
        Question question = mapper.map(translation.getTranslatedEntity(), Question.class);
        QuestionTranslation questionTranslationEntity = QuestionTranslation.with().language(translation.getLanguage())
                .languageSettings(languageSettings).question(question).build();
        QuestionTranslation tr = questionService.saveTranslation(questionTranslationEntity);
        translation.setId(tr.getId());
        return translation;
    }
}
