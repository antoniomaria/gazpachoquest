package net.sf.gazpachosurvey.services;

import org.joda.time.DateTime;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;

public interface BrowsedElementService extends PersistenceService<BrowsedElement>{

    BrowsedElement findLast(Integer respondentId);

    BrowsedElement findNext(Integer respondentId, DateTime lastAccess);

    BrowsedElement findPrevious(Integer respondentId, DateTime lastAccess);

}
