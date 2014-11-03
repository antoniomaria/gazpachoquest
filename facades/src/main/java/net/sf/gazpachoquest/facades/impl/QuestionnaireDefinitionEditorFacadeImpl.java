/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.facades.impl;

import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.LabelSet;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionOptionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.LabelTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionOptionTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.i18.SectionTranslation;
import net.sf.gazpachoquest.dto.LabelDTO;
import net.sf.gazpachoquest.dto.LabelLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.LabelSetDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.SectionDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.QuestionnaireDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.embeddables.SectionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionEditorFacade;
import net.sf.gazpachoquest.services.LabelService;
import net.sf.gazpachoquest.services.LabelSetService;
import net.sf.gazpachoquest.services.QuestionOptionService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.services.SectionService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class QuestionnaireDefinitionEditorFacadeImpl implements QuestionnaireDefinitionEditorFacade {

    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelSetService labelSetService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private QuestionOptionService questionOptionService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    @Qualifier("questionnaireDefinitionServiceImpl")
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    public QuestionnaireDefinitionEditorFacadeImpl() {
        super();
    }

    @Override
    public void confirm(final QuestionnaireDefinitionDTO questionnaireDefinitionDTO) {
        QuestionnaireDefinition entity = mapper.map(questionnaireDefinitionDTO, QuestionnaireDefinition.class);
        questionnaireDefinitionService.confirm(entity);
    }

    @Override
    public LabelDTO save(final LabelDTO label) {
        Label entity = mapper.map(label, Label.class);
        entity = labelService.save(entity);
        return mapper.map(entity, LabelDTO.class);
    }

    @Override
    public LabelSetDTO save(final LabelSetDTO labelSet) {
        LabelSet entity = mapper.map(labelSet, LabelSet.class);
        entity = labelSetService.save(entity);
        return mapper.map(entity, LabelSetDTO.class);
    }

    @Override
    public QuestionDTO save(final QuestionDTO question) {
        Question entity = mapper.map(question, Question.class);
        entity = questionService.save(entity);
        return mapper.map(entity, QuestionDTO.class);
    }

    @Override
    public SectionDTO save(final SectionDTO section) {
        Section entity = mapper.map(section, Section.class);
        entity = sectionService.save(entity);
        return mapper.map(entity, SectionDTO.class);
    }

    @Override
    public QuestionOptionDTO save(final QuestionOptionDTO questionOption) {
        QuestionOption entity = mapper.map(questionOption, QuestionOption.class);
        entity = questionOptionService.save(entity);
        return mapper.map(entity, QuestionOptionDTO.class);
    }

    @Override
    public QuestionnaireDefinitionDTO save(final QuestionnaireDefinitionDTO questionnaireDefinitionDTO) {
        QuestionnaireDefinition entity = mapper.map(questionnaireDefinitionDTO, QuestionnaireDefinition.class);
        entity = questionnaireDefinitionService.save(entity);

        if (questionnaireDefinitionDTO.getSections().isEmpty()) {
            return mapper.map(entity, QuestionnaireDefinitionDTO.class);
        } else {
            return mapper.map(entity, QuestionnaireDefinitionDTO.class, "toDTOwithSections");
        }
    }

    @Override
    public TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> saveLabelTranslation(
            final TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> translation) {
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
    public TranslationDTO<SectionDTO, SectionLanguageSettingsDTO> saveSectionTranslation(
            final TranslationDTO<SectionDTO, SectionLanguageSettingsDTO> translation) {

        SectionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                SectionLanguageSettings.class);
        Section entity = mapper.map(translation.getTranslatedEntity(), Section.class);
        SectionTranslation translationEntity = SectionTranslation.with().language(translation.getLanguage())
                .languageSettings(languageSettings).section(entity).build();
        SectionTranslation tr = sectionService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> saveQuestionOptionTranslation(
            final TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> translation) {

        QuestionOptionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionOptionLanguageSettings.class);
        QuestionOption entity = mapper.map(translation.getTranslatedEntity(), QuestionOption.class);
        QuestionOptionTranslation translationEntity = QuestionOptionTranslation.with()
                .language(translation.getLanguage()).languageSettings(languageSettings).questionOption(entity).build();
        QuestionOptionTranslation tr = questionOptionService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

    @Override
    public TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> saveQuestionTranslation(
            final TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation) {

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
    public TranslationDTO<QuestionnaireDefinitionDTO, QuestionnaireDefinitionLanguageSettingsDTO> saveQuestionnaireTranslation(
            final TranslationDTO<QuestionnaireDefinitionDTO, QuestionnaireDefinitionLanguageSettingsDTO> translation) {

        QuestionnaireDefinitionLanguageSettings languageSettings = mapper.map(translation.getLanguageSettings(),
                QuestionnaireDefinitionLanguageSettings.class);
        QuestionnaireDefinition entity = mapper.map(translation.getTranslatedEntity(), QuestionnaireDefinition.class);
        QuestionnaireDefinitionTranslation translationEntity = QuestionnaireDefinitionTranslation.with()
                .language(translation.getLanguage()).languageSettings(languageSettings).questionnaireDefinition(entity)
                .build();
        QuestionnaireDefinitionTranslation tr = questionnaireDefinitionService.saveTranslation(translationEntity);
        translation.setId(tr.getId());
        return translation;
    }

}
