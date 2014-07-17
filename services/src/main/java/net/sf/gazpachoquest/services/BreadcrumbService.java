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
package net.sf.gazpachoquest.services;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;

public interface BreadcrumbService extends PersistenceService<Breadcrumb> {

    List<Object[]> findLastAndPosition(Integer questionnairId);

    Breadcrumb findByQuestionnairIdAndPosition(Integer questionnairId, Integer position);

    Integer countByQuestionnair(Integer questionnairId);

}
