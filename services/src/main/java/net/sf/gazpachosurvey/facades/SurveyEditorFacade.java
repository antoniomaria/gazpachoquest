package net.sf.gazpachosurvey.facades;

import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;

public interface SurveyEditorFacade {

    LabelSetDTO save(LabelSetDTO labelSet);

    void saveTranslation(TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> translation);
}
