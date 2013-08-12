package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;

public interface LabelSetService extends PersistenceService<LabelSetDTO, Integer> {

    Integer addLabelSet(LabelSetDTO labelSet);

    Integer addLabel(Integer labelSetId, LabelDTO label);
}