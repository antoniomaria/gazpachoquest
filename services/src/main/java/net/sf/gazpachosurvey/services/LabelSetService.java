package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.dto.LabelSetDTO;

public interface LabelSetService extends PersistenceService<LabelSetDTO> {

    public LabelSet save(LabelSet labelSet) ;
}
