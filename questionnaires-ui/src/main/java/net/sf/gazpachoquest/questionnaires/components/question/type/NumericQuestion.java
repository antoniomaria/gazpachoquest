package net.sf.gazpachoquest.questionnaires.components.question.type;

import javax.inject.Inject;

import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.NoAnswer;
import net.sf.gazpachoquest.dto.answers.NumericAnswer;
import net.sf.gazpachoquest.questionnaires.components.question.AbstractQuestionComponent;
import net.sf.gazpachoquest.questionnaires.components.util.CustomIntegerRangeValidator;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.addon.cdiproperties.annotation.LabelProperties;
import org.vaadin.addon.cdiproperties.annotation.TextFieldProperties;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
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
		if (questionDTO.getAnswer() instanceof NumericAnswer) {
			answerField.setValue(String.valueOf(((NumericAnswer) questionDTO
					.getAnswer()).getValue()));
		}
		answerField.addValidator(new CustomIntegerRangeValidator(
				"{0} is not a valid number", 0, null));
		// answerField.setConverter(new StringToIntegerConverter());
		content.addComponent(answerField);
	}

	@Override
	public void textChange(TextChangeEvent event) {
		String newValue = event.getText();
		logger.debug("Text Change Event fired in {} with text = {}",
				NumericQuestion.class.getSimpleName(), newValue);
		if (isValid(answerField, newValue)) {
			String questionCode = questionDTO.getCode();
			Answer answer = null;
			if (StringUtils.isEmpty(newValue)) {
				answer = NoAnswer.create();
			} else {
				answer = NumericAnswer.fromValue(Integer.parseInt(newValue));
			}
			answerSavedEvent.fire(AnswerSavedEvent.with()
					.questionCode(questionCode).answer(answer).build());
			answerField.setComponentError(null);
		}
	}

	public boolean isValid(TextField field, String newValue) {
		boolean valid = true;

		if (StringUtils.isBlank(newValue)) {
			if (field.isRequired()) {
				valid = false;
			}
		} else {
			for (Validator v : field.getValidators()) {
				try {
					v.validate(newValue);
				} catch (InvalidValueException e) {
					valid = false;
					logger.warn(e.getMessage());
					answerField
							.setComponentError(new UserError(e.getMessage()));
				}
			}
		}
		if (valid) {
			answerField.setComponentError(null);
		}
		return valid;
	}
}
