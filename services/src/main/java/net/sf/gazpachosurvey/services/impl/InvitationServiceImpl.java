package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.support.Invitation;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.services.InvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitationServiceImpl extends AbstractPersistenceService<Invitation> implements InvitationService {

    @Autowired
    protected InvitationServiceImpl(InvitationRepository repository) {
        super(repository);
    }

    @Override
    public Invitation save(Invitation entity) {
        Invitation fetched = null;
        if (entity.isNew()) {
            fetched = repository.save(entity);
        } else {
            fetched = repository.findOne(entity.getId());
            fetched.setToken(entity.getToken());
            fetched.setStatus(entity.getStatus());
        }
        return fetched;
    }

}
