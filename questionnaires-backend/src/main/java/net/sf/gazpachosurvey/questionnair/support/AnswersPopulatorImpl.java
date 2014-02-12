package net.sf.gazpachosurvey.questionnair.support;

import java.util.List;
import java.util.Map;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionDTO;
import net.sf.gazpachosurvey.dto.answers.AbstractAnswer;
import net.sf.gazpachosurvey.dto.answers.BooleanAnswer;
import net.sf.gazpachosurvey.dto.answers.MultipleAnswer;
import net.sf.gazpachosurvey.dto.answers.NumericAnswer;
import net.sf.gazpachosurvey.dto.answers.TextAnswer;
import net.sf.gazpachosurvey.services.QuestionnairAnswersService;
import net.sf.gazpachosurvey.types.QuestionType;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AnswersPopulatorImpl implements AnswersPopulator {

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    public AnswersPopulatorImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public void populate(Questionnair questionnair, List<QuestionDTO> questions) {
        Map<String, Object> answers = questionnairAnswersService.findByQuestionnair(questionnair);
        if (answers == null) {
            return;
        }
        for (QuestionDTO question : questions) {
            populateAnswers(question, answers);
        }
    }

    private void populateAnswers(QuestionDTO question, Map<String, Object> answers) {
        if (question.getType().hasSubquestions()) {
            for (QuestionDTO subquestion : question.getSubquestions()) {
                populateAnswers(subquestion, answers);
            }
        } else {
            AbstractAnswer answer = null;
            QuestionType type = question.getType();
            String questionCode = question.getCode();
            if (!type.hasMultipleAnswers()) {
                if (QuestionType.S.equals(type) || QuestionType.L.equals(type)) {
                    Object value = answers.get(questionCode);
                    answer = TextAnswer.fromValue((String) value);
                } else if (QuestionType.N.equals(type)) {
                    Object value = answers.get(questionCode);
                    answer = NumericAnswer.fromValue((Integer) value);
                } else if (QuestionType.T.equals(type)) {
                    Character[] value = (Character[]) answers.get(questionCode);
                    answer = new TextAnswer(new String(ArrayUtils.toPrimitive(value)));
                } else {
                    throw new IllegalStateException(type + " not supported");
                }
            } else {
                List<QuestionOptionDTO> questionOptions = question.getQuestionOptions();
                answer = new MultipleAnswer();
                for (QuestionOptionDTO questionOptionDTO : questionOptions) {
                    String optionCode = questionOptionDTO.getCode();
                    String answerCode = new StringBuilder(questionCode).append("_").append(optionCode).toString();
                    Object value = answers.get(answerCode);
                    // Only checkbox are supported
                    if (type.getAnswerType().isAssignableFrom(Boolean.class)) {
                        ((MultipleAnswer) answer).addAnswer(BooleanAnswer.valueOf(optionCode, (Boolean) value));
                    } else {
                        throw new IllegalStateException(type + " not supported");
                    }
                }
            }
            question.setAnswer(answer);
        }
    }

}
