package net.sf.gazpachoquest.questionnaires.renderer.question;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.questionnaires.renderer.question.types.shorttext.RendererImpl;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.types.QuestionType;


@Named
@SessionScoped
public class RendererFactory implements Serializable {

	private static final long serialVersionUID = 4940136934279107883L;

	@GazpachoResource
	private QuestionnairResource questionnairResource;

	public Renderer createRenderer(QuestionType questionType) {
		switch (questionType) {
		case S:
			return new RendererImpl(questionnairResource);
		default:
			return null;
		}

	}
}
