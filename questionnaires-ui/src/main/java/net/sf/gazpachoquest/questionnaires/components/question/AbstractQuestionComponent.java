package net.sf.gazpachoquest.questionnaires.components.question;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.questionnaires.events.AnswerSavedEvent;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@Named
@SessionScoped
public abstract class AbstractQuestionComponent extends CustomComponent implements QuestionComponent {

    private static final long serialVersionUID = -2274020487486737492L;

    @Inject
    protected javax.enterprise.event.Event<AnswerSavedEvent> answerSavedEvent;

    protected VerticalLayout content;

    protected QuestionDTO questionDTO;

    protected AbstractQuestionComponent() {
        super();
        content = new VerticalLayout();
        setSizeUndefined();
        // The composition root MUST be set
        setCompositionRoot(content);
    }

    public VerticalLayout getContent() {
        return content;
    }

    public void setContent(VerticalLayout content) {
        this.content = content;
    }

    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    @Override
    public void setQuestionDTO(QuestionDTO questionDTO) {
        this.questionDTO = questionDTO;
    }

    protected abstract void init();

}
