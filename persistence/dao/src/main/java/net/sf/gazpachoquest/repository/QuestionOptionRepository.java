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

import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.repository.support.GenericRepository;
import net.sf.gazpachoquest.types.Language;

public interface QuestionOptionRepository extends GenericRepository<QuestionOption> {

    @Query("select qo,qot from Question q left join q.questionOptions qo left join qo.translations qot where qot.language = :language and qo.id in :questionOptionIds order by index(qo)")
    List<Object[]> findInList(@Param("questionOptionIds")
    List<Integer> questionOptionIds, @Param("language")
    Language language);

}
