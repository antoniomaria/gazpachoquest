package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.domain.core.Participant;
import net.sf.gazpachoquest.repository.ParticipantRepository;
import net.sf.gazpachoquest.services.ParticipantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParticipantServiceImpl extends AbstractPersistenceService<Participant> implements ParticipantService {

    @Autowired
    public ParticipantServiceImpl(final ParticipantRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Participant save(final Participant entity) {
        Participant existing = null;
        if (entity.isNew()) {
            existing = repository.save(entity);
        } else {
            existing = repository.findOne(entity.getId());
            existing.setEmail(entity.getEmail());
            existing.setFirstname(entity.getFirstname());
            existing.setGender(entity.getGender());
            existing.setLastname(entity.getLastname());
            existing.setPreferedLanguage(entity.getPreferedLanguage());
        }
        return existing;
    }

}
