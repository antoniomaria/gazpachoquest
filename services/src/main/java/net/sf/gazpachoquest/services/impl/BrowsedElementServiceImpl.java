package net.sf.gazpachoquest.services.impl;

import net.sf.gazpachoquest.repository.BrowsedElementRepository;
import net.sf.gazpachoquest.services.BrowsedElementService;
import net.sf.gazpachosurvey.domain.core.BrowsedElement;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrowsedElementServiceImpl extends AbstractPersistenceService<BrowsedElement> implements
        BrowsedElementService {

    @Autowired
    protected BrowsedElementServiceImpl(final BrowsedElementRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public BrowsedElement findLast(final Integer respondentId) {
        return ((BrowsedElementRepository) repository).findLast(respondentId);
    }

    @Override
    @Transactional(readOnly = true)
    public BrowsedElement findNext(final Integer respondentId, final DateTime lastAccess) {
        return ((BrowsedElementRepository) repository).findNext(respondentId, lastAccess);
    }

    @Override
    @Transactional(readOnly = true)
    public BrowsedElement findPrevious(final Integer respondentId, final DateTime lastAccess) {
        return ((BrowsedElementRepository) repository).findPrevious(respondentId, lastAccess);
    }

    @Override
    @Transactional(readOnly = false)
    public BrowsedElement save(final BrowsedElement entity) {
        BrowsedElement fetched = null;
        if (entity.isNew()) {
            fetched = repository.save(entity);
        } else {
            fetched = repository.findOne(entity.getId());
            // Others properties are ignored. BrowsedElement is an inmutable
            // object
            fetched.setLast(entity.isLast());
        }
        return fetched;
    }
}
