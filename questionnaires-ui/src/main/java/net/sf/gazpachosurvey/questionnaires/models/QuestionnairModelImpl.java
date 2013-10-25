package net.sf.gazpachosurvey.questionnaires.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class QuestionnairModelImpl implements QuestionnairModel{
    private static final Logger logger = LoggerFactory.getLogger(QuestionnairModelImpl.class);

    public QuestionnairModelImpl(){
        logger.debug("New instance of class {} has been created with id = {} ",
                QuestionnairModelImpl.class.toString(), this.hashCode());
  
    }
}
