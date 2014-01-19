package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.repository.QuestionnairRepository;
import net.sf.gazpachosurvey.services.QuestionnairService;
import net.sf.gazpachosurvey.types.EntityStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnairServiceImpl extends AbstractPersistenceService<Questionnair> implements QuestionnairService {

    @Autowired
    public QuestionnairServiceImpl(final QuestionnairRepository questionnairRepository) {
        super(questionnairRepository);
    }

    @Override
    public Questionnair save(final Questionnair questionnair) {
        Questionnair existing = null;
        if (questionnair.isNew()) {
            questionnair.setStatus(EntityStatus.DRAFT);
            existing = repository.save(questionnair);
        } else {
            existing = repository.findOne(questionnair.getId());
        }
        return existing;
    }
}
