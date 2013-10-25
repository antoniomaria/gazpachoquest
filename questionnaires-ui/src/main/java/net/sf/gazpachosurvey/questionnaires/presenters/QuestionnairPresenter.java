package net.sf.gazpachosurvey.questionnaires.presenters;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.gazpachosurvey.questionnaires.models.QuestionnairModel;
import net.sf.gazpachosurvey.questionnaires.views.QuestionnairView;
import net.sf.gazpachosurvey.questionnaires.views.QuestionnairViewImpl;

public class QuestionnairPresenter implements Serializable {

    private static final long serialVersionUID = -3934855797066584834L;

    private static final Logger logger = LoggerFactory
            .getLogger(QuestionnairPresenter.class);

    @Autowired
    private QuestionnairModel model;
    
    private QuestionnairView view;

    public QuestionnairPresenter() {
        logger.debug("New instance of class {} has been created with id = {} ",
                QuestionnairPresenter.class.toString(), this.hashCode());
    }

    public void setView(QuestionnairView view) {
        this.view = view;
    }
    
    
}
