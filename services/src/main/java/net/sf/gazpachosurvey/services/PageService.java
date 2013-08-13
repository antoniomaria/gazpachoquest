package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;

public interface PageService extends PersistenceService<PageDTO, Integer> {
    Integer addPage(Integer surveyId, PageDTO page);
}
