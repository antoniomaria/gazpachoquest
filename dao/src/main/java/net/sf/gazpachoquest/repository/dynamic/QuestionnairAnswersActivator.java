package net.sf.gazpachoquest.repository.dynamic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairAnswersActivator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuestionnairAnswersRepository repository;

    @PostConstruct
    public void active() {
        // repository.activeAllAnswers();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // TODO Auto-generated method stub
        repository.activeAllAnswers();
    }
}
