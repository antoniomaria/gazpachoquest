package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;

public interface PageService extends LocalizedPersistenceService<PageDTO> {
    PageDTO addPage(Integer surveyId, PageDTO page);
}
