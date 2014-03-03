package net.sf.gazpachoquest.questionnair.support;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.dto.QuestionDTO;

public interface AnswersPopulator {

    void populate(Questionnair questionnair, List<QuestionDTO> questions);

}
