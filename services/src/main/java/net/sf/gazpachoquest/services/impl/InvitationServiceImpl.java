package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.repository.InvitationRepository;
import net.sf.gazpachoquest.services.InvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvitationServiceImpl extends AbstractPersistenceService<Invitation> implements InvitationService {

    @Autowired
    protected InvitationServiceImpl(final InvitationRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = false)
    public Invitation save(final Invitation entity) {
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
