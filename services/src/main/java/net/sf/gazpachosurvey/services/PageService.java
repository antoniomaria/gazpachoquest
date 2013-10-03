package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.PageLanguageSettingsDTO;

public interface PageService extends LocalizedPersistenceService<PageDTO, PageLanguageSettingsDTO> {
    PageDTO addPage(Integer surveyId, PageDTO page);
}
