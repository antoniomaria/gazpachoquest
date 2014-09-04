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
package net.sf.gazpachoquest.questionnaire.resolver;

import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.questionnaire.support.PageStructure;
import net.sf.gazpachoquest.types.NavigationAction;

public interface PageResolver {

    PageStructure resolveNextPage(Questionnaire questionnaire, NavigationAction action);

}
