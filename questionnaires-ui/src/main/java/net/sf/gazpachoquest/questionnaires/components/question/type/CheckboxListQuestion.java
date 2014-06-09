package net.sf.gazpachoquest.questionnaires.components.question.type;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.MultipleAnswer;
import net.sf.gazpachoquest.dto.answers.NoAnswer;
import net.sf.gazpachoquest.dto.answers.TextAnswer;
import net.sf.gazpachoquest.questionnaires.components.question.AbstractQuestionComponent;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import org.vaadin.addon.cdiproperties.annotation.LabelProperties;
import org.vaadin.addon.cdiproperties.annotation.OptionGroupProperties;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;

public class CheckboxListQuestion extends AbstractQuestionComponent implements
		ValueChangeListener {

	private static final long serialVersionUID = -9223012579161288406L;

	@Inject
	@LabelProperties
	private Label questionTitle;

	@Inject
	@OptionGroupProperties(immediate = true, nullSelectionAllowed = false, multiSelect = true)
	private OptionGroup options;

	@Override
	protected void init() {
		questionTitle.setCaption(questionDTO.getLanguageSettings().getTitle());
		content.addComponent(questionTitle);

		options.setCaption("Choose one of the following answers");

		Answer multipleAnswer = questionDTO.getAnswer();
		List<Answer> answers = Collections.emptyList();
		if (multipleAnswer instanceof MultipleAnswer) {
			answers = ((MultipleAnswer) multipleAnswer).getAnswers();
		}
		for (QuestionOptionDTO questionOptionDTO : questionDTO
				.getQuestionOptions()) {
			String optionCode = questionOptionDTO.getCode();
			String optionTitle = questionOptionDTO.getLanguageSettings()
					.getTitle();
			options.addItem(optionCode);
			options.setItemCaption(optionCode, optionTitle);

			for (Answer answer : answers) {
				BooleanAnswer booleanAnswer = (BooleanAnswer) answer;
				if (booleanAnswer.getOption().equals(optionCode)) {
					if (booleanAnswer.getValue()) {
						options.setValue(optionCode);
					}
					break;
				}
			}
		}
		options.addValueChangeListener(this);

		content.addComponent(options);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String option = (String) event.getProperty().getValue();
		Answer answer = null;
		if (option.equals("NULL")) {
			answer = NoAnswer.create();
		} else {
			answer = TextAnswer.fromValue((String) event.getProperty()
					.getValue());
		}
		super.answerSavedEvent.fire(AnswerSavedEvent.with()
				.questionCode(questionDTO.getCode()).answer(answer).build());
	}
}
