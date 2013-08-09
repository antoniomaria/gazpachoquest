package net.sf.gazpachosurvey.services;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;

public interface LabelSetService {

    Integer addLabelSet(LabelSetDTO labelSet);

    Integer addLabel(Integer labelSetId, LabelDTO label);
}
