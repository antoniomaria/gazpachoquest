package net.sf.gazpachoquest.questionnaires.components.question;

import net.sf.gazpachoquest.dto.QuestionDTO;

import com.vaadin.ui.Component;

public interface QuestionComponent extends Component {
    void setQuestionDTO(QuestionDTO questionDTO);
}
