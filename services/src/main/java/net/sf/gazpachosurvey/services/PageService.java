package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.PageDTO;

public interface PageService {
    Integer addPage(Integer surveyId, PageDTO page);
}
