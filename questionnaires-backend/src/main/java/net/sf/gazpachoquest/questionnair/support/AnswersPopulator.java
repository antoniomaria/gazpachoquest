package net.sf.gazpachoquest.questionnair.support;

import java.util.List;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachosurvey.domain.core.Questionnair;

public interface AnswersPopulator {

    void populate(Questionnair questionnair, List<QuestionDTO> questions);

}
