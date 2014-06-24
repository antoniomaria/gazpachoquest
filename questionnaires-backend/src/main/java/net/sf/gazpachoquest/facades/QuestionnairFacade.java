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
package net.sf.gazpachoquest.facades;

import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

public interface QuestionnairFacade {

    QuestionnairDTO findOne(Integer questionnairId);

    PageDTO resolvePage(Integer questionnairId, RenderingMode mode, NavigationAction action);

    void saveAnswer(Integer questionnairId, String questionCode, Answer answer);

}
