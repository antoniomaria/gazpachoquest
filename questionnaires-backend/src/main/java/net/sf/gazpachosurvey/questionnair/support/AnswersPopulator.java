package net.sf.gazpachosurvey.questionnair.support;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.dto.QuestionDTO;

public interface AnswersPopulator {

    void populate(Questionnair questionnair, List<QuestionDTO> questions);

}
