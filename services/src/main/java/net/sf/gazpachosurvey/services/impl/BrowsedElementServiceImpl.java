package net.sf.gazpachosurvey.services.impl;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestionGroup;
import net.sf.gazpachosurvey.repository.BrowsedElementRepository;
import net.sf.gazpachosurvey.services.BrowsedElementService;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowsedElementServiceImpl extends AbstractPersistenceService<BrowsedElement> implements BrowsedElementService   {

    @Autowired
    protected BrowsedElementServiceImpl(BrowsedElementRepository repository) {
        super(repository);
    }
    
    @Override
    public BrowsedElement save(BrowsedElement entity) {
        BrowsedElement fetched = null;
        if (entity.isNew()) {
            fetched = repository.save(entity);
        } else {
            fetched = repository.findOne(entity.getId());
            // Others properties are ignored. BrowsedElement is an inmutable object
            fetched.setLast(entity.isLast());
        }
        return fetched;
    }
    @Override
    public BrowsedElement findLast(Integer respondentId) {
       return ((BrowsedElementRepository) repository).findLast(respondentId);
    }
    
    @Override
    public BrowsedElement findNext(Integer respondentId, DateTime lastAccess) {
       return ((BrowsedElementRepository) repository).findNext(respondentId, lastAccess);
    }
    @Override
    public BrowsedElement findPrevious(Integer respondentId, DateTime lastAccess) {
        return ((BrowsedElementRepository) repository).findPrevious(respondentId, lastAccess);
     }
}
