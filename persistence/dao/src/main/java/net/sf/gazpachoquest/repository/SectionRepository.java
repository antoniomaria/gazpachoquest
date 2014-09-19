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

import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.repository.support.GenericRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends GenericRepository<Section> {
    @Query("select qg from QuestionnaireDefinition s join s.sections qg where s.id = :questionnaireDefinition order by index(qg)")
    List<Section> findByQuestionnairDefinitionId(@Param("questionnaireDefinition")
    Integer questionnairDefinitionId);

    @Query("select qg from QuestionnaireDefinition s join s.sections qg where s.id = :questionnaireDefinition and index(qg) = :position")
    Section findOneByPositionInQuestionnairDefinition(@Param("questionnaireDefinition")
    Integer questionnairDefinitionId, @Param("position")
    Integer position);

    @Query("select index(qg) from QuestionnaireDefinition s join s.sections qg where qg.id = :sectionId")
    Integer positionInQuestionnairDefinition(@Param("sectionId")
    Integer sectionId);
}
