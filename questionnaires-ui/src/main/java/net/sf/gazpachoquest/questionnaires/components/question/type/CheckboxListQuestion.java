package net.sf.gazpachoquest.questionnaires.components.question.type;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.MultipleAnswer;
import net.sf.gazpachoquest.questionnaires.components.question.AbstractQuestionComponent;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import org.vaadin.addon.cdiproperties.annotation.LabelProperties;
import org.vaadin.addon.cdiproperties.annotation.OptionGroupProperties;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;

public class CheckboxListQuestion extends AbstractQuestionComponent implements ValueChangeListener {

    private static final long serialVersionUID = -9223012579161288406L;

    @Inject
    @LabelProperties(contentMode = ContentMode.HTML)
     private Label questionTitle;

    @Inject
    @OptionGroupProperties(immediate = true, nullSelectionAllowed = true, multiSelect = true)
    private OptionGroup options;

    private Set<String> selectedOptions;

    @Override
    protected void init() {
        questionTitle.setValue(String.format("<b>%d</b>. %s", questionDTO.getNumber(), questionDTO
                .getLanguageSettings().getTitle()));
        questionTitle.setContentMode(ContentMode.HTML);
        
        content.addComponent(questionTitle);
        options.setCaption("Choose one of the following answers");

        Answer multipleAnswer = questionDTO.getAnswer();
        List<Answer> answers = Collections.emptyList();
        if (multipleAnswer instanceof MultipleAnswer) {
            answers = ((MultipleAnswer) multipleAnswer).getAnswers();
        }
        selectedOptions = new HashSet<String>();

        for (QuestionOptionDTO questionOptionDTO : questionDTO.getQuestionOptions()) {
            String optionCode = questionOptionDTO.getCode();
            String optionTitle = questionOptionDTO.getLanguageSettings().getTitle();
            options.addItem(optionCode);
            options.setItemCaption(optionCode, optionTitle);

            for (Answer answer : answers) {
                BooleanAnswer booleanAnswer = (BooleanAnswer) answer;
                if (booleanAnswer.getOption().equals(optionCode)) {
                    if (booleanAnswer.getValue()) {
                        selectedOptions.add(optionCode);
                    }
                    break;
                }
            }
        }
        options.setValue(selectedOptions);
        options.addValueChangeListener(this);
        content.addComponent(options);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void valueChange(ValueChangeEvent event) {
        Collection<String> newSelectedOptions = (Collection<String>) event.getProperty().getValue();
        Set<String> bag = new HashSet<>();
        String selectedOption = null;
        BooleanAnswer answer = null;
        if (newSelectedOptions.size() > selectedOptions.size()) {
            bag.addAll(newSelectedOptions);
            bag.removeAll(selectedOptions);
            selectedOption = bag.iterator().next();
            answer = BooleanAnswer.valueOf(selectedOption, Boolean.TRUE);
        } else {
            bag.addAll(selectedOptions);
            bag.removeAll(newSelectedOptions);
            selectedOption = bag.iterator().next();
            answer = BooleanAnswer.valueOf(selectedOption, Boolean.FALSE);
        }

        selectedOptions.clear();
        selectedOptions.addAll(newSelectedOptions);
        super.answerSavedEvent.fire(AnswerSavedEvent.with().questionCode(questionDTO.getCode()).answer(answer).build());

    }
}
