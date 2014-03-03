package net.sf.gazpachoquest.services.impl;

import java.util.Map;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.repository.dynamic.QuestionnairAnswersRepository;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class QuestionnairAnswersServiceImpl implements QuestionnairAnswersService {

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Autowired
    private QuestionnairAnswersRepository repository;

    public QuestionnairAnswersServiceImpl() {
        super();
    }

    @Override
    @Transactional
    public void save(Questionnair questionnair, String questionCode, Object answer) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        QuestionnairAnswers questionnairAnswers = null;
        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        if (fetched.getAnswersId() == null) {
            questionnairAnswers = new QuestionnairAnswers();
        } else {
            questionnairAnswers = repository.findByOne(questionnairDefinitionId, fetched.getAnswersId());
        }
        questionnairAnswers.setAnswer(questionCode, answer);
        questionnairAnswers = repository.save(questionnairDefinitionId, questionnairAnswers);

        if (fetched.getAnswersId() == null) {
            fetched.setAnswersId(questionnairAnswers.getId());
            questionnairRepository.save(fetched);
        }
    }

    @Override
    @Transactional
    public Object findByQuestionCode(Questionnair questionnair, String questionCode) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnairAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswer(questionCode);
    }

    @Transactional
    @Override
    public Map<String, Object> findByQuestionnair(Questionnair questionnair) {
        Assert.state(!questionnair.isNew(), "Persist the questionnair before saving answers");
        Questionnair fetched = questionnairRepository.findOne(questionnair.getId());
        Integer questionnairDefinitionId = fetched.getQuestionnairDefinition().getId();
        Integer answersId = fetched.getAnswersId();
        if (fetched.getAnswersId() == null) {
            return null;
        }
        QuestionnairAnswers answers = repository.findByOne(questionnairDefinitionId, answersId);
        return answers.getAnswers();
    }

}
