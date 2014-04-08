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

import net.sf.gazpachoquest.domain.core.BrowsedElement;

import org.joda.time.DateTime;

public interface BrowsedElementService extends PersistenceService<BrowsedElement> {

    BrowsedElement findLast(Integer respondentId);

    BrowsedElement findNext(Integer respondentId, DateTime lastAccess);

    BrowsedElement findPrevious(Integer respondentId, DateTime lastAccess);

}
