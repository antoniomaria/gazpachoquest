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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.repository.support.GenericRepository;

public interface QuestionnairDefinitionRepository extends GenericRepository<QuestionnairDefinition> {

    // @Query("select qg.id,count(q.id) from QuestionGroup qg left join qg.questions q group by qg.id")
    @Query("select qg.id,count(q.id) from QuestionGroup qg left join qg.questions q left join qg.questionnairDefinition qd where qd.id = :questionnairDefinitionId group by qg.id")
    List<Object[]> questionCount(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

}
