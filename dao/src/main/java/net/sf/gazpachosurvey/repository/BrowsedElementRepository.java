package net.sf.gazpachosurvey.repository;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.repository.support.GenericRepository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrowsedElementRepository extends GenericRepository<BrowsedElement> {
    @Query("select e from BrowsedElement e left join e.respondent r where e.createdDate = "
            + "(select max(e1.createdDate) from BrowsedElement e1 left join e1.respondent r where r.id = :respondentId and e1.createdDate < :actualDate ) "
            + " and r.id = :respondentId")
    BrowsedElement findPrevious(@Param("respondentId")
    Integer respondentId, @Param("actualDate")
    DateTime last);

    @Query("select e from BrowsedElement e left join e.respondent r where e.createdDate = "
            + "(select min(e1.createdDate) from BrowsedElement e1 left join e1.respondent r where r.id = :respondentId and e1.createdDate > :actualDate ) "
            + " and r.id = :respondentId")
    BrowsedElement findNext(@Param("respondentId")
    Integer respondentId, @Param("actualDate")
    DateTime last);

    @Query("select e from BrowsedElement e left join e.respondent r where r.id = :respondentId and e.last = true")
    BrowsedElement findLast(@Param("respondentId")
    Integer respondentId);
}
