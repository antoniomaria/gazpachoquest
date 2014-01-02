package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;

public interface QuestionnairDefinitionEditorFacade {

    void confirm(QuestionnairDefinitionDTO survey);

    LabelDTO save(LabelDTO label);

    LabelSetDTO save(LabelSetDTO labelSet);

    QuestionDTO save(QuestionDTO question);

    QuestionGroupDTO save(QuestionGroupDTO questionGroup);

    QuestionOptionDTO save(QuestionOptionDTO questionOption);

    QuestionnairDefinitionDTO save(QuestionnairDefinitionDTO survey);

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
