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
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends GenericRepository<Question> {
    @Query("select q from QuestionGroup qg join qg.questions q where qg.id = :questionGroupId order by index(q)")
    List<Question> findByQuestionGroupId(@Param("questionGroupId")
    Integer questionGroupId);

    @Query("select q from QuestionnairDefinition s join s.questionGroups qg join fetch qg.questions q where s.id = :questionnairDefinition order by index(qg),index(q)")
    List<Question> findByQuestionnairId(@Param("questionnairDefinition")
    Integer questionnairDefinitionId);
    
    @Query("select q from Question q where q.id in :questionIds")
    List<Question> findInList(@Param("questionIds")
    List<Integer> questionIds);

    @Query("select q from QuestionGroup qg join qg.questions q where qg.id = :questionGroupId and index(q) = :position")
    Question findOneByPositionInQuestionGroup(@Param("questionGroupId")
    Integer questionGroupId, @Param("position")
    Integer position);

    @Query("select index(q) from QuestionGroup qg join qg.questions q where q.id = :questionId")
    Integer findPositionInQuestionGroup(@Param("questionId")
    Integer questionId);

}
