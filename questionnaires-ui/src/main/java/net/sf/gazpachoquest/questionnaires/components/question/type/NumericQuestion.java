package net.sf.gazpachoquest.questionnaires.components.question.type;

import javax.inject.Inject;

import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BlankAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.questionnaires.components.question.AbstractQuestionComponent;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.addon.cdiproperties.annotation.LabelProperties;
import org.vaadin.addon.cdiproperties.annotation.TextFieldProperties;

import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.data.util.converter.StringToIntegerConverter;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class NumericQuestion extends AbstractQuestionComponent implements
		TextChangeListener {

	private static final long serialVersionUID = 53070631753820596L;

	private static Logger logger = LoggerFactory
			.getLogger(NumericQuestion.class);

	@Inject
	@LabelProperties
	private Label questionTitle;

	@Inject
	@TextFieldProperties(maxLength = 50, nullRepresentation = "", nullSettingAllowed = true, immediate = true)
	private TextField answerField;

	public NumericQuestion() {
		super();
	}

	@Override
	public void init() {
		questionTitle.setCaption(questionDTO.getLanguageSettings().getTitle());
		content.addComponent(questionTitle);

		answerField.addTextChangeListener(this);
		if (questionDTO.getAnswer() != null) {
			answerField.setValue(String.valueOf(((NumericAnswer) questionDTO
					.getAnswer()).getValue()));
		}
		//answerField.setConverter(new StringToIntegerConverter());
		//answerField.addValidator(new IntegerRangeValidator(		"Only Integers allowed!", 0, null));
		content.addComponent(answerField);
	}

	public void textChange(TextChangeEvent event) {
		String uiValue = event.getText();
		logger.debug(
				"Text Change Event fired in {} with text = {}",
				NumericQuestion.class.getSimpleName(), uiValue);
		Answer answer = NumericAnswer.fromValue(-1);
		boolean isValid = true;
		if (StringUtils.isNotBlank(uiValue)) {
			try {
				Integer convertedValue = Integer.parseInt(uiValue);
				answer = NumericAnswer.fromValue(convertedValue);
			} catch (NumberFormatException e) {
				isValid = false;
				answerField.setComponentError(new UserError("Only Integers allowed"));
				logger.warn(e.getMessage());
			}
		}
		if (isValid) {
			String questionCode = questionDTO.getCode();
			answerSavedEvent.fire(AnswerSavedEvent.with()
					.questionCode(questionCode).answer(answer).build());
			answerField.setComponentError(null);
		}

	}

	public void xxtextChange(TextChangeEvent event) {
		String uiValue = event.getText();
		logger.debug("Text Change Event fired in {} with text = {}",
				NumericQuestion.class.getSimpleName(), uiValue);
		try {
			Integer convertedValue = (Integer) answerField.getConvertedValue();
			String questionCode = questionDTO.getCode();
			Answer answer = NumericAnswer.fromValue(convertedValue);
			answerSavedEvent.fire(AnswerSavedEvent.with()
					.questionCode(questionCode).answer(answer).build());
			answerField.setComponentError(null);
		} catch (ConversionException e) {
			if (answerField.getComponentError() == null){
				answerField.setComponentError(new UserError(e.getMessage()));
			}
			logger.warn(e.getMessage());
		}

	}
}
