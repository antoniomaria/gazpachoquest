package net.sf.gazpachoquest.questionnaires.components.question.type;

import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.questionnaires.components.question.AbstractQuestionComponent;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class NumericQuestion extends AbstractQuestionComponent implements TextChangeListener {

    private static final long serialVersionUID = 53070631753820596L;

    private static Logger logger = LoggerFactory.getLogger(NumericQuestion.class);

    private TextField answerField;

    public NumericQuestion() {
        super();
    }

    @Override
    public void init() {
        Label questionTitle = new Label(questionDTO.getLanguageSettings().getTitle());
        content.addComponent(questionTitle);

        answerField = new TextField();
        answerField.addTextChangeListener(this);
        if (questionDTO.getAnswer() != null) {
            answerField.setValue(String.valueOf(((NumericAnswer) questionDTO.getAnswer()).getValue()));
        }
        answerField.setMaxLength(50);
        answerField.setNullSettingAllowed(true);
        answerField.setNullRepresentation("");
        answerField.setConverter(new StringToIntegerConverter());
        answerField.addValidator(new IntegerRangeValidator("Only Integers allowed!", 0, null));
        content.addComponent(answerField);
    }

    @Override
    public void textChange(TextChangeEvent event) {
        String uiValue = answerField.getValue();
        logger.debug("Text Change Event fired in {} with text = {}", NumericQuestion.class.getSimpleName(), uiValue);
        try {
            Integer convertedValue = (Integer) answerField.getConvertedValue();
            String questionCode = questionDTO.getCode();
            Answer answer = NumericAnswer.fromValue(convertedValue);
            answerSavedEvent.fire(AnswerSavedEvent.with().questionCode(questionCode).answer(answer).build());
            answerField.setComponentError(null);
        } catch (ConversionException e) {
            answerField.setComponentError(new UserError(e.getMessage()));
            logger.warn(e.getMessage());
        }

    }
}
