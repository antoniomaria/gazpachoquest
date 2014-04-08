/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository;

import net.sf.gazpachoquest.domain.core.BrowsedElement;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrowsedElementRepository extends GenericRepository<BrowsedElement> {
    @Query("select e from BrowsedElement e left join e.questionnair q where q.id = :questionnairId and e.last = true")
    BrowsedElement findLast(@Param("questionnairId")
    Integer questionnairId);

    @Query("select e from BrowsedElement e left join e.questionnair r where e.createdDate = "
            + "(select min(e1.createdDate) from BrowsedElement e1 left join e1.questionnair r where r.id = :questionnairId and e1.createdDate > :actualDate ) "
            + " and r.id = :questionnairId")
    BrowsedElement findNext(@Param("questionnairId")
    Integer questionnairId, @Param("actualDate")
    DateTime last);

    @Query("select e from BrowsedElement e left join e.questionnair r where e.createdDate = "
            + "(select max(e1.createdDate) from BrowsedElement e1 left join e1.questionnair r where r.id = :questionnairId and e1.createdDate < :actualDate ) "
            + " and r.id = :questionnairId")
    BrowsedElement findPrevious(@Param("questionnairId")
    Integer respondentId, @Param("actualDate")
    DateTime last);
}
