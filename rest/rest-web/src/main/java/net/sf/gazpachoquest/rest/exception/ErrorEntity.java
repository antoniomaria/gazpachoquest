package net.sf.gazpachoquest.rest.exception;

import java.util.List;
import java.util.Map;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.Question.Builder;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionTranslation;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

public class ErrorEntity {

	private String code;

	private String message;

	public ErrorEntity() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static Builder with() {
		return new Builder();
	}

	public static class Builder {
		private String code;
		private String message;

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public ErrorEntity build() {
			ErrorEntity errorEntity = new ErrorEntity();
			errorEntity.code = code;
			errorEntity.message = message;
			return errorEntity;
		}
	}

}
