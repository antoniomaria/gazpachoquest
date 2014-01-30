package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.services.QuestionnairAnswersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairAnswersServiceImpl implements QuestionnairAnswersService {

    @Autowired
    QuestionnairAnswersRepository repository;

    public QuestionnairAnswersServiceImpl() {
        super();
    }

    public void f() {

    }

}
