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
