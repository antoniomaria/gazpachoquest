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

import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionnairDefinitionRepository extends GenericRepository<QuestionnairDefinition> {

    /**
     * Returns questions count group by question group for a given
     * questionnairDefinitionId
     * 
     * <pre>
     * [11, 2, 0] = [questionGroupId, questionCount, order_in_questionnair]
     * [10, 3, 1]
     * [9, 2, 2]
     * </pre>
     * 
     * @param questionnairDefinitionId
     * @return
     */
    @Query("select qg.id,count(q.id),index(qg) from QuestionnairDefinition qd left join qd.questionGroups qg left join qg.questions q where qd.id = :questionnairDefinitionId group by qg.id order by index(qg)")
    List<Object[]> questionsCountGroupByQuestionGroups(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

    @Query("select count(q) from QuestionnairDefinition qd left join qd.questionGroups qg left join qg.questions q where qd.id = :questionnairDefinitionId")
    Integer questionsCount(@Param("questionnairDefinitionId")
    Integer questionnairDefinitionId);

}
