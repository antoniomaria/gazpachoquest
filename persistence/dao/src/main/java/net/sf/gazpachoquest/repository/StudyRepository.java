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

import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends GenericRepository<Study> {

    @Query("select distinct s from Study s join s.questionnairs q join q.questionnairDefinition qd where qd.id = :questionnairDefinitionId")
    List<Study> findByQuestionnairDefinition(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

}
