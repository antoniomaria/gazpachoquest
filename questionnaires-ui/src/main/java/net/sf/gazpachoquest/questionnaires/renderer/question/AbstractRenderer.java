package net.sf.gazpachoquest.questionnaires.renderer.question;

import net.sf.gazpachoquest.api.QuestionnairResource;

public abstract class AbstractRenderer implements Renderer {

	protected QuestionnairResource questionnairResource;

	protected AbstractRenderer(QuestionnairResource questionnairResource) {
		this.questionnairResource = questionnairResource;
	}

	public QuestionnairResource getQuestionnairResource() {
		return questionnairResource;
	}

	public void setQuestionnairResource(
			QuestionnairResource questionnairResource) {
		this.questionnairResource = questionnairResource;
	}

}
