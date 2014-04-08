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
package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.LabelDTO;
import net.sf.gazpachoquest.dto.LabelLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.LabelSetDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionGroupDTO;
import net.sf.gazpachoquest.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;

public interface QuestionnairDefinitionEditorFacade {

    void confirm(QuestionnairDefinitionDTO questionairDefinition);

    LabelDTO save(LabelDTO label);

    LabelSetDTO save(LabelSetDTO labelSet);

    QuestionDTO save(QuestionDTO question);

    QuestionGroupDTO save(QuestionGroupDTO questionGroup);

    QuestionOptionDTO save(QuestionOptionDTO questionOption);

    QuestionnairDefinitionDTO save(QuestionnairDefinitionDTO questionairDefinition);

    TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> saveLabelTranslation(
            TranslationDTO<LabelDTO, LabelLanguageSettingsDTO> translation);

    TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> saveQuestionGroupTranslation(
            TranslationDTO<QuestionGroupDTO, QuestionGroupLanguageSettingsDTO> translation);

    TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> saveQuestionOptionTranslation(
            TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> translation);

    TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> saveQuestionTranslation(
            TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation);

    TranslationDTO<QuestionnairDefinitionDTO, QuestionnairDefinitionLanguageSettingsDTO> saveSurveyTranslation(
            TranslationDTO<QuestionnairDefinitionDTO, QuestionnairDefinitionLanguageSettingsDTO> translation);

}
