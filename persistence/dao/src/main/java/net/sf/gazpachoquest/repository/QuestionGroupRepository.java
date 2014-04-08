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

import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionGroupRepository extends GenericRepository<QuestionGroup> {
    @Query("select qg from QuestionnairDefinition s join s.questionGroups qg where s.id = :questionnairDefinition order by index(qg)")
    List<QuestionGroup> findByQuestionnairDefinitionId(@Param("questionnairDefinition")
    Integer questionnairDefinitionId);

    @Query("select qg from QuestionnairDefinition s join s.questionGroups qg where s.id = :questionnairDefinition and index(qg) = :position")
    QuestionGroup findOneByPositionInQuestionnairDefinition(@Param("questionnairDefinition")
    Integer questionnairDefinitionId, @Param("position")
    Integer position);

    @Query("select index(qg) from QuestionnairDefinition s join s.questionGroups qg where qg.id = :questionGroupId")
    Integer findPositionInQuestionnairDefinition(@Param("questionGroupId")
    Integer questionGroupId);
}
