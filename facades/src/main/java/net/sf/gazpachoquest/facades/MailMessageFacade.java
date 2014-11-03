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

import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.embeddables.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;

public interface MailMessageFacade {

    MailMessageTemplateDTO save(MailMessageTemplateDTO mailMessageTemplate);

    TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> saveTranslation(
            TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> translation);

}
