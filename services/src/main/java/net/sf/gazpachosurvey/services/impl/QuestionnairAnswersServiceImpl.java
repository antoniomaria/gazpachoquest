package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachosurvey.services.QuestionnairAnswersService;
import net.sf.gazpachosurvey.services.QuestionnairService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionnairAnswersServiceImpl implements QuestionnairAnswersService {

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    private QuestionnairAnswersRepository repository;

    public QuestionnairAnswersServiceImpl() {
        super();
    }

    @Override
    public void save(Questionnair questionnair, String questionCode, String answer) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        questionnair = questionnairService.findOne(questionnair.getId());
        QuestionnairAnswers questionnairAnswers = null;
        Integer questionnairDefinitionId = questionnair.getQuestionnairDefinition().getId();
        if (questionnair.getAnswersId() == null) {
            questionnairAnswers = new QuestionnairAnswers();
        } else {
            questionnairAnswers = repository.findByOne(questionnairDefinitionId, questionnair.getAnswersId());
        }
        questionnairAnswers.setAnswer(questionCode, answer);
        questionnairAnswers = repository.save(questionnairDefinitionId, questionnairAnswers);

        questionnair.setAnswersId(questionnairAnswers.getId());
        questionnairService.save(questionnair);
    }

    @Override
    @Transactional
    public Object findByQuestionCode(Questionnair questionnair, String questionCode) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Integer questionnairDefinitionId = questionnair.getQuestionnairDefinition().getId();
        Integer answersId = questionnair.getAnswersId();
        if (questionnair.getAnswersId() == null) {
            return null;
        }
        QuestionnairAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);

        return answers.getAnswer(questionCode);
    }

}
