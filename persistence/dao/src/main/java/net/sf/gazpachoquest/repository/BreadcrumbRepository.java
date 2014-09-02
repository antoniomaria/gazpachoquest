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

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BreadcrumbRepository extends GenericRepository<Breadcrumb> {
    @Query("select b, index(b) from Questionnaire q left join q.breadcrumbs b where q.id = :questionnaireId and b.last = true")
    List<Object[]> findLastAndPosition(@Param("questionnaireId")
    Integer questionnaireId);

    @Query("select b from Questionnaire q left join q.breadcrumbs b where q.id = :questionnaireId and index(b) = :position")
    Breadcrumb findByquestionnaireIdAndPosition(@Param("questionnaireId")
    Integer questionnaireId, @Param("position")
    Integer position);

    /*-
    @Query("select e from Breadcrumb e left join e.questionnair r where e.createdDate = "
            + "(select max(e1.createdDate) from Breadcrumb e1 left join e1.questionnair r where r.id = :questionnaireId and e1.createdDate < :actualDate ) "
            + " and r.id = :questionnaireId")
    Breadcrumb findPrevious(@Param("questionnaireId")
    Integer respondentId, @Param("actualDate")
    DateTime last);*/
}
