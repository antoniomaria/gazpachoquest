package net.sf.gazpachoquest.questionnaires.components.util;

import net.sf.gazpachoquest.questionnaires.components.question.type.NumericQuestion;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.IntegerRangeValidator;

public class CustomIntegerRangeValidator extends AbstractValidator<String> {

	private static final long serialVersionUID = -6229561147064738629L;

	private IntegerRangeValidator integerRangeValidator;

	private static Logger logger = LoggerFactory
			.getLogger(CustomIntegerRangeValidator.class);

	public CustomIntegerRangeValidator(String errorMessage, Integer minValue,
			Integer maxValue) {
		super(errorMessage);
		this.integerRangeValidator = new IntegerRangeValidator(errorMessage,
				minValue, maxValue);
	}

	@Override
	protected boolean isValidValue(String value) {
		logger.debug("Validating string {} as integer", value);

		if (StringUtils.isBlank(value)) {
			return true;
		}

		try {
			Integer result = Integer.parseInt(value);
			integerRangeValidator.validate(result);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}
}
