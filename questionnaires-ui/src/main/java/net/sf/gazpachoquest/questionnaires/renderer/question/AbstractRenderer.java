package net.sf.gazpachoquest.questionnaires.renderer.question;

import javax.inject.Inject;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;

public abstract class AbstractRenderer implements Renderer {

    @Inject
    @GazpachoResource
    protected QuestionnairResource questionnairResource;

    protected AbstractRenderer() {
        super();
    }

    public QuestionnairResource getQuestionnairResource() {
        return questionnairResource;
    }

    public void setQuestionnairResource(QuestionnairResource questionnairResource) {
        this.questionnairResource = questionnairResource;
    }

}
