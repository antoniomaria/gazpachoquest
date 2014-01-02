package net.sf.gazpachosurvey.repository.dynamic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairAnswersActivator {

    @Autowired
    private QuestionnairAnswersRepository repository;

    @PostConstruct
    public void active() {
        repository.activeAllAnswers();
    }
}
