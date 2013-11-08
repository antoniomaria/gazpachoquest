package net.sf.gazpachosurvey.repository.dynamic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespondentAnswersActivator {


    @Autowired
    private RespondentAnswersRepository repository;
    
    @PostConstruct
    public void active(){
        repository.activeAllAnswers();
    }
}
