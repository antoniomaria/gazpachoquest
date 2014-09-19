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

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionnaireDefinitionRepository extends GenericRepository<QuestionnaireDefinition> {

    /**
     * Returns questions count group by question group for a given
     * questionnaireDefinitionId
     * 
     * <pre>
     * [11, 2, 0] = [sectionId, questionCount, order_in_questionnair]
     * [10, 3, 1]
     * [9, 2, 2]
     * </pre>
     * 
     * @param questionnaireDefinitionId
     * @return
     */
    @Query("select qg.id,count(q.id),index(qg) from QuestionnaireDefinition qd left join qd.sections qg left join qg.questions q where qd.id = :questionnaireDefinitionId group by qg.id order by index(qg)")
    List<Object[]> questionsCountGroupBySections(@Param("questionnaireDefinitionId")
    Integer questionnaireDefinitionId);

    @Query("select count(q) from QuestionnaireDefinition qd left join qd.sections qg left join qg.questions q where qd.id = :questionnaireDefinitionId")
    Integer questionsCount(@Param("questionnaireDefinitionId")
    Integer questionnaireDefinitionId);

    @Query("select q from QuestionnaireDefinition qd left join qd.sections qg left join qg.questions q where qd.id = :questionnaireDefinitionId")
    List<Question> getQuestions(@Param("questionnaireDefinitionId")
    Integer questionnaireDefinitionId);

}
