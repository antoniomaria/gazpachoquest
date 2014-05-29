package net.sf.gazpachoquest.questionnaires.renderer.question.types.shorttext;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.questionnaires.renderer.question.AbstractRenderer;
import net.sf.gazpachoquest.questionnaires.renderer.question.Renderer;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class RendererImpl extends AbstractRenderer implements Renderer {

	public RendererImpl(QuestionnairResource questionnairResource) {
		super(questionnairResource);
	}

	public Panel render(QuestionDTO questionDTO) {
		Panel panel = new Panel();
		panel.setSizeUndefined(); // Shrink to fit content
		
		FormLayout content = new FormLayout();
		content.addStyleName("mypanelcontent");

		TextField textField = new TextField(questionDTO.getLanguageSettings().getTitle());
		textField.setImmediate(true);
		textField.addBlurListener(new BlurListener() {
			
			@Override
			public void blur(BlurEvent event) {
				System.out.println("blurr!");
				questionnairResource.getDefinition(103);
				System.out.println("blur!!");
			}
		});
		content.addComponent(textField);
		content.setSizeUndefined(); // Shrink to fit
		content.setMargin(true);
		panel.setContent(content);
		return panel;
	}
}
