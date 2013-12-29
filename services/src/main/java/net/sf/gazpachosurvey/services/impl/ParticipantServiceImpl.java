package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.Participant;
import net.sf.gazpachosurvey.repository.ParticipantRepository;
import net.sf.gazpachosurvey.services.ParticipantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl extends AbstractPersistenceService<Participant> implements ParticipantService {

    @Autowired
    public ParticipantServiceImpl(final ParticipantRepository repository) {
        super(repository);
    }

    @Override
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
