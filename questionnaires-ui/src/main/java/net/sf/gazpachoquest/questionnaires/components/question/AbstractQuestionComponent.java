package net.sf.gazpachoquest.questionnaires.components.question;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionDTO;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractQuestionComponent extends CustomComponent
		implements QuestionComponent {

	private static final long serialVersionUID = -2274020487486737492L;

	protected QuestionnairResource questionnairResource;

	protected VerticalLayout content;
	
	protected QuestionDTO questionDTO;

	protected Integer questionnairId;
	
	protected AbstractQuestionComponent(QuestionnairResource questionnairResource, Integer questionnairId, QuestionDTO questionDTO) {
		super();
		this.content = new VerticalLayout();
		this.questionnairResource = questionnairResource;
		this.questionDTO = questionDTO;
		this.questionnairId = questionnairId;
		setSizeUndefined();
		// The composition root MUST be set
		setCompositionRoot(content);
		
	}

	public QuestionnairResource getQuestionnairResource() {
		return questionnairResource;
	}

	public void setQuestionnairResource(
			QuestionnairResource questionnairResource) {
		this.questionnairResource = questionnairResource;
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

	public void setQuestionDTO(QuestionDTO questionDTO) {
		this.questionDTO = questionDTO;
	}

}
