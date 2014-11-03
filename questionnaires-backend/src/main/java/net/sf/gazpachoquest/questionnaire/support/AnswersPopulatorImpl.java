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
package net.sf.gazpachoquest.questionnaire.support;

import java.util.List;
import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.SubquestionDTO;
import net.sf.gazpachoquest.dto.answers.AbstractAnswer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.MultipleAnswer;
import net.sf.gazpachoquest.dto.answers.NoAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.dto.support.AbstractQuestionDTO;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;
import net.sf.gazpachoquest.types.QuestionType;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AnswersPopulatorImpl implements AnswersPopulator {

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    public AnswersPopulatorImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = true)
    public void populate(Map<String, Object> answers, List<QuestionDTO> questions) {
        //Map<String, Object> answers = questionnaireAnswersService.findByQuestionnaire(questionnaire);
        if (answers == null) {
            return;
        }
        for (QuestionDTO question : questions) {
            populateAnswers(question, answers);
        }
    }

    private void populateAnswers(AbstractQuestionDTO question, Map<String, Object> answers) {
        if (question.getType().hasSubquestions()) {
            QuestionDTO questionDTO = (QuestionDTO) question;
            for (SubquestionDTO subquestion : questionDTO.getSubquestions()) {
                populateAnswers(subquestion, answers);
            }
        } else {
            AbstractAnswer answer = null;
            QuestionType type = question.getType();
            String questionCode = question.getCode();
            if (!type.hasMultipleAnswers()) {
                if (QuestionType.S.equals(type) || QuestionType.L.equals(type)) {
                    Object value = answers.get(questionCode);
                    answer = value != null ? TextAnswer.fromValue((String) value) : NoAnswer.create();
                } else if (QuestionType.N.equals(type)) {
                    Object value = answers.get(questionCode);
                    answer = value != null ? NumericAnswer.fromValue((Integer) value) : NoAnswer.create();
                } else if (QuestionType.T.equals(type)) {
                    Character[] value = (Character[]) answers.get(questionCode);
                    answer = value != null ? new TextAnswer(new String(ArrayUtils.toPrimitive(value))) : NoAnswer
                            .create();
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
